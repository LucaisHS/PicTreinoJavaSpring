package com.picSimplificado.picSimplificado.domain.transaction;

import com.picSimplificado.picSimplificado.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transections")
@Table(name = "transection")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal amount;
    @ManyToOne // => um user pode ter varias transações, mas uma transação só pode ter um sender
    @JoinColumn(name = "sender_id")
    private User sender;
    @ManyToOne // => um user pode ter varias transações, mas uma transação só pode ter um receiver
    @JoinColumn(name = "receiver_id")
    private User receiver;
    private LocalDateTime timestamp;

}
