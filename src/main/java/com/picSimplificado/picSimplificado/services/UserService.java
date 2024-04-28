package com.picSimplificado.picSimplificado.services;

import com.picSimplificado.picSimplificado.domain.user.User;
import com.picSimplificado.picSimplificado.domain.user.UserType;
import com.picSimplificado.picSimplificado.dtos.UserDTO;
import com.picSimplificado.picSimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuario do tipo 'MERCHANT' não pode realizar transações");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Usuario não tem saldo suficiente");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public void saveUser(User user){
        this.repository.save(user);
    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }
}
