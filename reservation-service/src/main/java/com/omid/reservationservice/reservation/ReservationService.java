package com.omid.reservationservice.reservation;

import ir.huri.jcal.JalaliCalendar;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final MongoTemplate mongoTemplate;
    private final GuestServiceClient guestServiceClient;
    private final RoomServiceClient roomServiceClient;
    private static final ZoneId zoneId = ZoneId.of("Asia/Tehran");
    private final ReservationRepository reservationRepository;

    public ReservationDto createReservation(String questId, String roomId, Long from, Long to) {

        Reservation reservation = new Reservation();

        JalaliCalendar f = new JalaliCalendar(Instant.ofEpochMilli(from).atZone(zoneId).toLocalDate());
        JalaliCalendar t = new JalaliCalendar(Instant.ofEpochMilli(to).atZone(zoneId).toLocalDate());
        reservation.setFrom(Instant.ofEpochMilli(from).atZone(zoneId).toLocalDate());
        reservation.setTo(Instant.ofEpochMilli(to).atZone(zoneId).toLocalDate());

        Guest guest = guestServiceClient.loadGuestById(questId);
        Room room = roomServiceClient.getRoomById(roomId);
        reservation.setGuest(guest);
        reservation.setRoom(room);


        int days = t.getDay() - f.getDay();
        reservation.setTotalPrice(days * reservation.getPrice());

        ReservationDto reservationDto = new ReservationDto(reservation);
        reservationDto.setFrom(f.toString());
        reservationDto.setTo(t.toString());

        mongoTemplate.insert(reservation);

        return reservationDto;
    }

    public List<ReservationDto> loadAllReservations() {
        List<Reservation> reservations = mongoTemplate.findAll(Reservation.class);
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        for (Reservation r : reservations) {
            ReservationDto reservationDto = new ReservationDto(r);
            JalaliCalendar f = new JalaliCalendar(r.getFrom());
            JalaliCalendar t = new JalaliCalendar(r.getTo());
            reservationDto.setFrom(f.toString());
            reservationDto.setTo(t.toString());
            reservationDtoList.add(reservationDto);
        }
        return reservationDtoList;
    }

    public List<ReservationDto> searchReservation(Long from, Long to) {
        LocalDate f=Instant.ofEpochMilli(from).atZone(zoneId).toLocalDate();
        LocalDate t=Instant.ofEpochMilli(to).atZone(zoneId).toLocalDate();

        Query q = new Query();
        q.addCriteria(Criteria.where("").orOperator(
                Criteria.where("from").gte(from),
                Criteria.where("from").lt(to)
                ));
        List<ReservationDto> reservationDtoList = new ArrayList<>();
//        List<Reservation> reservations=mongoTemplate.find(q, Reservation.class);
        List<Reservation> reservations=reservationRepository.findByFromBetween(f,t);
        for(Reservation r:reservations) {
            ReservationDto reservationDto = new ReservationDto(r);
            reservationDtoList.add(reservationDto);
        }

        return reservationDtoList;

    }


}
