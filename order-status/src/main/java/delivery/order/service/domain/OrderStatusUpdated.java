package delivery.order.service.domain;

import delivery.order.service.domain.*;
import delivery.order.service.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderStatusUpdated extends AbstractEvent {

    private String orderId;
    private String status;

    public OrderStatusUpdated(OrderStatus aggregate) {
        super(aggregate);
    }

    public OrderStatusUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
