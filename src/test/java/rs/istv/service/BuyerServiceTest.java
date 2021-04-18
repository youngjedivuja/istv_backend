package rs.istv.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.istv.entity.Buyer;
import rs.istv.repository.BuyerRepository;
import rs.istv.service.impl.BuyerServiceImpl;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BuyerServiceTest {

    @Mock
    BuyerRepository buyerRepository;

    @InjectMocks
    BuyerServiceImpl buyerService;

    //BDD testing

    //Testing delete by id method
    @Test
    void testDeleteById() {
        //given - none

        //when
        buyerService.deleteById(1);

        //then
        then(buyerRepository).should().deleteById(1);
    }

    //Testing delete by id method with multiple functions calls
    @Test
    void testDeleteByIdMultiple() {
        //given - none

        //when
        buyerService.deleteById(1);
        buyerService.deleteById(1);

        //then
        then(buyerRepository).should(times(2)).deleteById(1);
    }

    //Testing find by id service
    @Test
    void findByIdTest() {
        //given
        Buyer buyer = new Buyer();
        given(buyerRepository.findById(1)).willReturn(Optional.of(buyer));

        //when
        Buyer foundBuyer = buyerService.findById(1);

        //then
        assertThat(foundBuyer).isNotNull();
        then(buyerRepository).should().findById(anyInt());
        then(buyerRepository).shouldHaveNoMoreInteractions();
    }

    //Testing save
    @Test
    void saveTest() {
        //given
        Buyer buyer = new Buyer();
        given(buyerRepository.save(any(Buyer.class))).willReturn(buyer);

        //when
        Buyer savedBuyer = buyerService.save(new Buyer());

        //then
        then(buyerRepository).should().save(any(Buyer.class));
        assertThat(savedBuyer).isNotNull();
    }

    @Test
    void findAllTest(){
        //given
        Buyer buyer = new Buyer();
        List<Buyer> buyers= new ArrayList<>();
        buyers.add(buyer);
        given(buyerRepository.findAll()).willReturn(buyers);

        //when
        List<Buyer> foundBuyers = buyerService.findAll();

        //then
        then(buyerRepository).should().findAll();
        assertThat(foundBuyers).hasSize(1);
    }
}