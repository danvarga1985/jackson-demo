package com.danvarga.jacksondemo.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
class BeerDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {

        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserialization() throws JsonProcessingException {
        String json = "{\"beerName\":\"Test Beer\",\"beerStyle\":\"Lager\",\"upc\":1523452435,\"price\":\"12.99\",\"createdDate\":\"2020-12-30T10:39:24+0100\",\"lastUpdateDate\":\"2020-12-30T10:39:24.945306+01:00\",\"myLocalDate\":\"20201230\",\"beerId\":\"7d93a70e-6de8-4817-8c1b-1f1f7721c2c6\"}\n";

        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}
