package ksy.shop.item.service;

import ksy.shop.item.dao.ItemMapper;
import ksy.shop.item.vo.ItemVO;
import ksy.shop.item.vo.Item_CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public void registerItem(ItemVO item) {
        itemMapper.insertItem(item);
    }

    @Override
    public List<ItemVO> getItemList(Map<String, String> map) {
        return itemMapper.selectItemList(map);
    }

    @Override
    public int getItemCount() {
        return itemMapper.selectItemCount();
    }

    @Override
    public ItemVO getItem(Long num) {
        return itemMapper.selectItem(num);
    }




    @Override
    public void registerItem_cart(Item_CartVO item_cartVO){
        itemMapper.insertItem_Cart(item_cartVO);
    }

    @Override
    public Item_CartVO getItem_Cart(Map<String, Long> map) {
        return itemMapper.selectItem_Cart(map);
    }

    @Override
    public List<Item_CartVO> getItem_CartList(Long mem_num) {
        return itemMapper.selectItem_CartList(mem_num);
    }

    @Override
    public void cancleItem_Cart(Long mem_num, Long item_num) {
        itemMapper.deleteItem_Cart(mem_num, item_num);
    }
}
