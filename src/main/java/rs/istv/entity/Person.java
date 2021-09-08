package rs.istv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "person")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "person_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "unid")
	private String unid;
	@Column(name = "pin")
	private String pin;
	@Column(name = "birth_date")
	private LocalDate birthDate;
	@Column(name = "gender")
	private String gender;
	
}