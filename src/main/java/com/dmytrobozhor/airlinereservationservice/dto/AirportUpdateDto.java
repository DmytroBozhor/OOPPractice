package com.dmytrobozhor.airlinereservationservice.dto;

import org.hibernate.validator.constraints.Length;

public record AirportUpdateDto(

        @Length(max = 255)
        String name,

        @Length(max = 255)
        String city,

        @Length(max = 255)
        String country

) {
}
