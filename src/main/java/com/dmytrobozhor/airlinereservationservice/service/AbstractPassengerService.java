package com.dmytrobozhor.airlinereservationservice.service;

import com.dmytrobozhor.airlinereservationservice.domain.Passenger;

import java.util.Optional;

public interface AbstractPassengerService extends AbstractCrudService<Passenger, Long> {

    Optional<Passenger> findByPhoneNumber(String phoneNumber);

}
