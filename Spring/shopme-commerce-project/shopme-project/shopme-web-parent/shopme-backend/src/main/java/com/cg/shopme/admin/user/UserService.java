package com.cg.shopme.admin.user;

import com.cg.shopme.common.entity.Role;
import com.cg.shopme.common.entity.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    public static final int USERS_PER_PAGE = 4;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll(Sort.by("firstName").ascending());
    }

    public Page<User> listByPage(int pageNum, String sortField, String sortDir, String keywordSearch){
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();

        Pageable pageable = PageRequest.of(pageNum - 1, USERS_PER_PAGE, sort);

        if(keywordSearch != null){
            return userRepository.findUsersThroughSearch(keywordSearch, pageable);
        }
        return userRepository.findAll(pageable);
    }

    public User saveNewUser(User user){
        boolean isUpdatingUser = (user.getId() != null);
        if(isUpdatingUser){
            if(user.getPassword().isEmpty()){
                user.setPassword(userRepository.findById(user.getId()).get().getPassword());
            }else{
                encodePassword(user);
            }
        }else{
            encodePassword(user);
        }
        return userRepository.save(user);
    }

    private void encodePassword(User user){
        String protectedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(protectedPassword);
    }

    public List<Role> getAllRoles(){
        return (List<Role>) roleRepository.findAll();
    }

    public boolean checkIfEmailIsUnique(Integer id, String email){
        User userWithExistingEmail = userRepository.findByEmail(email);
        if(userWithExistingEmail == null) return true; // - User is not already in db, unique email is true
        boolean isCreatingNewUser = (id == null); // - Creating new user, not editing existing one
        if(isCreatingNewUser){
            if(userWithExistingEmail != null) return false; // - User exists...stop
        }else{
            if(userWithExistingEmail.getId() != id) return false; // - User from db doesn't match id passed in...stop
        }
        return true; // - If we pass all conditions...email is unique and passes
    }

    public User findUserById(int userId) throws UserNotFoundException{
        try {
            return userRepository.findById(userId).get();
        }catch (NoSuchElementException ex){
            throw new UserNotFoundException("User with id of " + userId + " was not found within the system.");
        }
    }

    public void deleteUser(int userId) throws UserNotFoundException{
            Long count = userRepository.countById(userId);
            if(count == 0) throw new UserNotFoundException("User with id of " + userId + " was not able to be deleted.");

            userRepository.deleteById(userId);
    }

    public void updateUserStatus(int userId, boolean enabledStatus){
        userRepository.updateEnabledStatus(userId, enabledStatus);
    }


    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User updateUserAccount(User userFromForm){
        User userFromDb = userRepository.findByEmail(userFromForm.getEmail());
        if (!userFromForm.getPassword().isEmpty()) {
            userFromDb.setPassword(userFromForm.getPassword());
        }
        encodePassword(userFromDb);
        if (userFromForm.getPhotos() != null){
            userFromDb.setPhotos(userFromForm.getPhotos());
        }
        userFromDb.setFirstName(userFromForm.getFirstName());
        userFromDb.setLastName(userFromForm.getLastName());

        return userRepository.save(userFromDb);
    }
}
