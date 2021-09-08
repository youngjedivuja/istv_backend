package rs.istv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Data
@Entity
@NoArgsConstructor
@Table(name = "`order`")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "order_id")
	private Integer id;
	@JoinColumn(name = "buyer_id", referencedColumnName = "buyer_id")
	@ManyToOne
	private Buyer buyerId;
	@Column(name = "delivery_address")
	private String deliveryAddress;
	@Column(name = "order_status")
	private String orderStatus;
	@ToString.Exclude
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	//@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private List<OrderProduct> orderProducts;


}