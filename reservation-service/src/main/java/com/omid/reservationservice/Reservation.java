package com.omid.reservationservice;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Reservation {
    @Id
    private String id;
    private String customerFullName;
    private String customerId;
    private String roomTitle;
    private String roomId;
    private LocalDateTime reservationDate;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private String reservationCode;
    private Long totalPrice;

    public Reservation() {
        this.id=UUID.randomUUID().toString();
        this.reservationCode = id.substring(9,12);
        this.reservationDate=LocalDateTime.now();
    }
}
