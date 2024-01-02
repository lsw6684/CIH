package spring.cih.Account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/sign-up")
    public String signUpForm(Model model) {
        model.addAttribute( new SignUpForm()); // attribute 네임 안 써도 됨.
        return "account/sign-up";
    }
}
