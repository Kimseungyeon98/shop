package ksy.shop.reservation.service;

import ksy.shop.reservation.vo.ReservationVO;

import java.util.List;

public interface ReservationService {
    // select(find)
    ReservationVO findReservationByNum(Long num);
    ReservationVO findReservationByMemNum(Long mem_num);
    List<ReservationVO> findReservationList();

    // insert(save)
    void saveReservation(ReservationVO reservation);

    // update(update)
    void updateReservation(ReservationVO reservation);

    // delete(delete)
    void deleteReservationByNum(Long num);
}
