package dev.manuel.msscbreweryclient.business.client;

import dev.manuel.msscbreweryclient.model.dto.Beer;
import dev.manuel.msscbreweryclient.model.dto.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void testGetBeerById() {
        Beer beer = client.getBeerById(UUID.randomUUID());
        System.out.println(beer);
        assertNotNull(beer);
    }

    @Test
    void testSaveNewBeer(){
        Beer beer = Beer.builder().beerName("New Beer").build();
        URI uri = client.saveNewBeer(beer);
        System.out.println(uri.toString());
        assertNotNull(uri);
    }

    @Test
    void testUpdateBeer() {
        Beer beer = Beer.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(), beer);
    }

    @Test
    void testDeleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void testGetCustomerById(){
        Customer customer = client.getCustomerById(UUID.randomUUID());
        System.out.println(customer);
        assertNotNull(customer);
    }

    @Test
    void testSaveNewCustomer(){
        Customer customer = Customer.builder().customerName("Default Customer").build();
        URI uri = client.saveNewCustomer(customer);
        System.out.println(uri.toString());
        assertNotNull(uri);
    }

    @Test
    void testUpdateCustomer(){
        Customer customer = Customer.builder().customerName("Default Customer").build();
        client.updateCustomer(UUID.randomUUID(),customer);
    }

    @Test
    void testDeleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());
    }
}