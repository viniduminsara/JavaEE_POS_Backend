package lk.ijse.javaee_pos_backend.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class ItemDTO {

    private String itemId;
    private String description;
    private Double unitPrice;
    private Integer qty;

}
