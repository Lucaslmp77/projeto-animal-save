package br.com.projetoanimalsave.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class AbstractEntityTest {

    @Test
    public void testGetSetId() {
        Long id = 1L;
        AbstractEntity entity = new ConcreteEntity();
        entity.setId(id);

        Assertions.assertEquals(id, entity.getId());
    }

    @Test
    public void testGetSetActive() {
        Boolean active = true;
        AbstractEntity entity = new ConcreteEntity();
        entity.setActive(active);

        Assertions.assertEquals(active, entity.getActive());
    }

    @Test
    public void testGetSetRegister() {
        LocalDateTime register = LocalDateTime.now();
        AbstractEntity entity = new ConcreteEntity();
        entity.setRegister(register);

        Assertions.assertEquals(register, entity.getRegister());
    }

    @Test
    public void testGetSetUpdate() {
        LocalDateTime update = LocalDateTime.now();
        AbstractEntity entity = new ConcreteEntity();
        entity.setUpdate(update);

        Assertions.assertEquals(update, entity.getUpdate());
    }

    private static class ConcreteEntity extends AbstractEntity {
    }
}
