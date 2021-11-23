package com.cg.shopme.admin.user;

import com.cg.shopme.common.entity.Role;
import com.cg.shopme.common.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public User saveNewUser(User user){
        return userRepository.save(user);
    }

    public List<Role> getAllRoles(){
        return (List<Role>) roleRepository.findAll();
    }



}
