package ksy.shop.item.dao;

import ksy.shop.item.domain.ItemDTO;
import ksy.shop.item.domain.Item_CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ItemMapper {
    public void insertItem(ItemDTO item);
    public List<ItemDTO> selectItemList(Map<String,String> map);
    public int selectItemCount();
    public ItemDTO selectItem(Long num);



    public void insertItem_Cart(Item_CartDTO item_cart);
    public Item_CartDTO selectItem_Cart(Map<String,Long> map);
    public List<Item_CartDTO> selectItem_CartList(Long mem_num);
    public void deleteItem_Cart(Long mem_num, Long item_num);
}
