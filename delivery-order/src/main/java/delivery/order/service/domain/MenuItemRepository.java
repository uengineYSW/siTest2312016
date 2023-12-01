package delivery.order.service.domain;

import delivery.order.service.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "menuItems", path = "menuItems")
public interface MenuItemRepository
    extends PagingAndSortingRepository<MenuItem, String> {}
