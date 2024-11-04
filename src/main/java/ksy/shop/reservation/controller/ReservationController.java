package ksy.shop.reservation.controller;

import ksy.shop.reservation.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    // 예약 메인 페이지
    @GetMapping("/reservations")
    public String mainReservation(){


        return "reservation";
    }

    // 예약 생성 페이지(회원번호)
    @PostMapping("/reservations")
    public String createReservation(){


        return "reservation";
    }

    // 예약 조회 페이지(예약번호)
    @GetMapping("/reservations/{num}")
    public String viewReservation(@PathVariable("num") Long num){


        return "reservation";
    }

    // 예약 수정 페이지(예약번호, 회원번호)
    @PutMapping("/reservations/{num}")
    public String modifyReservation(@PathVariable("num") Long num){


        return "reservation";
    }

    // 예약 삭제 페이지(예약번호, 회원번호)
    @DeleteMapping("/reservations/{num}")
    public String removeReservation(@PathVariable("num") Long num){


        return "reservation";
    }
}
