package com.example.demo02.controller.web;

import com.example.demo02.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public String list(Model model) {
        model.addAttribute("message", "Hello, this is a message from the ProductController!");
        List<Product> products = new ArrayList<>();

        //add some sample products
        products.add(new Product("1", "Product 1", 10.0));
        products.add(new Product("2", "Product 2", 20.0));
        products.add(new Product("3", "Product 3", 30.0));
        products.add(new Product("4", "Product 4", 40.0));
        products.add(new Product("5", "Product 5", 50.0));

        //add more random products
        for (int i = 6; i <= 20; i++) {
            products.add(new Product(String.valueOf(i), "Product " + i, i * 10.0));
        }
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        //TODO: dùng service để lấy sản phẩm theo id bằng database, làm sau, giờ hardcode

        if(id.equals("1")) {
            model.addAttribute("product", new Product("1", "Product 1", 10.0));
        } else if(id.equals("2")) {
            model.addAttribute("product", new Product("2", "Product 2", 20.0));
        } else if(id.equals("3")) {
            model.addAttribute("product", new Product("3", "Product 3", 30.0));
        } else {
            model.addAttribute("product", new Product(id, "Product " + id, Double.parseDouble(id) * 10.0));
        }
        return "product-form";
    }
}
