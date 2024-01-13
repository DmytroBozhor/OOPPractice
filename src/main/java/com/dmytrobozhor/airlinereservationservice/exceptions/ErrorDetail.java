package com.dmytrobozhor.airlinereservationservice.exceptions;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDetail {

    private String message;

    private Date timestamp;

    private String detailInfo;

}
