package com.project.wallet.controller;

import com.project.wallet.dto.WalletEventDto;
import com.project.wallet.entity.WalletEvent;
import com.project.wallet.kafka.KafkaProducer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WalletController {

    @Autowired
    KafkaProducer kafkaProducer;

    @PostMapping
    @Operation(summary = "Envia o evento da operaçao financeira")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Envio de evento realizado com sucesso")
    })
    public ResponseEntity<String> postEvent(@RequestBody WalletEventDto walletEvent){
        try{
            kafkaProducer.send(walletEvent);
            return new ResponseEntity<>("Evento enviado com sucesso", HttpStatus.NO_CONTENT);
        } catch(Exception e){
            return new ResponseEntity<>("Erro ao enviar evento", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
