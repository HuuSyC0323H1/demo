package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public Optional<User> findOne(Long aLong) {
        return iUserRepository.findById(aLong);
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void delete(Long aLong) {
        iUserRepository.deleteById(aLong);
    }
}
