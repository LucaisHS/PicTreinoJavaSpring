package com.picSimplificado.picSimplificado.domain.user;

import com.picSimplificado.picSimplificado.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name="users")
@Table(name="users") //nome da tabela
@Getter //cria os getters
@Setter //cria os setters
@AllArgsConstructor //acho que cria um construtor com todos os argumentos no codigo? nn sei ao certo
@EqualsAndHashCode(of="id") // nn sei
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // faz o id incrementa de um em um

    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true) // faz com que nenhuma outra coluna possa ter o mesmo valor
    private String cpf;
    @Column(unique = true)
    private String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING) // Esse campo representa um dos valores do enum, campo de baixo*
    private UserType userType;

    public User() {}

    public User(UserDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.balance = data.balance();
        this.userType = data.userType();
        this.password = data.password();
        this.email = data.email();
        this.cpf = data.cpf();
    }
}
