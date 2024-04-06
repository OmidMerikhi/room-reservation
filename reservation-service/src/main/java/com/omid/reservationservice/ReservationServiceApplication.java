package com.omid.reservationservice;

import ir.huri.jcal.JalaliCalendar;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ReservationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(){
//        return args -> {
//            JalaliCalendar j=new JalaliCalendar(LocalDate.now());
//            System.out.print(j.getTomorrow().getDayOfWeekDayMonthString());
//        };
//    }

}
