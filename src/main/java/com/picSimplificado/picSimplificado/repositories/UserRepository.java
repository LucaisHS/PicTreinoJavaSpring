package com.picSimplificado.picSimplificado.repositories;

import com.picSimplificado.picSimplificado.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> { //<nomeClasseTabela, tipoIdDaClasse>
    Optional<User> findUserByCpf(String cpf); //jpa já cria o método pra nós, só fazer a assinatura seguindo o padrao da sintaxe
    Optional<User> findUserById(long id);
}
