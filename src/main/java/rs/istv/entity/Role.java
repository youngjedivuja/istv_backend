package rs.istv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@NoArgsConstructor
@Table(name = "role")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Role extends Auditable implements GrantedAuthority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "role_id")
	private Integer id;
	@Column(name = "role_name")
	private String roleName;
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;

	@JsonIgnore
	@Override
	public String getAuthority() {
		return String.format("ROLE_%s", getRoleName());
	}

}