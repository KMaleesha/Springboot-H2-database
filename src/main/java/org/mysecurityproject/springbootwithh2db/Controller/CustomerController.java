package org.mysecurityproject.springbootwithh2db.Controller;

import org.mysecurityproject.springbootwithh2db.DTO.CustomerDTO;
import org.mysecurityproject.springbootwithh2db.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping(value = "/get-by-id/{id}")
    public Object getCustomerById(@PathVariable Long id){
        Optional<CustomerDTO> customer = customerService.getCustomerById(id);
        if (customer.isPresent()){
            return customer.get();
        }else {
            return "Customer not found";
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable Long id){
        Optional<CustomerDTO> customer = customerService.getCustomerById(id);
       if (customer.isPresent()){
            customerService.deleteCustomer(id);
            return "Customer deleted";
       }else {
           return "Customer not found";
       }
    }

    @PutMapping(value = "/update/{id}")
    public Object updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        Optional<CustomerDTO> existingCustomer = customerService.getCustomerById(id);

        if (existingCustomer.isPresent()) {
            return customerService.updateCustomer(id, customerDTO);
        } else {
            return "Customer not found";
        }
    }

}
