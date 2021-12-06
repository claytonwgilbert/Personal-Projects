package com.cg.shopme.admin;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer { // - Used to expose user photos saved to the db to the front end for display

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String dirName = "user-photos";
        Path userPhotosDir = Paths.get(dirName);

        String userPhotosPath = userPhotosDir.toFile().getAbsolutePath();

        // - Allows frontend to access the url and retrieve access to photos
        registry.addResourceHandler("/" + dirName + "/**")
                .addResourceLocations("file:/" + userPhotosPath + "/");
    }
}
