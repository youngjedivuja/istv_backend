package rs.istv.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "order_product")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class OrderProduct  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "order_product_id")
    private Integer id;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne
    private Order order;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne
    private Product product;
    @Column(name = "quantity")
    private Integer quantity;

}
