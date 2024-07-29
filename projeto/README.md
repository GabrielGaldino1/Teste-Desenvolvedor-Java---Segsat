```markdown
# Projeto de Integração com API AdSet

Este projeto tem como objetivo consumir dados da API AdSet e armazená-los em um banco de dados local.

## Estrutura do Projeto

O projeto é dividido nas seguintes partes principais:

### Model

- `Vehicle.java`: Classe que representa o modelo do veículo.

### Repository

- `VehicleRepository.java`: Interface responsável pela comunicação com o banco de dados.

### Service

- `AdSetApiService.java`: Classe que contém a lógica para consumir a API AdSet e salvar os dados no banco de dados.

### Controller

- `ApiController.java`: Classe que expõe endpoints para interagir com os dados dos veículos.

## Requisitos

São necessários alguns requisitos pré-instalados para obter o funcionamento pleno do programa:

- Maven
- Jdk 17 e consequentemente o Java
- Postman 
- PostgreSQL
- PgAdmin4 ou outra ferramenta para acessar o banco de dados
## Dependências

As principais dependências do projeto são:

- Spring Boot
- Spring Data JPA
- RestTemplate
- PostgreSQL

## Configuração

### Banco de Dados

Certifique-se de configurar corretamente as propriedades do banco de dados no arquivo `application.properties`.

Exemplo para Banco de dados PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/vss 
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.sql.init.mode=always

```

### Consumo da API

No serviço `AdSetApiService`, configure os parâmetros da API (email, senha, CNPJ, portal) conforme necessário.

```java
String email = "seu_email@exemplo.com";
String senha = "sua_senha";
String cnpj = "seu_cnpj";
String portal = "seu_portal";
```

## Execução

Para executar o projeto, use o seguinte comando:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints

### Importar Dados

- `GET /api/vehicles/import`: Consome a API AdSet e salva os dados no banco de dados.

### Obter Todos os Veículos

- `GET /api/vehicles`: Retorna todos os veículos armazenados no banco de dados.

### Adicionar Veículo

- `POST /api/vehicles`: Adiciona um novo veículo ao banco de dados.

### Obter Veículo por ID

- `GET /api/vehicles/{id}`: Retorna um veículo específico pelo ID.

### Atualizar Veículo

- `PUT /api/vehicles/{id}`: Atualiza os dados de um veículo específico pelo ID. É possível alterar os seguintes campos: Marca, Modelo e AnoFabricação.



### Buscar Veículos por Loja

- `GET /api/vehicles/loja/{lojaId}`: Retorna todos os veículos de uma loja específica.

### Buscar Veículos por Ano

- `GET /api/vehicles/anos?startYear={startYear}&endYear={endYear}`: Retorna todos os veículos dentro de um intervalo de anos.

## Exemplo de Requisição

### Adicionar Veículo

```json
POST /api/vehicles
{
    "Id": 3456376,
    "Loja": "NOME DA EMPRESA",
    "LojaId": 3752,
    "Tipo": "Carro",
    "Marca": "CHEVROLET",
    "Modelo": "TRACKER",
    "Versao": "1.2 TURBO FLEX PREMIER AUTOMÁTICO",
    "Km": 39093,
    "AnoFabricacao": 2022,
    "AnoModelo": 2023,
    "Cor": "Prata",
    "Combustivel": "Flex",
    "Transmissao": "Automatico",
    "Placa": "VIC1234",
    "Chassi": "9BGEP76B0PB999999",
    "Opcionais": "Airbag do motorista, Airbag duplo, Alarme, Ar condicionado, Ar quente, Bancos de couro, Computador de bordo, Controle automático de velocidade, Controle de tração, Desembaçador traseiro, Encosto de cabeça traseiro, Farol de neblina, Freio ABS, Limpador traseiro, Porta-copos, Rádio, Retrovisores elétricos, Rodas de liga leve, Sensor de chuva, Sensor de estacionamento, Teto solar, Travas elétricas, Vidros elétricos, Volante com Regulagem de Altura, MP3 Player, Bluetooth, Câmera de Ré, Entrada USB, Direção Elétrica, Kit Multimídia, Farol de LED, Luz Diurna, Apple CarPlay, Controle de Estabilidade, Integração com SmartPhones, Chave Reserva, Airbag Lateral, Airbag de Cortina, 6 Airbags, Isofix",
    "Caracteristicas": null,
    "PrecoDe": null,
    "Preco": 999900.00,
    "Portas": 4,
    "Condicao": "Usado",
    "Status": "Disponivel",
    "Estoque": "ESTOQUE",
    "Publicado": true,
    "Blindado": false,
    "HashDados": "177BABCAF4A51A63427061BE1EF7A8B5",
    "HashImagem": "885D3C476576D5DBC06A835A16AD7A7F",
    "Fotos": [
        "https://s3.amazonaws.com/adset.images/2b93130f-a77d-4036-ac82-08a0f678ab0a20240130199999.jpeg",
        "https://s3.amazonaws.com/adset.images/0140a94e-3169-4ae6-b658-943b6ef244ac20240130199999.jpeg",
        "https://s3.amazonaws.com/adset.images/6175a50d-9f0e-4678-93b9-404a0e1b1dc420240130199999.jpeg",
        "https://s3.amazonaws.com/adset.images/9a25b139-535e-4b14-93d2-41d65305a78820240130199999.jpeg",
        "https://s3.amazonaws.com/adset.images/d465b477-b491-4143-964c01ba38076c5620240130199999.jpeg",
        "https://s3.amazonaws.com/adset.images/e5dd7c69-a41b-47ab-940f14557e42277420240130199999.jpeg",
        "https://s3.amazonaws.com/adset.images/966969d0-b9d2-44ee-9b30-01add77d71e920240130199999.jpeg",
        "https://s3.amazonaws.com/adset.images/940441dc-1009-4112-ae3f9b9531d1bbf620240130199999.jpeg",
        "https://s3.amazonaws.com/adset.images/cff3f92d-b433-4713-b480-f7c36f130f2020240130199999.jpeg"
    ],
    "Observacao": null,
    "DataHoraAPI": "20/02/2024 13:09:38",
    "SuperOferta": false,
    "Video": null,
    "Carroceria": "SUV",
    "SpinCar": false
}
```

### Alterar Veículo

``` json
PUT /api/vehicles/{id}
{
    "Marca": "CHEVROLET",
    "Modelo": "TRACKER",
    "AnoFabricacao": 2022,
```
## Considerações Finais

Este projeto serve como exemplo de como consumir uma API externa e armazenar os dados em um banco de dados utilizando Spring Boot.

```

