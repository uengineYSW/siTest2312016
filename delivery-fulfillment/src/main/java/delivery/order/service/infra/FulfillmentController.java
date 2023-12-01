package delivery.order.service.infra;

import delivery.order.service.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/fulfillments")
@Transactional
public class FulfillmentController {

    @Autowired
    FulfillmentRepository fulfillmentRepository;

    @RequestMapping(
        value = "fulfillments/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Fulfillment startDelivery(
        @PathVariable(value = "id") String id,
        @RequestBody StartDeliveryCommand startDeliveryCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /fulfillment/startDelivery  called #####");
        Optional<Fulfillment> optionalFulfillment = fulfillmentRepository.findById(
            id
        );

        optionalFulfillment.orElseThrow(() -> new Exception("No Entity Found"));
        Fulfillment fulfillment = optionalFulfillment.get();
        fulfillment.startDelivery(startDeliveryCommand);

        fulfillmentRepository.save(fulfillment);
        return fulfillment;
    }

    @RequestMapping(
        value = "fulfillments/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Fulfillment completeDelivery(
        @PathVariable(value = "id") String id,
        @RequestBody CompleteDeliveryCommand completeDeliveryCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /fulfillment/completeDelivery  called #####");
        Optional<Fulfillment> optionalFulfillment = fulfillmentRepository.findById(
            id
        );

        optionalFulfillment.orElseThrow(() -> new Exception("No Entity Found"));
        Fulfillment fulfillment = optionalFulfillment.get();
        fulfillment.completeDelivery(completeDeliveryCommand);

        fulfillmentRepository.save(fulfillment);
        return fulfillment;
    }

    @RequestMapping(
        value = "fulfillments/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Fulfillment confirmDeliveryCompletion(
        @PathVariable(value = "id") String id,
        @RequestBody ConfirmDeliveryCompletionCommand confirmDeliveryCompletionCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /fulfillment/confirmDeliveryCompletion  called #####"
        );
        Optional<Fulfillment> optionalFulfillment = fulfillmentRepository.findById(
            id
        );

        optionalFulfillment.orElseThrow(() -> new Exception("No Entity Found"));
        Fulfillment fulfillment = optionalFulfillment.get();
        fulfillment.confirmDeliveryCompletion(confirmDeliveryCompletionCommand);

        fulfillmentRepository.save(fulfillment);
        return fulfillment;
    }
}
//>>> Clean Arch / Inbound Adaptor
