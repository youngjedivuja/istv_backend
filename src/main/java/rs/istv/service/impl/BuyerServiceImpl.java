package rs.istv.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.istv.entity.*;
import rs.istv.repository.BuyerRepository;
import rs.istv.service.BuyerService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class BuyerServiceImpl implements BuyerService {

    //private final BuyerRepository buyerRepository;
    @Autowired
    private BuyerRepository buyerRepository;

    @Override
    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }

    @Override
    public Buyer findById(Integer buyerId) {
        return buyerRepository.findById(buyerId)
                .orElseThrow(() -> new NoSuchElementException("BuyerService.notFound"));
    }

    @Override
    public Buyer save(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public Buyer update(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public void deleteById(Integer buyerId) {
        buyerRepository.deleteById(buyerId);
    }


}