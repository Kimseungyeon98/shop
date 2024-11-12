package ksy.shop.reservation.service;

import ksy.shop.reservation.domain.ReservationDTO;

import java.util.List;

public interface ReservationService {
    // select(find)
    ReservationDTO findReservationByNum(Long num);
    ReservationDTO findReservationByMemNum(Long mem_num);
    List<ReservationDTO> findReservationList();

    // insert(save)
    void saveReservation(ReservationDTO reservation);

    // update(update)
    void updateReservation(ReservationDTO reservation);

    // delete(delete)
    void deleteReservationByNum(Long num);
}
