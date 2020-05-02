package com.company.hello.hello;


import com.company.hello.lang.Lang;
import com.company.hello.lang.LangRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloService {

    static final Lang FALLBACK_LANG = new Lang(1, "Hello", "eng");
    static final String FALLBACK_NAME = "world";
    private final Logger logger = LoggerFactory.getLogger(HelloService.class);

    private LangRepository repository;

    HelloService(LangRepository repository) {
        this.repository = repository;
    }


    String prepareGreeting(String name, Integer Id){
        Id = Optional.ofNullable(Id).orElse(FALLBACK_LANG.getId());
        var welcomeMessage = repository.findById(Id).orElse(FALLBACK_LANG).getWelcomeMsg();
        var welcomeName = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMessage + " " +  welcomeName + "!";
    }
}
