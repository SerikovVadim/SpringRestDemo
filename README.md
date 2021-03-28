#Тестовое Rest приложение


Используемые технологии: 
Spring(Boot & Date), база данных PostgreSQL

Функционал:
Приложение позволяет проводить CRUD операции для запросов в формате JSON.


Для подключения к базе данных, в файле application.property поменяйте следующие значения: "passwordManager" - название базы данных можете установить своё или оставить это spring.datasource.url=jdbc:postgresql://localhost:5432/passwordManager

Введите свой логин от базы данных 
spring.datasource.username=postgres

Введите свой пароль от базы данных 
spring.datasource.password=root

Запустить приложение: mvn spring-boot:run

#Пример запросов:


POST: localhost:8080/api/v1/persons/ Request Body {
                                                      "firstName": "Ivan",
                                                      "lastName": "Ivanov",
                                                      "age": 35,
                                                      "passport": "123456789"
                                                  } добавить пользователя в базу
                                               
GET: localhost:8080/api/v1/persons/1 получить пользователя по id.  
                                           
PUT: localhost:8080/api/v1/persons/ {
                                        "id": 1,
                                        "firstName": "Иван",
                                        "lastName": "Иванов",
                                        "age": 30,
                                        "passport": "987654321"
                                    } обновить пользователя в бд с id номер 1.
                                    
DELETE: localhost:8080/api/v1/persons/1 удалить пользователя с id номер 1.                                  
