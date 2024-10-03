package ksy.shop.item.dao;

import ksy.shop.item.vo.ItemVO;
import ksy.shop.item.vo.Item_CartVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ItemMapper {
    public void insertItem(ItemVO item);
    public List<ItemVO> selectItemList(Map<String,String> map);
    public int selectItemCount();
    public ItemVO selectItem(Long num);



    public void insertItem_Cart(Item_CartVO item_cart);
    public Item_CartVO selectItem_Cart(Map<String,Long> map);
    public List<Item_CartVO> selectItem_CartList(Long mem_num);
    public void deleteItem_Cart(Long mem_num, Long item_num);
}
