package com.example.hrworker.resources;


import com.example.hrworker.entities.Worker;
import com.example.hrworker.repositories.WorkerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

    private WorkerRepository workerRepository;

    public WorkerResource(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = workerRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        Worker worker = workerRepository.findById(id).get();
        return ResponseEntity.ok(worker);
    }
}
