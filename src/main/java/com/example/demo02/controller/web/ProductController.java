package com.example.demo02.controller.web;

import com.example.demo02.entity.Category;
import com.example.demo02.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    public List<Category> getCategories() {
        // add some sample categories using List of Category
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(100L,"cate 1", "Category 1"));
        categories.add(new Category(200L, "cate 2", "Category 2"));
        categories.add(new Category(300L,"cate 3", "Category 3"));
        categories.add(new Category(400L, "cate 4", "Category 4"));
        categories.add(new Category(500L, "cate 5", "Category 5"));

        return categories;

    }

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

        model.addAttribute("categories", getCategories());

        return "product-form";
    }

    @PostMapping("/edit")
    public String save(@ModelAttribute Product product, Model model) {
        model.addAttribute("pname", product.getName() + " đã thay đổi!");
        model.addAttribute("msg", "Product saved successfully!");

        return "result";
    }
}
