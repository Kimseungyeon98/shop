package ksy.shop.item.service;

import ksy.shop.item.vo.ItemVO;
import ksy.shop.item.vo.Item_CartVO;

import java.util.List;
import java.util.Map;

public interface ItemService {
    public void registerItem(ItemVO item);
    public List<ItemVO> getItemList(Map<String,String> map);
    public int getItemCount();
    public ItemVO getItem(Long num);

    public void registerItem_cart(Item_CartVO item_cartVO);
}
