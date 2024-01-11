package lk.ijse.javaee_pos_backend.dto;

import lombok.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class OrderDTO {

    private String orderId;
    private LocalDate date;
    private Integer discount;
    private Double total;
    private String customerId;

}
