package dev.manuel.msscbreweryclient.business.client;

import dev.manuel.msscbreweryclient.model.dto.Beer;
import dev.manuel.msscbreweryclient.model.dto.Customer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "dev.manuel", ignoreUnknownFields = false)
public class BreweryClient {

    private final String beerPathV1 = "/api/v1/beer/";
    private final String customerPathV1 = "/api/v1/customer/";

    private String apihost;

    private RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Beer getBeerById(UUID uuid) {
        return restTemplate.getForObject(apihost + beerPathV1 + uuid.toString(), Beer.class);
    }

    public URI saveNewBeer(Beer beer) {
        return restTemplate.postForLocation(apihost + beerPathV1, beer);
    }

    public void updateBeer(UUID beerId, Beer beer) {
        restTemplate.put(apihost + beerPathV1 + beerId.toString(), beer);
    }

    public void deleteBeer(UUID beerId) {
        restTemplate.delete(apihost + beerPathV1 + beerId.toString());
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public Customer getCustomerById(UUID customerId) {
        return restTemplate.getForObject(apihost + customerPathV1 + customerId.toString(), Customer.class);
    }

    public URI saveNewCustomer(Customer customer) {
        return restTemplate.postForLocation(apihost + customerPathV1, customer);
    }

    public void updateCustomer(UUID customerId, Customer customer) {
        restTemplate.put(apihost + customerPathV1 + customerId.toString(), customer);
    }

    public void deleteCustomer(UUID customerId) {
        restTemplate.delete(apihost + customerPathV1 + customerId.toString());
    }
}
