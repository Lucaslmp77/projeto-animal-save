package br.com.projetoanimalsave.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id", length = 30, nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @Column(name = "active", nullable = false)
    private Boolean active;

    @Getter @Setter
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @Column(name = "register", nullable = false)
    private LocalDateTime register;

    @Getter @Setter
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @Column(name = "update", nullable = true)
    private LocalDateTime update;

    @PrePersist
    public void dateRegister() {
        this.setRegister(LocalDateTime.now());
        this.setActive(true);
    }

    @PreUpdate
    public void dateUpdate() {
        this.setUpdate(LocalDateTime.now());
    }
}
