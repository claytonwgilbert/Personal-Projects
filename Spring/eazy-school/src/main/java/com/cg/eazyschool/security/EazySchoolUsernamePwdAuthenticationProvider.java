package com.cg.eazyschool.security;

import com.cg.eazyschool.model.Person;
import com.cg.eazyschool.model.Roles;
import com.cg.eazyschool.repository.PersonRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class EazySchoolUsernamePwdAuthenticationProvider implements AuthenticationProvider {
    private PersonRepository personRepository;
    private PasswordEncoder passwordEncoder;

    public EazySchoolUsernamePwdAuthenticationProvider(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        Person person = personRepository.readByEmail(email);
        if(person != null && person.getPersonId() > 0 && passwordEncoder.matches(password, person.getPwd())){ //Password encoder compares the hashed pw from the db to the plain text one from the form
            //Returning email in our token since we need that email field from the authenticator object in our dashboard controller
            return new UsernamePasswordAuthenticationToken(email, null, getGrantedAuthorities(person.getRoles())); //returning null so that we don't compromise our password by putting it in risk of being intercepted from the security token
        }else{
            throw new BadCredentialsException("Invalid credentials!");
        }
    }
    private List<GrantedAuthority> getGrantedAuthorities(Roles roles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roles.getRoleName()));

        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
