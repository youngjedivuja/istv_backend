package rs.istv.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.istv.entity.*;
import rs.istv.repository.RoleRepository;
import rs.istv.service.RoleService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class RoleServiceImpl implements RoleService {
	private final RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(Integer roleId) {
		return roleRepository.findById(roleId)
				.orElseThrow(() -> new NoSuchElementException("RoleService.notFound"));
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role update(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void deleteById(Integer roleId) {
		roleRepository.deleteById(roleId);
	}


}