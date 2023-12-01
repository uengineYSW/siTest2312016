package delivery.order.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CompleteDeliveryCommand {

    private String orderId;
}
