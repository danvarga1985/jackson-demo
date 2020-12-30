package com.danvarga.jacksondemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {

    BeerDto getDto() {
        return BeerDto.builder()
                .beerName("Test Beer")
                .beerStyle("Lager")
                .id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastUpdateDate(OffsetDateTime.now())
                .price(new BigDecimal("12.99"))
                .upc(1523452435L)
                .myLocalDate(LocalDate.now())
                .build();
    }
}
