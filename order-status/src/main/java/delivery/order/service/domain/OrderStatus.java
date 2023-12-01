package delivery.order.service.domain;

import delivery.order.service.OrderStatusApplication;
import delivery.order.service.domain.OrderStatusUpdated;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OrderStatus_table")
@Data
//<<< DDD / Aggregate Root
public class OrderStatus {

    @Id
    private String orderId;

    private String status;

    private statusType statusType;

    @PostPersist
    public void onPostPersist() {
        OrderStatusUpdated orderStatusUpdated = new OrderStatusUpdated(this);
        orderStatusUpdated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static OrderStatusRepository repository() {
        OrderStatusRepository orderStatusRepository = OrderStatusApplication.applicationContext.getBean(
            OrderStatusRepository.class
        );
        return orderStatusRepository;
    }
}
//>>> DDD / Aggregate Root
