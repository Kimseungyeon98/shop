package ksy.shop.reservation.dao;

import ksy.shop.reservation.domain.ReservationDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    // select
    ReservationDTO selectReservationByNum(Long num);
    ReservationDTO selectReservationByMemNum(Long mem_num);
    List<ReservationDTO> selectReservationList();

    // insert
    void insertReservation(ReservationDTO reservation);

    // update
    void updateReservation(ReservationDTO reservation);

    //delete
    void deleteReservationByNum(Long num);
}
