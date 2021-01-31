package rs.istv.service;

import java.util.Collection;
import java.util.List;
import rs.istv.entity.*;

public  interface ProductService {

	List<Product> findAll();

	Product save(Product product);

	Product update(Product product);

	Product findById(Integer productId);

	void deleteById(Integer productId);

}