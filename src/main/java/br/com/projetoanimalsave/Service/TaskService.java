package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Task;
import br.com.projetoanimalsave.Repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public Task save(Task task) {
        return this.taskRepository.save(task);
    }

    public List<Task> listAll() {
        return this.taskRepository.findAll();
    }

    public Task findById(Long id) {
        return this.taskRepository.findById(id).orElse(new Task());
    }

    public List<Task> findTaskByIdProvider(Long id) {
        return this.taskRepository.findTaskByIdProvider(id);
    }

    @Transactional
    public void update(Task task, Long id) {
        if (id == task.getId()) {
            this.taskRepository.save(task);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id) {
        var task = this.taskRepository.findById(id);
        if (id == task.get().getId()) {
            this.taskRepository.disable(id);
        } else {
            throw new RuntimeException();
        }
    }
}
