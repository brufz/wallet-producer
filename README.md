# Instruções para Executar o Ambiente
### PRODUCER

### Rodar o container
docker build -t producer-wallet . 
docker run -d --name producer-wallet-container --network docker_default -p 8090:8090 producer-wallet

### Swaggerr
- http://localhost:8070/swagger-ui/index.html#

**Exemplos de JSON para o corpo do POST - Producer Kafka:**

```json
{
  "cpf": "43693769800",
  "amount": 100.00,
  "transactionType": "ADICAO",
  "transactionDate": "2023-10-10"
}

{
  "cpf": "43693769800",
  "amount": 10.00,
  "transactionType": "COMPRA",
  "transactionDate": "2023-10-10"
}

CURL PRODUCER

curl --location 'http://localhost.com:8070/wallet' \
--header 'Content-Type: application/json' \
--data '{
  "cpf": "43693769800",
  "amount": 1000.00,
  "transactionType": "ADICAO",
  "transactionDate": "2024-08-02"
}
'
