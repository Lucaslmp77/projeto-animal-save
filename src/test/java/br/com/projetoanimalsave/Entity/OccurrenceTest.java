package br.com.projetoanimalsave.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OccurrenceTest {

    @Test
    public void testGetName() {
        String name = "Lucas Mendes";
        Occurrence occurrence = new Occurrence();
        occurrence.setName(name);

        Assertions.assertEquals(name, occurrence.getName());
    }

    @Test
    public void testSetName_NullName() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setName(null);
        });
    }

    @Test
    public void testSetName_EmptyName() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setName("");
        });
    }

    @Test
    public void testSetName_ShortName() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setName("ab");
        });
    }

    @Test
    public void testSetName_LongName() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setName("Este é um nome muito longo que excede o limite máximo");
        });
    }

    @Test
    public void testSetName_NameWithNumbers() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setName("43123");
        });
    }

    @Test
    public void testGetContact() {
        String contact = "00 0 00000000";
        Occurrence occurrence = new Occurrence();
        occurrence.setContact(contact);

        Assertions.assertEquals(contact, occurrence.getContact());
    }

    @Test
    public void testSetContact_NullContact() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setContact(null);
        });
    }

    @Test
    public void testSetContact_EmptyContact() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setContact("");
        });
    }

    @Test
    public void testSetContact_ShortContact() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setContact("1234");
        });
    }

    @Test
    public void testSetContact_LongContact() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setContact("Este é um contato muito longo que excede o limite máximo");
        });
    }

    @Test
    public void testGetDescription() {
        String description = "Cachorro perdido com a pata quebrada";
        Occurrence occurrence = new Occurrence();
        occurrence.setDescription(description);

        Assertions.assertEquals(description, occurrence.getDescription());
    }

    @Test
    public void testSetDescription_NullDescription() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setDescription(null);
        });
    }

    @Test
    public void testSetDescription_EmptyDescription() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setDescription("");
        });
    }

    @Test
    public void testSetDescription_ShortDescription() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setDescription("12");
        });
    }

    @Test
    public void testSetDescription_LongDescription() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setDescription("Este é um contato muito longo que excede o limite máximo. " +
                    "Este é um contato muito longo que excede o limite máximo. " +
                    "Este é um contato muito longo que excede o limite máximo. " +
                    "Este é um contato muito longo que excede o limite máximo. " +
                    "Este é um contato muito longo que excede o limite máximo.");
        });
    }

    @Test
    public void testSetDescription_NumberDescription() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setDescription("434334");
        });
    }

    @Test
    public void testGetReferenceLocal() {
        String referenceLocal = "Vila Yolanda, perto do centro universitário Uniamérica";
        Occurrence occurrence = new Occurrence();
        occurrence.setReferenceLocal(referenceLocal);

        Assertions.assertEquals(referenceLocal, occurrence.getReferenceLocal());
    }

    @Test
    public void testSetReferenceLocal_NullReferenceLocal() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setReferenceLocal(null);
        });
    }

    @Test
    public void testSetReferenceLocal_EmptyReferenceLocal() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setReferenceLocal("");
        });
    }

    @Test
    public void testSetReferenceLocal_ShortReferenceLocal() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setReferenceLocal("AB");
        });
    }

    @Test
    public void testSetReferenceLocal_LongReferenceLocal() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setReferenceLocal("Esta é uma referência muito longa que excede o limite máximo. " +
                    "Esta é uma referência muito longa que excede o limite máximo. " +
                    "Esta é uma referência muito longa que excede o limite máximo. " +
                    "Esta é uma referência muito longa que excede o limite máximo. " +
                    "Esta é uma referência muito longa que excede o limite máximo.");
        });
    }

    @Test
    public void testSetReferenceLocal_NumberReferenceLocal() {
        Occurrence occurrence = new Occurrence();

        Assertions.assertThrows(RuntimeException.class, () -> {
            occurrence.setReferenceLocal("123456");
        });
    }

    @Test
    public void testGetSituation() {
        Situation situation = Situation.EMERGENCIA;
        Occurrence occurrence = new Occurrence();
        occurrence.setSituation(situation);

        Assertions.assertEquals(situation, occurrence.getSituation());
    }

    @Test
    public void testGetCaregiver() {
        Caregiver caregiver1 = new Caregiver();
        Caregiver caregiver2 = new Caregiver();
        List<Caregiver> caregivers = new ArrayList<>();
        caregivers.add(caregiver1);
        caregivers.add(caregiver2);

        Occurrence occurrence = new Occurrence();
        occurrence.setCaregiver(caregivers);

        Assertions.assertEquals(caregivers, occurrence.getCaregiver());
    }
}
