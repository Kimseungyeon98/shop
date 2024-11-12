package ksy.shop.reservation.service;

import ksy.shop.reservation.dao.ReservationMapper;
import ksy.shop.reservation.domain.ReservationDTO;
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
    public ReservationDTO findReservationByNum(Long num) {
        return reservationMapper.selectReservationByNum(num);
    }

    @Override
    public ReservationDTO findReservationByMemNum(Long mem_num) {
        return reservationMapper.selectReservationByMemNum(mem_num);
    }

    @Override
    public List<ReservationDTO> findReservationList() {
        return reservationMapper.selectReservationList();
    }

    @Override
    public void saveReservation(ReservationDTO reservation) {
        reservationMapper.insertReservation(reservation);
    }

    @Override
    public void updateReservation(ReservationDTO reservation) {
        reservationMapper.updateReservation(reservation);
    }

    @Override
    public void deleteReservationByNum(Long num) {
        reservationMapper.deleteReservationByNum(num);
    }
}
