package com.example.ProvaArq.ibgeController;

import com.example.ProvaArq.ibgeService.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
    @Autowired
    private Service service;

    @GetMapping("/noticiasereleases")
    public String consultarNoticiasRealeace(){

        return service.consultarNoticiasRealeace();
    }

@GetMapping("/noticias")
public String consultarNoticias(){
    return service.consultarNoticias();
}

@GetMapping("/releases")
public String consultarRealeace(){
    return service.consultarRealeace();
}
}

