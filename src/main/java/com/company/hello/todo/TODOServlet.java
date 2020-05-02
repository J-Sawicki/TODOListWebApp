package com.company.hello.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
class TODOServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(TODOServlet.class);

    private TODORepository repository;


    public TODOServlet(TODORepository repository) {
        this.repository = repository;
    }

    @PostMapping
    ResponseEntity<TODO> saveTODO(@RequestBody TODO todo) {
        return ResponseEntity.ok(repository.save(todo));
    }

    @PutMapping("/{id}")
    ResponseEntity<TODO> toggleTODO (@PathVariable Integer id) {
        var todo = repository.findById(id);
        todo.ifPresent((t)->{
            t.setDone(!t.isDone());
            repository.save(t);
        });
        return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    ResponseEntity<List<TODO>> findAllTODO() {
        logger.info("Request got");
        return ResponseEntity.ok(repository.findAll());
    }
}
