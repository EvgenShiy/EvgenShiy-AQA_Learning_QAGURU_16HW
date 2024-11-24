# REST API. Автотесты с REST Assured.

## Задание

**Разработать 5 автотестов на запросы из [https://reqres.in/](https://reqres.in/) с использованием моделей (lombok), спецификаций, allure (со степами) и сборкой в Jenkins.**  

---
# Проект автоматизации тестирования для сайта [ReqRes](https://reqres.in/)

## Содержание
* <a href="#о-проекте">О проекте</a>
* <a href="#основной-функционал">Основной функционал</a>
* <a href="#технологии-и-инструменты">Технологии и инструменты</a>
* <a href="#отчет-о-выполнении-тестов-в-allure-report">Отчет о выполнении тестов в Allure Report</a>
* <a href="#уведомление-о-результатах-тестов-в-telegram">Уведомление о результатах тестов в Telegram</a>

---
## <a id="о-проекте"></a>О проекте

Этот проект предназначен для автоматизированного тестирования API сервиса [ReqRes](https://reqres.in/), предоставляющего тестовые данные для демонстрации работы REST API. Тесты разработаны с использованием Java, библиотеки RestAssured, и фреймворка JUnit 5.

Проект создан для проверки корректности работы API, включая такие аспекты, как получение списка пользователей, работа с отдельными пользователями, обновление данных и другие ключевые операции.

---

## <a id="основной-функционал"></a>Основной функционал 

**GET-запросы**: Проверка получения списка пользователей и отдельного пользователя.

**POST-запросы**: Тестирование создания нового пользователя.

**PUT-запросы**: Обновление информации о пользователе.

**DELETE-запросы**: Удаление пользователя.

**Проверка ответов**: Валидация структуры и содержимого ответов API.

---

## <a id="технологии-и-инструменты"></a>Технологии и инструменты
<p align="center">
  <a href="https://www.java.com/"><img src="assets/logo/Java.svg" alt="Java Logo" height="50" width="50"/></a>
  <a href="https://www.jetbrains.com/idea/"><img src="assets/logo/Intelij_IDEA.svg" alt="Intelij_IDEA Logo"height="50" width="50"/></a>
  <a href="https://github.com/"><img src="assets/logo/GitHub.svg" alt="Github" height="50" width="50"/></a>
  <a href="https://junit.org/junit5/"><img src="assets/logo/JUnit5.svg" alt="JUnit 5" height="50" width="50"/></a>
  <a href="https://gradle.org/"><img src="assets/logo/Gradle.svg" alt="Gradle" height="50" width="50"/></a>
  <a href="https://github.com/allure-framework"><img src="assets/logo/Allure_Report.svg" alt="Allure" height="50" width="50"/></a>
  <a href="https://www.jenkins.io/"><img src="assets/logo/Jenkins.svg" alt="Jenkins" height="50" width="50"/></a>
  <a href="https://web.telegram.org/"><img src="assets/logo/Telegram.svg" alt="Telegram" height="50" width="50"/></a>
  <a href="https://rest-assured.io/"><img src="assets/logo/rest_assured.png" alt="REST Assured" height="50" width="50"/></a>
  <a href="https://reqres.in/api-docs/#/"><img src="assets/logo/Swagger-logo.png" alt="REST Assured" height="50" width="50"/></a>
</p>

---

## <img src="assets/logo/Allure_Report.svg" height="25" width="25"/></a> <a id="отчет-о-выполнении-тестов-в-allure-report"></a>Отчет о выполнении тестов в [Allure Report](https://jenkins.autotests.cloud/job/shiian_HW16_reqres_api_test_notif/3/allure/)

Allure Report — это инструмент для создания подробных и наглядных отчетов о результатах выполнения тестов. В нем отображаются все тестовые шаги, статусы тестов, а также дополнительные детали, такие как время выполнения и возможные ошибки. Allure помогает быстро анализировать результаты тестирования и предоставляет информацию в удобном визуальном формате.

Пример отчета для тестового прогона:

<img src="assets/images/allure_report.png" style="width:100%;">

Отчет в Allure включает шаги выполнения тестов, их статус и возможные ошибки, помогая легче отслеживать качество тестируемого приложения.
Шаги выполнения на примере тест-кейса:

<img src="assets/images/allure_report2.png" style="width:100%;">   

---

## <img src="assets/logo/Telegram.svg" height="25" width="25"/></a> <a id="уведомление-о-результатах-тестов-в-telegram"></a>Уведомление о результатах тестов в Telegram

После завершения тестов бот Telegram автоматически отправляет уведомления с результатами тестового прогона, включая информацию о количестве пройденных и неудавшихся тестов.

<p align="center">
<img src="assets/images/bot.png">
</p>

