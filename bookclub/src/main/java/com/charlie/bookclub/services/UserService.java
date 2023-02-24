package com.charlie.bookclub.services;

import java.util.Optional;
    
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
    
import com.charlie.bookclub.models.LoginUser;
import com.charlie.bookclub.models.User;
import com.charlie.bookclub.repositories.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        Optional<User> user = userRepo.findByEmail(newUser.getEmail());

        //Checks to see if the email is in the DB
        if(user.isPresent()){
            result.rejectValue("email", "Email", "Email has already been registered.");
        }

        //Checks to see if password and confirm match
        if(!newUser.getPassword().equals(newUser.getConfirm())){
            result.rejectValue("confirm", "Confirm", "Passwords do not match.");
        }

        //Checks to see if result has errors
        if(result.hasErrors()){
            return null;
        }
        
        //Hash password input using bcrypt
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);

        return userRepo.save(newUser);
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
        
        //! Checking email in DB
        if(!this.checkEmail(newLoginObject.getEmail())){
            result.rejectValue("email", "noEmail", "Invalid login credentials");
        }
        if(result.hasErrors()){
            return null;
        }
        
        //! Email found, checking password
        User user = userRepo.findByEmail(newLoginObject.getEmail()).orElse(null);
        if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())){
            result.rejectValue("password", "Password", "Invalid login credentials");
        }

        if(result.hasErrors()){
            return null;
        }

        return user;
    }

    public boolean checkEmail(String email){
        Optional<User> user = userRepo.findByEmail(email);
        if(user.isPresent()){
            return true;
        }
        else {
            return false;
        }
    }
}
