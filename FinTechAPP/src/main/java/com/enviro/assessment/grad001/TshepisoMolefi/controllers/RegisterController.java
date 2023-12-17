package com.enviro.assessment.grad001.TshepisoMolefi.controllers;

import com.enviro.assessment.grad001.TshepisoMolefi.helpers.Token;
import com.enviro.assessment.grad001.TshepisoMolefi.models.User;
import com.enviro.assessment.grad001.TshepisoMolefi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Random;


//USER REGISTRATION
@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public ModelAndView getRegister(){
        ModelAndView getRegisterPage = new ModelAndView("register");
        System.out.println("In Register Page Controller");
        getRegisterPage.addObject("PageTitle", "Register");
        return getRegisterPage;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("registerUser")User user,
                                 BindingResult result,
                                 @RequestParam("first_name") String first_name,
                                 @RequestParam("last_name") String last_name,
                                 @RequestParam("user1") String user1,
                                 @RequestParam("password") String password,
                                 @RequestParam("address") String address,
                                 @RequestParam("contact") String contact,
                                 @RequestParam("age") String age,
                                 @RequestParam("confirm_password") String confirm_password) throws MessagingException {

        ModelAndView registrationPage = new ModelAndView("register");

        // Check For Errors:
        if(result.hasErrors() && confirm_password.isEmpty()){
            registrationPage.addObject("confirm_pass", "The confirm Field is required");
            return registrationPage;
        }

        //CHECK FOR PASSWORD MATCH:
        if(!password.equals(confirm_password)){
            registrationPage.addObject("passwordMisMatch", "passwords do not match");
            return registrationPage;
        }

        //GET TOKEN STRING:
        String token = Token.generateToken();

        //GENERATE RANDOM CODE:
        Random rand = new Random();
        int bound = 123;
        int code = bound * rand.nextInt(bound);

      
     
        //HASH PASSWORD:
        String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());

        // REGISTER USER:
        userRepository.registerUser(first_name, last_name, user1, hashed_password, address,contact,age, token, code);

        

        // RETURN TO REGISTER PAGE:
        String successMessage = "Account Registered Successfully!";
        registrationPage.addObject("success", successMessage);
        return registrationPage;
    }


}
