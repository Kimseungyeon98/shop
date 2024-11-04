package ksy.shop.reservation.dao;

import ksy.shop.reservation.vo.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationMapper {
    // select
    ReservationVO selectReservationByNum(Long num);
    ReservationVO selectReservationByMemNum(Long mem_num);

    // insert
    void insertReservation(ReservationVO reservation);

    // update
    void updateReservation(ReservationVO reservation);

    //delete
    void deleteReservationByNum(Long num);
}
