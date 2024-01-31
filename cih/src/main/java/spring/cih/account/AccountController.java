package spring.cih.account;

import jakarta.validation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import spring.cih.domain.Account;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final SignUpFormValidator signUpFormValidator;
    private final AccountService accountService;

    @InitBinder("signUpForm")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(signUpFormValidator);
    }


    @GetMapping("/sign-up")
    public String signUpForm(Model model) {
        model.addAttribute( new SignUpForm()); // attribute 네임 안 써도 됨.
        return "account/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUpSubmit(@Valid SignUpForm signUpForm, Errors errors) { // 복합 객체 @ModelAttribute 생략 가능
        if(errors.hasErrors()) {
            return "account/sign-up";
        }

        accountService.processNewAccount(signUpForm);
        // TODO 회원 가입 처리
        return "redirect:/";
    }


}
