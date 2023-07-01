package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Provider;
import br.com.projetoanimalsave.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Modifying
    @Query("UPDATE Task task SET task.active = false WHERE task.id = :id")
    public void disable(@Param("id") Long id);

    @Query("SELECT task FROM Task task where task.active = true")
    public List<Task> findTasksActives();

    @Query("SELECT task FROM Task task where task.provider.id = :id")
    public List<Task> findTaskByIdProvider(Long id);
}
