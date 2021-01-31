package rs.istv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "order")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Order extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "order_id")
	private Integer id;
	@JoinColumn(name = "buyer_id", referencedColumnName = "buyer_id")
	@ManyToOne
	private Buyer buyerId;
	@Column(name = "delivery_adress")
	private String deliveryAdress;
	@Column(name = "courier_service_price")
	private Integer courierServicePrice;
	@Column(name = "order_status")
	private String orderStatus;
	
}