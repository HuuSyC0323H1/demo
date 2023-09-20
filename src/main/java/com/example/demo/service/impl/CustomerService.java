package com.example.demo.service.impl;

import com.example.demo.model.Customer;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.service.ICustomerService;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @PersistenceContext
    private ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Optional<Customer> findOne(Long aLong) {
        return iCustomerRepository.findById(aLong);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void delete(Long aLong) {
        iCustomerRepository.deleteById(aLong);
    }
}
