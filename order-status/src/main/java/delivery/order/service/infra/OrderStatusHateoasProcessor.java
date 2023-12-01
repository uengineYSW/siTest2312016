package delivery.order.service.infra;

import delivery.order.service.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<OrderStatus>> {

    @Override
    public EntityModel<OrderStatus> process(EntityModel<OrderStatus> model) {
        return model;
    }
}
