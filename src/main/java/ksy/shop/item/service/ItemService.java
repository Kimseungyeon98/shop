package ksy.shop.item.service;

import ksy.shop.item.domain.ItemDTO;
import ksy.shop.item.domain.Item_CartDTO;

import java.util.List;
import java.util.Map;

public interface ItemService {
    public void registerItem(ItemDTO item);
    public List<ItemDTO> getItemList(Map<String,String> map);
    public int getItemCount();
    public ItemDTO getItem(Long num);

    public void registerItem_cart(Item_CartDTO item_cartVO);
    public Item_CartDTO getItem_Cart(Map<String,Long> map);
    public List<Item_CartDTO> getItem_CartList(Long mem_num);
    public void cancleItem_Cart(Long mem_num,Long item_num);
}
