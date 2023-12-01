package delivery.order.service.domain;

import delivery.order.service.domain.*;
import delivery.order.service.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderCompleted extends AbstractEvent {

    private String orderId;

    public OrderCompleted(Fulfillment aggregate) {
        super(aggregate);
    }

    public OrderCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
