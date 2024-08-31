package ksy.shop.item.dao;

import ksy.shop.item.vo.ItemVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {
    public void insertItem(ItemVO item);
}
