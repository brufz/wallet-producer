package com.project.wallet.dto;

import com.project.wallet.enuns.EnumTransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WalletEventDto {

    @CPF
    private String cpf;
    private Double amount;
    private EnumTransactionType transactionType;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private String transactionDate;
}
