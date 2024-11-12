package org.mysecurityproject.springbootwithh2db.Controller;

import org.mysecurityproject.springbootwithh2db.DTO.CustomerDTO;
import org.mysecurityproject.springbootwithh2db.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/save")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomer(customerDTO);
    }

    @GetMapping(value = "/get-all-customers")
    public Page<CustomerDTO> getAllCustomers(Pageable pageable){
        return customerService.getAllCustomers(pageable);
    }
}
