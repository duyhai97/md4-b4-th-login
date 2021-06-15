package controller;


import dao.UserDao;
import model.Login;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("login",new Login());
        return modelAndView;
    }

    @PostMapping("/login")
    public String login(Login login, Model model){
        User user = UserDao.checkLogin(login);
        if(user == null){

            return "error";
        } else {
           model.addAttribute("user", user);
            return "user";
        }
    }
}