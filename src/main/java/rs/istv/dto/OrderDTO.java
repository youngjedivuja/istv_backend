package rs.istv.dto;

import lombok.Data;
import rs.istv.entity.Product;

import java.util.List;

@Data
public class OrderDTO {
    private String deliveryAddress;
    private List<Product> products;
}
