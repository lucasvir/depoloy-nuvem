package br.com.lucasvir.depoloy_nuvem.controllers;

import br.com.lucasvir.depoloy_nuvem.domain.model.User;
import br.com.lucasvir.depoloy_nuvem.services.UserService;
import br.com.lucasvir.depoloy_nuvem.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    ResponseEntity<User> findyById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    ResponseEntity<User> create(@RequestBody User user) {
        User userEntity = userService.create(user);
        URI uri  = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(userEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(userEntity);
    }
}
