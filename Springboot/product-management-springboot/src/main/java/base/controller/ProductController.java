package base.controller;

import base.model.Product;
import base.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product){
        iProductService.save(product);
        ModelAndView modelAndView =new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New Product Added");
        return modelAndView;
    }
    @GetMapping("/products")
    public ModelAndView listProducts(){
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("product", iProductService.findAll());
        return modelAndView;
    }
    @GetMapping("/update/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        Optional<Product> product = iProductService.findById(id);
        if(product.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/product/update");
            modelAndView.addObject("product", product.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }
    @PostMapping("/update")
    public ModelAndView updateProduct(@ModelAttribute("product") Product product){
        iProductService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/update");
        modelAndView.addObject("product", product);
        modelAndView.addObject("message", "Product updated");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id){
        Optional<Product> product = iProductService.findById(id);
        if(product.isPresent()){
            ModelAndView modelAndView =new ModelAndView("/product/delete");
            modelAndView.addObject("product", product.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }
    @PostMapping("/delete")
    public String deleteProduct(@ModelAttribute("product") Product product){
        iProductService.delete(product.getId());
        return "redirect:/products";
    }
}
