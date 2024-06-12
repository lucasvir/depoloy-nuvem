package br.com.lucasvir.depoloy_nuvem.services;

import br.com.lucasvir.depoloy_nuvem.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User user);
}
