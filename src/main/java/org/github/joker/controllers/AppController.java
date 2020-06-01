package org.github.joker.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/app", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppController {

    @GetMapping(path = "/info")
    public String infoApp() {
        return "0.1";
    }

}
