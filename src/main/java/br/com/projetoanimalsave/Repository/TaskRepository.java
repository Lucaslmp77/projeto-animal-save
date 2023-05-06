package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Modifying
    @Query("UPDATE Task task SET task.active = false WHERE task.id = :id")
    public void disable(@Param("id") Long id);
}
