package ksy.shop.reservation.service;

import ksy.shop.reservation.dao.ReservationMapper;
import ksy.shop.reservation.vo.ReservationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ResrvationServiceImpl implements ReservationService{

    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    public ReservationVO findReservationByNum(Long num) {
        return reservationMapper.selectReservationByNum(num);
    }

    @Override
    public ReservationVO findReservationByMemNum(Long mem_num) {
        return reservationMapper.selectReservationByMemNum(mem_num);
    }

    @Override
    public List<ReservationVO> findReservationList() {
        return reservationMapper.selectReservationList();
    }

    @Override
    public void saveReservation(ReservationVO reservation) {
        reservationMapper.insertReservation(reservation);
    }

    @Override
    public void updateReservation(ReservationVO reservation) {
        reservationMapper.updateReservation(reservation);
    }

    @Override
    public void deleteReservationByNum(Long num) {
        reservationMapper.deleteReservationByNum(num);
    }
}
