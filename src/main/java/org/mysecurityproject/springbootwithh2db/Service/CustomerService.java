package org.mysecurityproject.springbootwithh2db.Service;

import org.modelmapper.ModelMapper;
import org.mysecurityproject.springbootwithh2db.DTO.CustomerDTO;
import org.mysecurityproject.springbootwithh2db.Entity.Customer;
import org.mysecurityproject.springbootwithh2db.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CustomerDTO saveCustomer(CustomerDTO customerDTO){
        customerRepository.save(modelMapper.map(customerDTO, Customer.class));
        return customerDTO;
    }

    public Page<CustomerDTO> getAllCustomers(Pageable pageable){
        return customerRepository.findAll(pageable).map(customer -> modelMapper.map(customer, CustomerDTO.class));
    }
}
