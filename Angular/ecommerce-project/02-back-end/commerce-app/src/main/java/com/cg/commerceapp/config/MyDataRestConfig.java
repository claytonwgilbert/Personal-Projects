package com.cg.commerceapp.config;

import com.cg.commerceapp.entity.Country;
import com.cg.commerceapp.entity.Product;
import com.cg.commerceapp.entity.ProductCategory;
import com.cg.commerceapp.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // - Actions we don't want supported...
        HttpMethod[] unsupportedActions = {HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT};

        // - Lockdown Product repository to only GET calls
        disableHttpMethods(Product.class, config, unsupportedActions);

        // - Lockdown ProductCategory repository to only GET calls
        disableHttpMethods(ProductCategory.class, config, unsupportedActions);

        // - Lockdown Country repository to only GET calls
        disableHttpMethods(Country.class, config, unsupportedActions);

        // - Lockdown State repository to only GET calls
        disableHttpMethods(State.class, config, unsupportedActions);


        // - Call internal helper method to expose id of categories
        exposedIds(config);
    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] unsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));
    }

    private void exposedIds(RepositoryRestConfiguration config){

        // - Get a list of all entity class from entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // - Setup array for entity types
        List<Class> entityClasses = new ArrayList<>();

        // - Grab the entity types from each entity
        for(EntityType entity : entities ){
            entityClasses.add(entity.getJavaType());
        }

        // - Expose the entity Ids for retrieval on the front end
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}
