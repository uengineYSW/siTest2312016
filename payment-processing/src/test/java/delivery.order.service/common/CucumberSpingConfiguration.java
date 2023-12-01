package delivery.order.service.common;

import delivery.order.service.PaymentProcessingApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { PaymentProcessingApplication.class })
public class CucumberSpingConfiguration {}
