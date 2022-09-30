package net.javaguides.springboot.controller;


import net.javaguides.springboot.model.Task;
import net.javaguides.springboot.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public Task createClient(@RequestBody Task task)   {
        return taskRepository.save(task);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id)    {
        Task task = taskRepository.findById(id).orElseThrow(()-> new ResourceAccessException("Task not exist with id"+id));
        return ResponseEntity.ok(task);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Task> updateClient(@PathVariable Long id,@RequestBody Task taskDetails)    {
        Task updateTask = taskRepository.findById(id).orElseThrow(()-> new ResourceAccessException("Client not exist with id: "+ id));

        updateTask.setId(taskDetails.getId());
        updateTask.setTaskName(taskDetails.getTaskName());
        updateTask.setDescription(taskDetails.getDescription());




        taskRepository.save(updateTask);

        return  ResponseEntity.ok(updateTask);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable Long id)   {

        Task task = taskRepository.findById(id).orElseThrow(()-> new ResourceAccessException("Task not exist with id: "+ id));

        taskRepository.delete(task);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
