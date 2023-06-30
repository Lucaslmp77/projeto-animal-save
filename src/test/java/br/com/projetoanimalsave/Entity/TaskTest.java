package br.com.projetoanimalsave.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testGetName() {
        String name = "Tosagem";
        Task task = new Task();
        task.setName(name);

        Assertions.assertEquals(name, task.getName());
    }

    @Test
    public void testGetCost() {
        Integer cost = 50;
        Task task = new Task();
        task.setCost(cost);

        Assertions.assertEquals(cost, task.getCost());
    }

    @Test
    public void testGetMonthlyAmount() {
        Integer monthlyAmount = 100;
        Task task = new Task();
        task.setMonthlyAmount(monthlyAmount);

        Assertions.assertEquals(monthlyAmount, task.getMonthlyAmount());
    }

    @Test
    public void testGetDescription() {
        String description = "Tosagem de cachorros";
        Task task = new Task();
        task.setDescription(description);

        Assertions.assertEquals(description, task.getDescription());
    }

    @Test
    public void testGetProvider() {
        Provider provider = new Provider();
        Task task = new Task();
        task.setProvider(provider);

        Assertions.assertEquals(provider, task.getProvider());
    }
}
