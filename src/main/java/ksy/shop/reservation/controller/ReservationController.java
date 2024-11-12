package ksy.shop.reservation.controller;

import jakarta.servlet.http.HttpSession;
import ksy.shop.member.service.MemberService;
import ksy.shop.member.domain.MemberDTO;
import ksy.shop.reservation.service.ReservationService;
import ksy.shop.reservation.domain.ReservationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@Slf4j
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private MemberService memberService;

    // 예약 메인 페이지
    @GetMapping("/reservations")
    public String mainReservation(Model model){
        // 로그인 되어 있을 때만 진입 가능
        // 단, restful 하게 설계 하기 위해서 session으로 처리하지 않고 jwt나 Oauth를 사용해야함

        /* 로그인 처리 시작 */

        /* 로그인 처리 끝 */

        List<ReservationDTO> reservationList = reservationService.findReservationList();

        model.addAttribute("reservationList", reservationList);
        return "reservation/main";
    }

    // 예약 생성 페이지(회원번호)
    @PostMapping("/reservations")
    @ResponseBody
    public HashMap<String,String> createReservation(HttpSession session){
        HashMap<String,String> map = new HashMap<>();
        MemberDTO user = (MemberDTO)session.getAttribute("user");

        //로그인 확인
        if(user!=null){
            /* 예약 로직 시작 */
            ReservationDTO reservation = new ReservationDTO();


            Date date = new Date();
            date.setMonth(date.getMonth()+2);
            reservation.setEnd_date(date.toString());

            reservationService.saveReservation(reservation);

            /* 예약 로직 끝 */
            map.put("result", "예약 성공");
        } else {
            map.put("result", "예약 실패 (로그인 안하신듯?)");
        }

        return map;
    }

    // 예약 조회 페이지(예약번호)
    @GetMapping("/reservations/{num}")
    public String viewReservation(@PathVariable("num") Long num, Model model){
        ReservationDTO reservation = reservationService.findReservationByNum(num);

        model.addAttribute("reservation", reservation);

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
        reservationService.deleteReservationByNum(num);
        return "reservation";
    }
}
