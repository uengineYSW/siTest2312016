package delivery.order.service.common;

import delivery.order.service.OrderStatusApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { OrderStatusApplication.class })
public class CucumberSpingConfiguration {}
