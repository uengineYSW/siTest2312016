package delivery.order.service.common;

import delivery.order.service.DeliveryFulfillmentApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { DeliveryFulfillmentApplication.class })
public class CucumberSpingConfiguration {}
