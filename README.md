# <p style="margin-top: 16px" align="center">NaLog - Spring REST API</p>

Nalog é uma API RESTful de delivery, onde temos o CRUD clientes, listagem/criação/atualização da entrega e criação/atualização das ocorrências, tudo isso utilizando spring boot, java e MySql.

## **Requisitos**

---

Você irá precisar:

- [Java JDK 8 or higher](https://www.oracle.com/java/technologies/downloads/);
- [Maven 3.1.1 or higher](https://maven.apache.org/index.html);
- [MySql](https://www.mysql.com/);
- [Lombok](https://projectlombok.org/);

## **Passo a Passo**

---

**1.Clonar o repositório:**

```bash
https://github.com/nivaldoandrade/nalog-java-spring-api.git
```

**2.Adicionar informações sobre mysql:**

- No arquivo `src/main/resources/application.properties`
- Mude `spring.datasource.username` e `spring.datasource.password` conforme sua instalação do mysql

  **OBS: NOTE QUE NO `spring.datasource.url` JÁ ESTÁ SETADO PARA A PORTA PADRÃO DO MYSQL E A CRIAÇÃO AUTOMÁTICA DO BD COM O NOME NALOG SE CASO NÃO EXISTA.**

```
spring.datasource.url=jdbc:mysql://localhost/nalog?createDatabaseIfNotExist=true&connectionTimeZone=UTC
spring.datasource.username=
spring.datasource.password=
```

**3.Rodar a api usando o maven:**

```
mvn spring-boot:run
```

Por padrão, a api será iniciada na url http://localhost:8080

## **Importar projeto no Eclipse/STS IDE**

---

Seguir o tutorial [How to import Spring Boot project in Eclipse/STS IDE.](https://www.websparrow.org/misc/how-to-import-spring-boot-project-in-eclipse-sts-ide)

## **APIs Endpoints**

---

### Cliente(Customer)

| Método | Url             | Descrição                    | Exemplo do request body válido |
| ------ | --------------- | ---------------------------- | ------------------------------ |
| GET    | /customers/{id} | Obter um cliente pelo id     |                                |
| GET    | /customers      | Obter todos os clientes      |                                |
| POST   | /customers      | Criar um cliente             | [JSON](#customerPost)          |
| PUT    | /customers/{id} | Atualizar um cliente pelo id | [JSON](#customerPut)           |
| DELETE | /customers/{id} | Deletar um cliente pelo id   |                                |

### Entrega(Delivery)

| Método | Url                        | Descrição                             | Exemplo do request body válido |
| ------ | -------------------------- | ------------------------------------- | ------------------------------ |
| GET    | /deliveries/{id}           | Obter uma entrega pelo id             |                                |
| GET    | /deliveries                | Obter todas as entregas               |                                |
| POST   | /deliveries                | Criar uma entrega                     | [JSON](#deliveryPost)          |
| PUT    | /deliveries/{id}/finishing | Atualizar uma entrega para finalizada |                                |
| PUT    | /deliveries/{id}/canceling | Atualizar uma entrega para cancelada  |                                |

### Ocorrência(Accurrence)

| Método | Url                          | Descrição                                     | Exemplo do request body válido |
| ------ | ---------------------------- | --------------------------------------------- | ------------------------------ |
| GET    | /accurrences/{id}            | Obter uma ocorrência pelo id                  |                                |
| GET    | /deliveries/{id}/accurrences | Obter todas as ocorrência pelo id da entrega  |                                |
| POST   | /deliveries/{id}/accurrences | Criar uma ocorrência para uma entrega pelo id | [JSON](#occurrencePost)        |

## **POSTMAN**

---

Se caso preferir, utilize o [postman](https://www.postman.com/) para realizar as chamadas no endpoints.

### Importar collections para postman

Tutorial de como importar collections para postman no [Importing and exporting data.](https://learning.postman.com/docs/getting-started/importing-and-exporting-data/)  
Download da [Collection.](https://github.com/nivaldoandrade/nalog-java-spring-api/blob/main/postman/Nalog.postman_collection.json)

## **Exemplo do request body válido**

---

##### <a id="customerPost">Create Customer -> /customers</a>

```json
{
  "name": "Jonh Doe",
  "email": "john.doe@nasa.com.br",
  "telephone": "1122222-1111"
}
```

##### <a id="customerPut">Update Customer -> /customers/{id}</a>

```json
{
  "name": "Jonh Doe2",
  "email": "john.doe2@nasa.com.br",
  "telephone": "1133333-2222"
}
```

##### <a id="deliveryPost">Create Delivery -> /deliveries</a>

###### **OBS: O CAMPO `address2` é opcional.**

```json
{
  "customer": {
    "id": 4
  },
  "receiver": {
    "name": "Jonh Doe",
    "address": "Rua x",
    "number": "60",
    "address2": "apt",
    "district": "Bairro"
  },
  "tax": 400.5
}
```

##### <a id="occurrencePost">Create Accurrence -> /deliveries/{id}/accurrences</a>

```json
{
  "describe": "describe"
}
```

**Um pequeno aprendiz nesse grande mundo da programação.** 😃🗺
