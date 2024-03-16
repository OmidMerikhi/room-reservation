package com.omid.reservationservice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final RoomServiceClient roomServiceClient;
    private final CustomerServiceClient customerServiceClient;
    private final MongoTemplate mongoTemplate;

    public Reservation create(String customerNationalCode, String roomId, Long fromDate, Long toDate){
        ZoneId zoneId = ZoneId.systemDefault();
        Reservation reservation=new Reservation();
        Room room=roomServiceClient.loadById(roomId);

        Customer customer=customerServiceClient.loadAllCustomer()
                .stream()
                .filter(c-> c.getNationalCode().equals(customerNationalCode)).findFirst().orElse(null);

        reservation.setFromDate(Instant.ofEpochMilli(fromDate).atZone(zoneId).toLocalDateTime());
        reservation.setToDate(Instant.ofEpochMilli(toDate).atZone(zoneId).toLocalDateTime());
        if(customer!=null){
            reservation.setCustomerFullName(customer.getFirstName()+" "+customer.getLastName());
            reservation.setCustomerId(customer.getId());
        }
        reservation.setRoomId(room.getId());

        reservation.setRoomTitle(room.getTitle());

        int days= reservation.getToDate().getDayOfMonth() - reservation.getFromDate().getDayOfMonth();
        reservation.setTotalPrice(room.getPrice()*days);
        mongoTemplate.insert(reservation);
        return reservation;
    }

    public List<Reservation> loadAll(){
        return mongoTemplate.findAll(Reservation.class);
    }
}
