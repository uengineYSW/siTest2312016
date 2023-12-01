package delivery.order.service.common;

import delivery.order.service.DeliveryOrderApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { DeliveryOrderApplication.class })
public class CucumberSpingConfiguration {}
