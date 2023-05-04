package br.com.projetoanimalsave.Controller;

import br.com.projetoanimalsave.Entity.Task;
import br.com.projetoanimalsave.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{idTask}")
    public ResponseEntity<Task> findById (
            @PathVariable Long idTask
    ) {
        return ResponseEntity.ok().body(this.taskService.findById(idTask));
    }
}
