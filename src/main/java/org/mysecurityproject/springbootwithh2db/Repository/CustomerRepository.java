package org.mysecurityproject.springbootwithh2db.Repository;

import org.mysecurityproject.springbootwithh2db.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
