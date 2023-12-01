package delivery.order.service.domain;

import delivery.order.service.PaymentProcessingApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Payment_table")
@Data
//<<< DDD / Aggregate Root
public class Payment {

    @Id
    private String orderId;

    private Money amount;
    private boolean isCompleted;

    @PrePersist
    public void onPrePersist() {}

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentProcessingApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    //<<< Clean Arch / Port Method
    public void completePayment(CompletePaymentCommand completePaymentCommand) {
        this.isCompleted = true;
        PaymentCompleted paymentCompleted = new PaymentCompleted(this);
        paymentCompleted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
