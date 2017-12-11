package ru.rustam.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    @GetMapping(value = "/", produces = "Application/json")
    public ResponseEntity index() {
        String str = "{\"sdf\":5465464}";
        return ResponseEntity.ok(str);
    }

    @GetMapping(value = "/protected/", produces = "Application/json")
    public ResponseEntity indexP() {
        String str = "{\"sdf\":\"protected\"}";
        return ResponseEntity.ok(str);
    }
}

//    Необходимо написать автоматизацию ресурса по обмену dvd дисками, набор rest-сервисов для веб-приложения.
//        Есть коллекция дисков у каждого участника. Диски можно брать и отдавать. В системе три сущности: Disk (DVD-диск), User, TakenItem (связка User-Disk)
//        В приложении предполагается пять экранов:
//        - авторизация,
//        - список собственных дисков у каждого пользователя,
//        - список свободных дисков (у всех пользователей невзятые),
//        - список дисков, взятых пользователем;
//        - список дисков, взятых у пользователя (с указанием, кто взял)
//        Диск можно взять и отдать (без денежных расчётов), т.е. в списке дисков взятых должна быть кнопка "отдать",  а в списке дисков свободных кнопка "взять".
//        Необходимо спроектировать и реализовать rest-сервисы для такого приложения. Необходимо использовать spring, JPA (Hibernate), в качестве СУБД - на выбор