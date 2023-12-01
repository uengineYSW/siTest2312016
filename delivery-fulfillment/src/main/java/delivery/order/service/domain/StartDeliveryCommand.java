package delivery.order.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class StartDeliveryCommand {

    private String orderId;
    private String driverId;
}
