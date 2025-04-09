package com.codegym.demo.controller;


import com.codegym.demo.model.Product;
import com.codegym.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manageProduct")
public class ManageProductController {

    @Autowired
    private final IProductService productService;

    public ManageProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String manageProduct(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "manageProduct/list";
    }

    @GetMapping("/{productID}/showUpdateForm")
    public String showUpdateForm(@PathVariable("productID") int productID, Model model) {
        model.addAttribute("product", productService.getProductById(productID));
        return "manageProduct/edit";
    }

    @GetMapping("/{productID}/showProductDetail")
    public String showProductDetail(@PathVariable("productID") int productID, Model model) {
        model.addAttribute("product", productService.getProductById(productID));
        return "manageProduct/info";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "manageProduct/add";
    }

    @PostMapping("/{productID}/deleteProduct")
    public String deleteProduct(@PathVariable("productID") int productID, Model model) {
        productService.deleteProduct(productID);
        return "redirect:/manageProduct";
    }

    @PostMapping("/searchProduct")
    public String searchProduct(@RequestParam("keyword") String keyword, Model model) {
        List<Product> products = productService.getProductsByName(keyword);
        if(products.isEmpty()) {
            model.addAttribute("error","Không có sản phẩm phù hợp .");
        }
        model.addAttribute("products", products);
        return "manageProduct/list";
    }
    @PostMapping("/add")
    public String addProduct(Product product, Model model) {
        productService.addProduct(product);
        return "redirect:/manageProduct";
    }
    @PostMapping("/update")
    public String updateProduct(Product product, Model model) {
        productService.updateProduct(product);
        return "redirect:/manageProduct";
    }

}
