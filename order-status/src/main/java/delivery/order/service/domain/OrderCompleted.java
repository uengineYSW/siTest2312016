package delivery.order.service.domain;

import delivery.order.service.domain.*;
import delivery.order.service.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCompleted extends AbstractEvent {

    private String orderId;
}
