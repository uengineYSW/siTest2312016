package delivery.order.service.infra;

import delivery.order.service.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class MenuItemHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<MenuItem>> {

    @Override
    public EntityModel<MenuItem> process(EntityModel<MenuItem> model) {
        return model;
    }
}
