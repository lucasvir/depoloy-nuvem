package br.com.lucasvir.depoloy_nuvem.domain.repository;

import br.com.lucasvir.depoloy_nuvem.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String accNumber);
}
