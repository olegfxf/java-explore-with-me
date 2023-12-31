# java-explore-with-me
Java-explore-with-me это сервис, который позволит пользователям делиться информацией об интересных событиях и находить компанию для участия в них.
# Стек технологий
Java 11, Spring Boot, Maven, Git, REST Api, Lombok, PostgresSQL , Spring Data JPA, Docker.
# Архитектура проекта
Сервис включает в себя два модуля. В модуле ewm-service реализованы все сервисные функции приложения. Модуль stats-service выполняет функции накопления статистики. Обмен данными между модулями ewm-service и tats-service реализован по технологии REST. Управление модулями реализовано через Docker-compose. 

Основной сервис работаеат на порту 8080. API основного сервиса и разделен на три части:

* Публичный (доступен для всех пользователей) позволяет:
  * просматривать список событий с краткой информацией по ним, в соответствии с выбранной сортировкой(по количеству просмотров событий, по дате событий или по рейтингу событий)
  * просматривать подробную информацию о выбранном событии
  * просматривать все имеющиеся категории событий
  * просматривать подборки событий, составленные администратором

* Приватный (доступен только для зарегистрированных пользователей) позволяет:
  * добавлять в приложение новые мероприятия, редактировать их и просматривать после добавления
  * подавать заявки на участие в интересующих мероприятиях
  * подтверждать заявки, которые отправили другие пользователи сервиса (доступно только для организаторов событий)
  * работать с комментариями пользователей

* Административный (доступен только для администратора проекта) позволяет:
  * управлять категориями для событий - добавлять, измененять и удалять категории
  * управлять подборками мероприятий - добавлять, удалять и закреплять на главной странице
  * модерировать события, размещённые пользователями, — публикация или отклонение
  * управлять пользователями — добавлять, просматривать и удалять


Сервис статистики работает на порту 9090 и предоставляет:
* количество обращений пользователей к спискам событий
* количество запросов к подробной информации о событии



# Запуск приложения
* склонировать проект на свой компьютер
* выполнить команду mvn clean package -Dmaven.plugin.validation=VERBOSE
* выполнить команду docker-compose up -d

