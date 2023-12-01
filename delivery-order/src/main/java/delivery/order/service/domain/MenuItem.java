package delivery.order.service.domain;

import delivery.order.service.DeliveryOrderApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MenuItem_table")
@Data
//<<< DDD / Aggregate Root
public class MenuItem {

    @Id
    private String menuId;

    private String name;

    private int quantity;

    public static MenuItemRepository repository() {
        MenuItemRepository menuItemRepository = DeliveryOrderApplication.applicationContext.getBean(
            MenuItemRepository.class
        );
        return menuItemRepository;
    }
}
//>>> DDD / Aggregate Root
