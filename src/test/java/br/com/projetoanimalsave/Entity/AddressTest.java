package br.com.projetoanimalsave.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    public void testGetCep() {
        String cep = "12345678";
        Address address = new Address();
        address.setCep(cep);

        Assertions.assertEquals(cep, address.getCep());
    }

    @Test
    public void testGetNeighborhood() {
        String neighborhood = "Example Neighborhood";
        Address address = new Address();
        address.setNeighborhood(neighborhood);

        Assertions.assertEquals(neighborhood, address.getNeighborhood());
    }

    @Test
    public void testGetRoad() {
        String road = "Example Road";
        Address address = new Address();
        address.setRoad(road);

        Assertions.assertEquals(road, address.getRoad());
    }

    @Test
    public void testGetHouseNumber() {
        Integer houseNumber = 123;
        Address address = new Address();
        address.setHouseNumber(houseNumber);

        Assertions.assertEquals(houseNumber, address.getHouseNumber());
    }

    @Test
    public void testGetSetAssociate() {
        Associate associate = new Associate();
        Address address = new Address();
        address.setAssociate(associate);

        Assertions.assertEquals(associate, address.getAssociate());
    }

    @Test
    public void testGetSetCaregiver() {
        Caregiver caregiver = new Caregiver();
        Address address = new Address();
        address.setCaregiver(caregiver);

        Assertions.assertEquals(caregiver, address.getCaregiver());
    }

    @Test
    public void testGetSetProvider() {
        Provider provider = new Provider();
        Address address = new Address();
        address.setProvider(provider);

        Assertions.assertEquals(provider, address.getProvider());
    }
}
