package com.omid.guestservice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final MongoTemplate mongoTemplate;
    private final ReactiveRedisTemplate reactiveRedisTemplate;

    public List<Guest> loadAllGuests() {
        return mongoTemplate.findAll(Guest.class);
    }

    public Guest loadOneGuest(String guestId) {
        return mongoTemplate.findById(guestId, Guest.class);
    }

    public Guest createGuest(Guest guest) {
        return mongoTemplate.insert(guest);
    }

    public Guest updateGuest(String id, Guest guest) {
        Guest dbGuest=loadOneGuest(id);
        if(guest.getFirstName()!=null){
            dbGuest.setFirstName(guest.getFirstName());
        }
        if(guest.getLastName()!=null){
            dbGuest.setLastName(guest.getLastName());
        }
        if(guest.getNationalCode()!=null){
            dbGuest.setNationalCode(guest.getNationalCode());
        }
        if(guest.getPhoneNumber()!=null){
            dbGuest.setPhoneNumber(guest.getPhoneNumber());
        }
        if(guest.getCity()!=null){
            dbGuest.setCity(guest.getCity());
        }

        return mongoTemplate.save(dbGuest);
    }

    public List<Guest> searchGuest(String value) {
        Query q=new Query();
        q.addCriteria(Criteria.where("")
                .orOperator(
                Criteria.where("firstName").regex(value),
                Criteria.where("lastName").regex(value),
                Criteria.where("nationalCode").is(value),
                Criteria.where("personType").is(value),
                Criteria.where("city").regex(value)));
        return mongoTemplate.find(q, Guest.class);

    }
}
