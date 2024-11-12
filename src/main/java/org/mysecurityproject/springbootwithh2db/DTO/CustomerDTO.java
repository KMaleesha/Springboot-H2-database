package org.mysecurityproject.springbootwithh2db.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private int age;
}
