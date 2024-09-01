package ksy.shop.item.dao;

import ksy.shop.item.vo.ItemVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ItemMapper {
    public void insertItem(ItemVO item);
    public List<ItemVO> selectItemList(Map<String,String> map);
}
