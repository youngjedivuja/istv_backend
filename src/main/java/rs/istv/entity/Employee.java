package rs.istv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "employee")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Employee extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "employee_id")
	private Integer id;
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@ManyToOne
	private User userId;
	@Column(name = "position")
	private String position;
	@Column(name = "bank")
	private String bank;
	@Column(name = "employmend_start_date")
	private LocalDate employmendStartDate;
	@Column(name = "employmend_end_date")
	private LocalDate employmendEndDate;
	
}