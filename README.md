Executar o docker-compose para subir o ambiente do kafka e zookeeper

[//]: # (Caso o projeto nao rode em sua maquina, deve-se adicionar ao host o seguinte endereço:)

[//]: # (127.0.0.1 kafka localhost localhost.localdomain localhost4 localhost4.localdomain4)

[//]: # (::1 localhost localhost.localdomain localhost6 localhost6.localdomain6)

Modificar o conteiner docker do docker-compose
echo 'listeners=PLAINTEXT://kafka:9092' | tee -a /opt/bitnami/kafka/config/server.properties

Para enviar mensagens a partir do console-producer
kafka-console-producer --broker-list localhost:9092 --topic my-topic

Exemplos de JSON para enviar ao kafka:
{"idEvento": 1, "cpf":"43693769800", "amount": 100.00, "transactionType": "ADICAO", "transactionDate": "2023-07-21"}
{"idEvento": 2, "cpf":"43693769800", "amount": 20.00, "transactionType": "ADICAO", "transactionDate": "2023-09-21"}
{"idEvento": 3, "cpf":"43693769800", "amount": 100.50, "transactionType": "COMPRA", "transactionDate": "2023-11-21"}
{"idEvento": 4, "cpf":"43693769800", "amount": 100.50, "transactionType": "ESTORNO", "transactionDate": "2024-01-21"}
{"idEvento": 6, "cpf":"54366222086", "amount": 100.50, "transactionType": "ADICAO", "transactionDate": "2024-07-21"}
