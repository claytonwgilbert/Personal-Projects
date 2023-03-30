package com.cg.eazyschool.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

//Used in conjunction with @ConfigurationProperties annotation and application.properties file as these properties will be injected automatically from the properties file
@Component("eazySchoolProps")
@Data
@ConfigurationProperties(prefix = "eazyschool")
@Validated
public class EazySchoolProps {
    //Putting validation on what we can set our properties to
    @Min(value=5, message="must be between 5 and 25")
    @Max(value=25, message="must be between 5 and 25")
    private int pageSize;
    private Map<String, String> contact; //The key will be the name specified and the value will be the value of the name defined in properties file
    private List<String> branches;
}
