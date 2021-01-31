package rs.istv.service;

import java.util.Collection;
import java.util.List;
import rs.istv.entity.*;

public  interface BuyerService {

	List<Buyer> findAll();

	Buyer save(Buyer buyer);

	Buyer update(Buyer buyer);

	Buyer findById(Integer buyerId);

	void deleteById(Integer buyerId);

}