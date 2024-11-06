package ra.baitap01.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.baitap01.model.entity.Account;
import ra.baitap01.model.entity.Product;
import ra.baitap01.service.IAccountService;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("accounts", accountService.findAll());
        return "listAccount";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("account", new Account());
        return "addAccount";
    }

    @PostMapping("/add")
    public String doAdd(@Valid @ModelAttribute("account") Account account, BindingResult bindingResul, Model model) {
        if (bindingResul.hasErrors()) {
            model.addAttribute("account", account);
            return "addAccount";
        }
        accountService.save(account);
        return "redirect:/account/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("account", accountService.findById(id));
        return "editAccount";
    }

    @PostMapping("/edit")
    public String doEdit(@Valid @ModelAttribute("account") Account account, Model model) {
        accountService.save(account);
        return "redirect:/account/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        accountService.deleteById(id);
        return "redirect:/account/list";
    }
}
