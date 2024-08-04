package com.project.wallet.entity;

import com.project.wallet.enuns.EnumTransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WalletEvent {

    private UUID id;
    @CPF
    private String cpf;
    private Double amount;
    private EnumTransactionType transactionType;
    private String transactionDate;
}
