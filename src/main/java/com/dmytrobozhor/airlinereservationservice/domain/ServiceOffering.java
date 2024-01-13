package com.dmytrobozhor.airlinereservationservice.domain;

import com.dmytrobozhor.airlinereservationservice.util.compositeid.ServiceOfferingId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "service_offering")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceOffering {

    @EmbeddedId
    private ServiceOfferingId id;

    @Column(name = "offered", nullable = false)
    private Boolean offered;

    @Column(name = "from_date")
    private Timestamp formDate;

    @Column(name = "to_date")
    private Timestamp toDate;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "travel_class_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    @MapsId(value = "travelClassId")
    private TravelClass travelClass;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "flight_service_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    @MapsId(value = "flightServiceId")
    private FlightService flightService;

}
