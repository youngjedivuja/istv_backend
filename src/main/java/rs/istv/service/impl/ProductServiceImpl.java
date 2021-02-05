package rs.istv.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.istv.entity.*;
import rs.istv.repository.ProductRepository;
import rs.istv.service.ProductService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(Integer productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new NoSuchElementException("ProductService.notFound"));
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product update(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteById(Integer productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public Product updateRecordStatus(Integer productId) {
		Product product = findById(productId);
		product.setRecordStatus(product.getRecordStatus() > 0 ? 0 : 1);
		return productRepository.save(product);
	}


}