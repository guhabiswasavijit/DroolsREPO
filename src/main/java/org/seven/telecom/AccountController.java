package org.seven.telecom;

import org.seven.telecom.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class AccountController {
	
	@GetMapping(path = "/login")
    public String index(Model model) {
        model.addAttribute("account", new Account());
        return "index";
    }

    @PostMapping(path = "/account")
    public String submit(Account account, Model model) {
        model.addAttribute("account", account);
        return "saved";
    }
}
