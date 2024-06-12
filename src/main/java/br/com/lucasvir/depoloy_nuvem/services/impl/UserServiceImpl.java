package br.com.lucasvir.depoloy_nuvem.services.impl;

import br.com.lucasvir.depoloy_nuvem.domain.model.User;
import br.com.lucasvir.depoloy_nuvem.domain.repository.UserRepository;
import br.com.lucasvir.depoloy_nuvem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow((NoSuchElementException::new));
    }

    @Override
    public User create(User user) {
        boolean userExists = userRepository.existsByAccountNumber(user.getAccount().getNumber());
        if(userExists) throw new IllegalArgumentException("This Account Number already exists.");

        return userRepository.save(user);
    }
}
