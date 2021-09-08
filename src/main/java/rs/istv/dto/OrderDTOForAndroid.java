package rs.istv.dto;

import lombok.Data;

@Data
public class OrderDTOForAndroid {
    private String orderStatus;
    private Integer orderId;
    private String deliveryAddress;
}
