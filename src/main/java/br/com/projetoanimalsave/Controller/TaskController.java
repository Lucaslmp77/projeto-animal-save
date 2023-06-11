package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Task;
import br.com.projetoanimalsave.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping()
    public ResponseEntity<?> save(
            @RequestBody Task task
    ) {
        try {
            this.taskService.save(task);
            return ResponseEntity.ok().body("Tarefa cadastrada");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Task>> listAll(

    ) {
        return ResponseEntity.ok().body(this.taskService.listAll());
    }

    @GetMapping("/{idTask}")
    public ResponseEntity<Task> findById (
            @PathVariable Long idTask
    ) {
        return ResponseEntity.ok().body(this.taskService.findById(idTask));
    }

    @PutMapping("/update/{idTask}")
    public ResponseEntity<?> update(
            @PathVariable Long idTask,
            @RequestBody Task task
    ) {
        try {
            this.taskService.update(task, idTask);
            return ResponseEntity.ok().body("Tarefa atualizada");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/disable/{idTask}")
    public ResponseEntity<?> disable(
            @PathVariable Long idTask
    ) {
        try {
            this.taskService.disable(idTask);
            return ResponseEntity.ok().body("Serviço excluido!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}