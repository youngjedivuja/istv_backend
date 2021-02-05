package rs.istv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Product extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "product_id")
	private Integer id;
	@Column(name = "product_code")
	private String productCode;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "country_of_origin")
	private String countryOfOrigin;
	@Column(name = "storage_quantity")
	private Integer storageQuantity;
	@Column(name = "price")
	private Integer price;
	
}