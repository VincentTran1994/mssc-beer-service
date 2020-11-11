package com.springframework.msscbeerservice.boostrap;

import com.springframework.msscbeerservice.domain.Beer;
import com.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {
    @Autowired
    private  BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerObject();
        System.out.println("Bean loading : " + beerRepository.count());
    }

    private void loadBeerObject(){
        if(beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
                    .beerName("Vu Tran")
                    .beerStyle("APO")
                    .minOnHand(10)
                    .upc(12345689L)
                    .quanityToBeer(120)
                    .price(new BigDecimal(12.50))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Hao Do")
                    .beerStyle("EFP")
                    .minOnHand(11)
                    .upc(12345444L)
                    .quanityToBeer(150)
                    .price(new BigDecimal(19.50))
                    .build());
        }
    }
}
