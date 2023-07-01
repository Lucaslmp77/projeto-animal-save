package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Task;
import br.com.projetoanimalsave.Repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveTask_Success() {
        Task task = new Task();
        task.setName("Task 1");
        task.setCost(100);
        task.setMonthlyAmount(5);
        task.setDescription("Description");

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task savedTask = taskService.save(task);

        assertNotNull(savedTask);
        assertEquals("Task 1", savedTask.getName());
        assertEquals(100, savedTask.getCost());
        assertEquals(5, savedTask.getMonthlyAmount());
        assertEquals("Description", savedTask.getDescription());

        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void listAllTasks_Success() {
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task());
        taskList.add(new Task());

        when(taskRepository.findAll()).thenReturn(taskList);

        List<Task> retrievedTasks = taskService.listAll();

        assertNotNull(retrievedTasks);
        assertEquals(2, retrievedTasks.size());

        verify(taskRepository, times(1)).findAll();
    }

    @Test
    void findById_TaskExists_Success() {
        Task task = new Task();
        task.setId(1L);

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Task retrievedTask = taskService.findById(1L);

        assertNotNull(retrievedTask);
        assertEquals(1L, retrievedTask.getId());

        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    void findById_TaskDoesNotExist_ReturnsEmptyTask() {
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        Task retrievedTask = taskService.findById(1L);

        assertNotNull(retrievedTask);
        assertNull(retrievedTask.getId());

        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    void findTaskByIdProvider_TaskExists_Success() {
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task());
        taskList.add(new Task());

        when(taskRepository.findTaskByIdProvider(1L)).thenReturn(taskList);

        List<Task> retrievedTasks = taskService.findTaskByIdProvider(1L);

        assertNotNull(retrievedTasks);
        assertEquals(2, retrievedTasks.size());

        verify(taskRepository, times(1)).findTaskByIdProvider(1L);
    }

    @Test
    void updateTask_Success() {
        Task task = new Task();
        task.setId(1L);
        task.setName("Updated Task");
        task.setCost(200);
        task.setMonthlyAmount(10);
        task.setDescription("Updated Description");

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        taskService.update(task, 1L);

        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void updateTask_InvalidId_ThrowsRuntimeException() {
        Task task = new Task();
        task.setId(1L);

        assertThrows(RuntimeException.class, () -> taskService.update(task, 2L));

        verify(taskRepository, never()).save(any(Task.class));
    }

    @Test
    void disableTask_Success() {
        Task task = new Task();
        task.setId(1L);

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        taskService.disable(1L);

        verify(taskRepository, times(1)).findById(1L);
        verify(taskRepository, times(1)).disable(1L);
    }

    @Test
    void disableTask_InvalidId_ThrowsRuntimeException() {
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> taskService.disable(1L));

        verify(taskRepository, times(1)).findById(1L);
        verify(taskRepository, never()).disable(anyLong());
    }
}
