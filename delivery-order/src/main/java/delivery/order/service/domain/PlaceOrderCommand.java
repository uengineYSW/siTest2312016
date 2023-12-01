package delivery.order.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class PlaceOrderCommand {

    private List<MenuItem> orderItems;
    private Address deliveryAddress;
    private String contactInfo;
}
