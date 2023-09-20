package com.example.demo.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    @Size(min = 6)
    private String password;
    @ManyToOne
    @JoinColumn(name = "customer-id")
    private Customer customer;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String username = user.getUsername();
        String password = user.getPassword();
        if (username == null || "".equals(username)
                && password == null || "".equals(password)){
            errors.rejectValue("name","error.name.blank",
                    "ten khong de trong");
        }
    }
}
