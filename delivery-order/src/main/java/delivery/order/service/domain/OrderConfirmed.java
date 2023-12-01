package delivery.order.service.domain;

import delivery.order.service.domain.*;
import delivery.order.service.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderConfirmed extends AbstractEvent {

    private String orderId;

    public OrderConfirmed(Order aggregate) {
        super(aggregate);
    }

    public OrderConfirmed() {
        super();
    }
}
//>>> DDD / Domain Event
