package rs.istv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "user_id")
	private Integer id;
	@JoinColumn(name = "person_id", referencedColumnName = "person_id")
	@ManyToOne
	private Person personId;
	@OneToOne(mappedBy = "userId")
	@JsonIgnore
	private Buyer buyerId;
	@Column(name = "username")
	private String username;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@ToString.Exclude
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;




	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getRoles();
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return isEnabled();
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return isEnabled();
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return isEnabled();
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
		//return getRecordStatus() == 1;
	}

}