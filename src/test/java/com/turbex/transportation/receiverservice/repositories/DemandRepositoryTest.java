package com.turbex.transportation.receiverservice.repositories;

import com.turbex.transportation.receiverservice.entities.Demand;
import com.turbex.transportation.receiverservice.entities.Product;
import com.turbex.transportation.receiverservice.types.DispatchType;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DataJpaTest
public class DemandRepositoryTest {

    @Autowired
    DemandRepository demandRepository;

    Demand demand;
    Long id;

    @BeforeEach
    public void init() {
        Product cellPhone = new Product("cellPhone", 11.0, 18.0, 4.0, 560.0, Long.decode("1"));
        List<Product> products = new ArrayList<Product>();
        products.add(cellPhone);
        UUID demandTransactionId = UUID.randomUUID();
        DispatchType dispatchType = DispatchType.NORMAL;
        Long partnerId = Long.decode("1");
        demand = new Demand(products, demandTransactionId, dispatchType);
    }

    @Test
    public void shouldSaveADemand() {
        Demand demandSaved = demandRepository.save(demand);
        Assert.assertEquals(demandSaved, demand);
    }

    @Test
    public void ShoudUpdateADemand() {
        Demand demandSaved = demandRepository.save(demand);
        demandSaved.setDispatchType(DispatchType.DANGER);
        Demand demandUpdated = demandRepository.save(demandSaved);
        Assert.assertEquals(demandUpdated.getDispatchType(), demandSaved.getDispatchType());
    }

    @Test
    public void ShoudDeleteADemand() {
        Demand demandSaved = demandRepository.save(demand);
        Long idDemand = demandSaved.getId();
        demandRepository.delete(demandSaved);
      Optional<Demand> demandOptional = demandRepository.findById(idDemand);
        Assert.assertFalse(demandOptional.isPresent());
    }
}
