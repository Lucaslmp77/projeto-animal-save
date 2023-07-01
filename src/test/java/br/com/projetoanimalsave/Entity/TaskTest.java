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
    public void testSetName_NullName() {
        Task task = new Task();

        Assertions.assertThrows(RuntimeException.class, () -> {
            task.setName(null);
        });
    }

    @Test
    public void testSetName_EmptyName() {
        Task task = new Task();

        Assertions.assertThrows(RuntimeException.class, () -> {
            task.setName("");
        });
    }

    @Test
    public void testSetName_ShortName() {
        Task task = new Task();

        Assertions.assertThrows(RuntimeException.class, () -> {
            task.setName("A");
        });
    }

    @Test
    public void testSetName_LongName() {
        Task task = new Task();

        Assertions.assertThrows(RuntimeException.class, () -> {
            task.setName("Este é um nome muito longo para uma tarefa que ultrapassa o limite máximo permitido");
        });
    }

    @Test
    public void testSetName_NumericName() {
        Task task = new Task();

        Assertions.assertThrows(RuntimeException.class, () -> {
            task.setName("123");
        });
    }

    @Test
    public void testGetCost() {
        Integer cost = 50;
        Task task = new Task();
        task.setCost(cost);

        Assertions.assertEquals(cost, task.getCost());
    }

    @Test
    public void testSetCost_NullCost() {
        Task task = new Task();

        Assertions.assertThrows(RuntimeException.class, () -> {
            task.setCost(null);
        });
    }

    @Test
    public void testSetCost_NegativeCost() {
        Task task = new Task();

        Assertions.assertThrows(RuntimeException.class, () -> {
            task.setCost(-50);
        });
    }

    @Test
    public void testSetCost_LargeCost() {
        Task task = new Task();

        Assertions.assertThrows(RuntimeException.class, () -> {
            task.setCost(2000000000);
        });
    }

    @Test
    public void testGetMonthlyAmount() {
        Integer monthlyAmount = 100;
        Task task = new Task();
        task.setMonthlyAmount(monthlyAmount);

        Assertions.assertEquals(monthlyAmount, task.getMonthlyAmount());
    }

    @Test
    public void testSetMonthlyAmount_NullMonthlyAmount() {
        Task task = new Task();

        Assertions.assertThrows(RuntimeException.class, () -> {
            task.setMonthlyAmount(null);
        });
    }

    @Test
    public void testSetMonthlyAmount_NegativeMonthlyAmount() {
        Task task = new Task();

        Assertions.assertThrows(RuntimeException.class, () -> {
            task.setMonthlyAmount(-5);
        });
    }

    @Test
    public void testSetMonthlyAmount_LargeMonthlyAmount() {
        Task task = new Task();

        Assertions.assertThrows(RuntimeException.class, () -> {
            task.setMonthlyAmount(2000000000);
        });
    }

    @Test
    public void testGetDescription() {
        String description = "Tosagem de cachorros";
        Task task = new Task();
        task.setDescription(description);

        Assertions.assertEquals(description, task.getDescription());
    }

    @Test
    public void testSetDescription_NullDescription() {
        Task task = new Task();

        Assertions.assertThrows(RuntimeException.class, () -> {
            task.setDescription(null);
        });
    }

    @Test
    public void testSetDescription_EmptyDescription() {
        Task task = new Task();

        Assertions.assertThrows(RuntimeException.class, () -> {
            task.setDescription("");
        });
    }

    @Test
    public void testSetDescription_ShortDescription() {
        Task task = new Task();

        Assertions.assertThrows(RuntimeException.class, () -> {
            task.setDescription("AB");
        });
    }

    @Test
    public void testSetDescription_LongDescription() {
        Task task = new Task();

        Assertions.assertThrows(RuntimeException.class, () -> {
            task.setDescription("Estaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdf é uma descrição muito longa que excede o limite máximo de caracteres permitidos no campo de descrição");
        });
    }

    @Test
    public void testSetDescription_NumericDescription() {
        Task task = new Task();

        Assertions.assertThrows(RuntimeException.class, () -> {
            task.setDescription("12345");
        });
    }

    @Test
    public void testGetProvider() {
        Provider provider = new Provider();
        Task task = new Task();
        task.setProvider(provider);

        Assertions.assertEquals(provider, task.getProvider());
    }
}
