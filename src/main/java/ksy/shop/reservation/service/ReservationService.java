package ksy.shop.reservation.service;

import ksy.shop.reservation.vo.ReservationVO;

public interface ReservationService {
    // select(find)
    ReservationVO findReservationByNum(Long num);
    ReservationVO findReservationByMemNum(Long mem_num);

    // insert(create)
    void createReservation(ReservationVO reservation);

    // update(modify)
    void modifyResrver(ReservationVO reservation);

    //delete(remove)
    void removeReservationByNum(Long num);
}
