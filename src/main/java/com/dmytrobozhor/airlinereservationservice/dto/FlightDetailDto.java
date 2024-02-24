package com.dmytrobozhor.airlinereservationservice.dto;

import com.dmytrobozhor.airlinereservationservice.util.annotations.DateConstraint;
import com.dmytrobozhor.airlinereservationservice.util.annotations.EnumBasedString;
import com.dmytrobozhor.airlinereservationservice.util.enums.AirplaneType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;

//@DateConstraint
//@AirportConstraint
public record FlightDetailDto(

        @NotNull
        Long id,

        @NotNull
        Timestamp departureDateTime,

        @NotNull
        Timestamp arrivalDateTime,

        //TODO: * make the value of the airplaneType to uppercase using annotation and beanPostProcessor
        @NotNull
//        @Length(max = 255)
//        @EnumBasedString(enumClass = AirplaneType.class)
        AirplaneType airplaneType,

        @NotNull
        Long sourceAirportId,

        @NotNull
        Long destinationAirportId

) {
}
