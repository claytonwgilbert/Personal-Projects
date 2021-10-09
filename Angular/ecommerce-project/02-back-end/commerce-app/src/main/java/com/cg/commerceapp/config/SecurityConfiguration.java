package com.cg.commerceapp.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // - protect our api/orders endpoint...only authorized users can request order history
        http.authorizeRequests()
                .antMatchers("/api/orders/**")
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();

        // - add support for CORS filter
        http.cors();

        // - custom unauthorized message for 401 errors
        Okta.configureResourceServer401ResponseBody(http);

        // - disable CSRF to allow us to POST and bypass default security protection. Use of cookies is needed for this
        // not to be needed.
        http.csrf().disable();
    }
}
