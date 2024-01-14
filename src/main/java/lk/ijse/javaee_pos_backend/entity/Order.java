package lk.ijse.javaee_pos_backend.entity;

import java.time.LocalDate;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Order {

    private String orderId;
    private LocalDate date;
    private Integer discount;
    private Double total;
    private String customerId;

}
