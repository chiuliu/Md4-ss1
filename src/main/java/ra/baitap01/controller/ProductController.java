package ra.baitap01.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.baitap01.model.entity.Product;
import ra.baitap01.service.IProductService;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "listProduct";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/add")
    public String doAdd(@Valid @ModelAttribute("product") Product product,BindingResult bindingResul, Model model) {
        if (bindingResul.hasErrors()) {
            model.addAttribute("product", product);
            return "addProduct";
        }
        productService.save(product);
        return "redirect:/products/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "editProduct";
    }

    @PostMapping("/edit")
    public String doEdit(@Valid @ModelAttribute("product") Product product, Model model) {
        productService.save(product);
        return "redirect:/products/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        productService.deleteById(id);
        return "redirect:/products/list";
    }
}
