package delivery.order.service.domain;

import delivery.order.service.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "fulfillments",
    path = "fulfillments"
)
public interface FulfillmentRepository
    extends PagingAndSortingRepository<Fulfillment, String> {}
