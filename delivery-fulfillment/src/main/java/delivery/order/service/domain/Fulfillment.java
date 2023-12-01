package delivery.order.service.domain;

import delivery.order.service.DeliveryFulfillmentApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Fulfillment_table")
@Data
//<<< DDD / Aggregate Root
public class Fulfillment {

    @Id
    private String orderId;

    private String driverId;

    private String status;

    private statusType statusType;

    @PrePersist
    public void onPrePersist() {}

    public static FulfillmentRepository repository() {
        FulfillmentRepository fulfillmentRepository = DeliveryFulfillmentApplication.applicationContext.getBean(
            FulfillmentRepository.class
        );
        return fulfillmentRepository;
    }

    //<<< Clean Arch / Port Method
    public void startDelivery(StartDeliveryCommand startDeliveryCommand) {
        //implement business logic here:

        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void completeDelivery(
        CompleteDeliveryCommand completeDeliveryCommand
    ) {
        //implement business logic here:

        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void confirmDeliveryCompletion(
        ConfirmDeliveryCompletionCommand confirmDeliveryCompletionCommand
    ) {
        //implement business logic here:

        OrderCompleted orderCompleted = new OrderCompleted(this);
        orderCompleted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
