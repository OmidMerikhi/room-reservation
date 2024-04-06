package com.omid.reservationservice.reservation;

import ir.huri.jcal.JalaliCalendar;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Queue;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final MongoTemplate mongoTemplate;
    private final GuestServiceClient guestServiceClient;
    private final RoomServiceClient roomServiceClient;

    public Reservation createReservation(String questId,
                                         String roomId,
                                         String from,
                                         String to) {
        Reservation reservation=new Reservation();

        JalaliCalendar f=new JalaliCalendar();
        f.set(Integer.parseInt(from.substring(0,4)),
                Integer.parseInt(from.substring(5,6)),
                Integer.parseInt(from.substring(7,9)));

        JalaliCalendar t=new JalaliCalendar();
        t.set(Integer.parseInt(to.substring(0,4)),
                Integer.parseInt(to.substring(5,6)),
                Integer.parseInt(to.substring(7,9)));

        Guest guest=guestServiceClient.loadGuestById(questId);
        Room room=roomServiceClient.getRoomById(roomId);
        reservation.setGuest(guest);
        reservation.setRoom(room);
        reservation.setFrom(f);
        reservation.setTo(t);

        int days=reservation.getTo().getDay()-reservation.getFrom().getDay();
        reservation.setTotalPrice(days*reservation.getPrice());

        return mongoTemplate.insert(reservation);
    }

    public List<Reservation> loadAllReservations() {
        return mongoTemplate.findAll(Reservation.class);
    }

    public List<Reservation> searchReservation(JalaliCalendar from, JalaliCalendar to){
        Query q=new Query();
        q.addCriteria(Criteria.where("").andOperator(
                Criteria.where("from").is(from),
                Criteria.where("from").is(to)
        ));
        return mongoTemplate.find(q, Reservation.class);

    }


}
