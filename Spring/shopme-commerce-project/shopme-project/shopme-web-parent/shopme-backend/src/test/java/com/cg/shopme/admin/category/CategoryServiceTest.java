package com.cg.shopme.admin.category;

import com.cg.shopme.common.entity.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class CategoryServiceTest {
    @MockBean
    private CategoryRepository repository;
    @InjectMocks
    CategoryService service;

    @Test
    public void checkCategoryDuplicateName(){
        Integer id = null;
        String name = "Computers";
        String alias = "abc";
        Category category = new Category(id, name, alias);

        Mockito.when(repository.findByName(name)).thenReturn(category);
        Mockito.when(repository.findByAlias(alias)).thenReturn(null);

        boolean isUnique = service.isCategoryUnique(id, name, alias);

        assertThat(isUnique).isFalse();
    }

    @Test
    public void checkCategoryDuplicateAlias(){
        Integer id = null;
        String name = "abc";
        String alias = "cameras";
        Category category = new Category(id, name, alias);

        Mockito.when(repository.findByName(name)).thenReturn(null);
        Mockito.when(repository.findByAlias(alias)).thenReturn(category);

        boolean isUnique = service.isCategoryUnique(id, name, alias);

        assertThat(isUnique).isFalse();
    }

    @Test
    public void checkCategoryValidReturn(){
        Integer id = null;
        String name = "abc";
        String alias = "cameras";
        Category category = new Category(id, name, alias);

        Mockito.when(repository.findByName(name)).thenReturn(null);
        Mockito.when(repository.findByAlias(alias)).thenReturn(null);

        boolean isUnique = service.isCategoryUnique(id, name, alias);

        assertThat(isUnique).isTrue();
    }

    @Test
    public void checkCategoryDuplicateNameEditMode(){
        Integer id = 1;
        String name = "Computers";
        String alias = "abc";
        Category category = new Category(2, name, alias);

        Mockito.when(repository.findByName(name)).thenReturn(category);
        Mockito.when(repository.findByAlias(alias)).thenReturn(null);

        boolean isUnique = service.isCategoryUnique(id, name, alias);

        assertThat(isUnique).isFalse();
    }

    @Test
    public void checkCategoryDuplicateAliasEditMode(){
        Integer id = 1;
        String name = "abc";
        String alias = "cameras";
        Category category = new Category(2, name, alias);

        Mockito.when(repository.findByName(name)).thenReturn(null);
        Mockito.when(repository.findByAlias(alias)).thenReturn(category);

        boolean isUnique = service.isCategoryUnique(id, name, alias);

        assertThat(isUnique).isFalse();
    }





}
