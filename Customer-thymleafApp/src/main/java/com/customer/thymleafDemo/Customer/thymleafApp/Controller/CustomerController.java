package com.customer.thymleafDemo.Customer.thymleafApp.Controller;

import com.customer.thymleafDemo.Customer.thymleafApp.Model.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @GetMapping("/")
    public String showForm (Model themodel){

        themodel.addAttribute("customer",new Customer());

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String ProcessForm(
        @Valid @ModelAttribute("customer") Customer customer,
                BindingResult theBindingResult
        ){
        if(theBindingResult.hasErrors()){
            return "customer-form";
        }
        return "customer-confirmation";
    }
}
