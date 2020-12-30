package com.danvarga.jacksondemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    /*
     A .Set property name format in JSON serialization.
     B. Overwrites 'PropertyNamingStrategy' (both default & profile)
    */
    @JsonProperty("beerId")
    @Null
    private UUID id;

    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    @Positive
    private Long upc;

    // Set property format in JSON serialization - number->string
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;

    /*
     OffSetDateTime is poorly formattable during deserialization, because it always requires Time & Offset - for date
     parsing only (e.g. 2020-12-25), using LocalDate is more adequate.
    */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    private OffsetDateTime lastUpdateDate;

    // Set to use the custom LocalDateSerializer.class.
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate myLocalDate;

}
