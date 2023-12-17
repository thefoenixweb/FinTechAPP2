package com.enviro.assessment.grad001.TshepisoMolefi.controllers;

import com.enviro.assessment.grad001.TshepisoMolefi.helpers.Token;
import com.enviro.assessment.grad001.TshepisoMolefi.models.User;
import com.enviro.assessment.grad001.TshepisoMolefi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    //Login View
    @GetMapping("/login")
    public ModelAndView getLogin(){
        System.out.println("In Login Page Controller");
        ModelAndView getLoginPage = new ModelAndView("login");
        // Set Token String:
        String token = Token.generateToken();
        // Send Token to View:
        getLoginPage.addObject("token", token);
        getLoginPage.addObject("PageTitle", "Login");
        return getLoginPage;
    }

    @PostMapping("/login")
    public String login(@RequestParam("user1")String user1,
                        @RequestParam("password") String password,
                        @RequestParam("_token")String token,
                        Model model,
                        HttpSession session){

        //INPUT FIELDS / FORM DATA:
        if(user1.isEmpty() || user1 == null || password.isEmpty() || password == null){
            model.addAttribute("error", "Username or Password Cannot be Empty");
            return "login";
        }

        //  CHECK IF USERNAME EXISTS:
        String getUserNameInDatabase = userRepository.getUserName(user1);

       
        if(getUserNameInDatabase != null ){
            // Get Password In Database:
            String getPasswordInDatabase = userRepository.getUserPassword(getUserNameInDatabase);

            // Validate Password:
            if(!BCrypt.checkpw(password, getPasswordInDatabase)){
                model.addAttribute("error", "Incorrect Username or Password");
                return "login";
            }
            // End Of Validate Password.
        }else{
            model.addAttribute("error", "Something went wrong please contact support");
            return "error";
        }
     

        //PROCEED TO LOG THE USER IN:
        User user = userRepository.getUserDetails(getUserNameInDatabase);

        // Set Session Attributes:
        session.setAttribute("user", user);
        session.setAttribute("token", token);
        session.setAttribute("authenticated", true);

        return "redirect:/app/dashboard";

    }
    // End Of Authentication Method.

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes){
        session.invalidate();
        redirectAttributes.addFlashAttribute("logged_out", "Logged out successfully");
        return "redirect:/login";
    }

}
