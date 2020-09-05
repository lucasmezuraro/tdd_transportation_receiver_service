package com.turbex.transportation.receiverservice.services;

import com.turbex.transportation.receiverservice.ReceiverServiceApplication;
import com.turbex.transportation.receiverservice.dtos.DemandDTO;
import com.turbex.transportation.receiverservice.entities.Demand;
import com.turbex.transportation.receiverservice.entities.Product;
import com.turbex.transportation.receiverservice.repositories.DemandRepository;
import com.turbex.transportation.receiverservice.types.DispatchType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.postgresql.hostchooser.HostRequirement.any;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ReceiverServiceTest {

    @Mock
    DemandRepository demandRepository;

    @InjectMocks
    ReceiverService receiverService;

    Demand demand;
    DemandDTO demandDTO;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void init() throws Exception {
        Product cellPhone = new Product("cellPhone", 11.0, 18.0, 4.0, 560.0, Long.decode("1"));
        List<Product> products = new ArrayList<Product>();
        products.add(cellPhone);
        UUID demandTransactionId = UUID.randomUUID();
        DispatchType dispatchType = DispatchType.NORMAL;
        Long partnerId = Long.decode("1");
        demandDTO = new DemandDTO(demandTransactionId, products, dispatchType, partnerId);
    }

    @Test
    public void ShouldSaveADemandByService() throws Exception{
        demand = new Demand(demandDTO.getProducts(), demandDTO.getDemandTransactionId(), demandDTO.getDispatchType());
        when(demandRepository.save(any(Demand.class))).thenReturn(demand);
        Demand demand2 = receiverService.create(demandDTO);
        Assert.assertEquals(demand2.getDemandTransactionId(), demandDTO.getDemandTransactionId());
    }
}
