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
    public void testGetContact() {
        String contact = "00 0 00000000";
        Occurrence occurrence = new Occurrence();
        occurrence.setContact(contact);

        Assertions.assertEquals(contact, occurrence.getContact());
    }

    @Test
    public void testGetDescription() {
        String description = "Cachorro perdido com a pata quebrada";
        Occurrence occurrence = new Occurrence();
        occurrence.setDescription(description);

        Assertions.assertEquals(description, occurrence.getDescription());
    }

    @Test
    public void testGetReferenceLocal() {
        String referenceLocal = "Vila Yolanda, perto do centro universitário Uniamérica";
        Occurrence occurrence = new Occurrence();
        occurrence.setReferenceLocal(referenceLocal);

        Assertions.assertEquals(referenceLocal, occurrence.getReferenceLocal());
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
