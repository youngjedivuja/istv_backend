package rs.istv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "buyer")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "buyer_id")
	private Integer id;
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@OneToOne
	private User userId;
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "city")
	private String city;
	
}