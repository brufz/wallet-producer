package com.project.wallet.kafka;

import com.project.wallet.dto.WalletEventDto;
import com.project.wallet.entity.WalletEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, WalletEvent> kafkaTemplate;

    @KafkaListener(topics = "my-topic", groupId = "group_id")
    public void send(WalletEventDto walletEventDto){
        WalletEvent message = WalletEvent.builder()
                .id(UUID.randomUUID())
                .cpf(walletEventDto.getCpf())
                .amount(walletEventDto.getAmount())
                .transactionType(walletEventDto.getTransactionType())
                .transactionDate(walletEventDto.getTransactionDate())
                .build();

        kafkaTemplate.send("my-topic", message);
        log.info("Mensagem enviada: {}", message);
    }
}
