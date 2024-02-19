package com.dmytrobozhor.airlinereservationservice.web.controller;

import com.dmytrobozhor.airlinereservationservice.domain.Passenger;
import com.dmytrobozhor.airlinereservationservice.domain.embeddable.AdditionalInfo;
import com.dmytrobozhor.airlinereservationservice.domain.embeddable.PersonalInfo;
import com.dmytrobozhor.airlinereservationservice.dto.PassengerDto;
import com.dmytrobozhor.airlinereservationservice.dto.PassengerPartialUpdateDto;
import com.dmytrobozhor.airlinereservationservice.dto.PassengerSaveDto;
import com.dmytrobozhor.airlinereservationservice.service.AbstractPassengerService;
import com.dmytrobozhor.airlinereservationservice.util.mappers.PassengerMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// TODO: fix mapper. a lot of problems because of embedded components
@RestController
@RequestMapping("/passengers")
@RequiredArgsConstructor
public class PassengerController {

    private final AbstractPassengerService passengerService;

    private final PassengerMapper passengerMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PassengerDto> getAllPassengers() {
        return passengerMapper.toPassengerDto(passengerService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PassengerDto savePassenger(@RequestBody @Valid PassengerSaveDto passengerDto) {
//        var passenger = passengerMapper.toPassenger(
//                passengerMapper.toPersonalInfo(passengerDto),
//                passengerMapper.toAdditionalInfo(passengerDto));
        var passenger = passengerMapper.toPassenger(passengerDto);
        return passengerMapper.toPassengerDto(passengerService.save(passenger));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PassengerDto getPassengerById(@PathVariable Long id) {
        return passengerMapper.toPassengerDto(passengerService.findById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PassengerDto deletePassengerById(@PathVariable Long id) {
        return passengerMapper.toPassengerDto(passengerService.deleteById(id));
    }

    //   TODO: make hibernate validation for phone number field instead of jpa validation
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PassengerDto updatePassenger(
            @RequestBody @Valid PassengerPartialUpdateDto passengerDto, @PathVariable Long id) {
//        var passenger = passengerMapper.toPassenger(
//                passengerMapper.toPersonalInfo(passengerDto),
//                passengerMapper.toAdditionalInfo(passengerDto));
        var passenger = passengerMapper.toPassenger(passengerDto);
        return passengerMapper.toPassengerDto(passengerService.updateById(id, passenger));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PassengerDto updateOrCreatePassenger(
            @RequestBody @Valid PassengerSaveDto passengerDto, @PathVariable Long id) {
//        var passenger = passengerMapper.toPassenger(
//                passengerMapper.toPersonalInfo(passengerDto),
//                passengerMapper.toAdditionalInfo(passengerDto));
        var passenger = passengerMapper.toPassenger(passengerDto);
        return passengerMapper.toPassengerDto(passengerService.updateOrCreateById(id, passenger));
    }

}
