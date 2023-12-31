package spring.cih.Account;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AccountController {

    @GetMapping("/sign-up")
    public String signUpForm(Model model) {
        return "account/sign-up";
    }
}
