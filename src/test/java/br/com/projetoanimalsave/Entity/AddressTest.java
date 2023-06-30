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
    public void testSetCep_NullCep() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setCep(null));
    }

    @Test
    public void testSetCep_EmptyCep() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setCep(""));
    }

    @Test
    public void testSetCep_ShortCep() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setCep("1234567"));
    }

    @Test
    public void testSetCep_LongCep() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setCep("123456789"));
    }

    @Test
    public void testGetNeighborhood() {
        String neighborhood = "Example Neighborhood";
        Address address = new Address();
        address.setNeighborhood(neighborhood);

        Assertions.assertEquals(neighborhood, address.getNeighborhood());
    }

    @Test
    public void testSetNeighborhood_NullNeighborhood() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setNeighborhood(null));
    }

    @Test
    public void testSetNeighborhood_EmptyNeighborhood() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setNeighborhood(""));
    }

    @Test
    public void testSetNeighborhood_ShortNeighborhood() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setNeighborhood("A"));
    }

    @Test
    public void testSetNeighborhood_LongNeighborhood() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setNeighborhood("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod efficitur urna, nec placerat odio lacinia id."));
    }

    @Test
    public void testSetNeighborhood_NumericNeighborhood() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setNeighborhood("123456"));
    }

    @Test
    public void testGetRoad() {
        String road = "Example Road";
        Address address = new Address();
        address.setRoad(road);

        Assertions.assertEquals(road, address.getRoad());
    }

    @Test
    public void testSetRoad_NullRoad() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setRoad(null));
    }

    @Test
    public void testSetRoad_EmptyRoad() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setRoad(""));
    }

    @Test
    public void testSetRoad_ShortRoad() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setRoad("A"));
    }

    @Test
    public void testSetRoad_LongRoad() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setRoad("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod efficitur urna, nec placerat odio lacinia id."));
    }

    @Test
    public void testSetRoad_NumericRoad() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setRoad("123456"));
    }

    @Test
    public void testGetHouseNumber() {
        Integer houseNumber = 123;
        Address address = new Address();
        address.setHouseNumber(houseNumber);

        Assertions.assertEquals(houseNumber, address.getHouseNumber());
    }

    @Test
    public void testSetHouseNumber_NullHouseNumber() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setHouseNumber(null));
    }

    @Test
    public void testSetHouseNumber_NegativeHouseNumber() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setHouseNumber(-123));
    }

    @Test
    public void testSetHouseNumber_ExceedMaxCharacters() {
        Address address = new Address();

        Assertions.assertThrows(RuntimeException.class, () -> address.setHouseNumber(1234567890));
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
