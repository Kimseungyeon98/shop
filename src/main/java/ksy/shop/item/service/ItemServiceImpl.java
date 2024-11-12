package ksy.shop.item.service;

import ksy.shop.item.dao.ItemMapper;
import ksy.shop.item.domain.ItemDTO;
import ksy.shop.item.domain.Item_CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public void registerItem(ItemDTO item) {
        itemMapper.insertItem(item);
    }

    @Override
    public List<ItemDTO> getItemList(Map<String, String> map) {
        return itemMapper.selectItemList(map);
    }

    @Override
    public int getItemCount() {
        return itemMapper.selectItemCount();
    }

    @Override
    public ItemDTO getItem(Long num) {
        return itemMapper.selectItem(num);
    }




    @Override
    public void registerItem_cart(Item_CartDTO item_cartVO){
        itemMapper.insertItem_Cart(item_cartVO);
    }

    @Override
    public Item_CartDTO getItem_Cart(Map<String, Long> map) {
        return itemMapper.selectItem_Cart(map);
    }

    @Override
    public List<Item_CartDTO> getItem_CartList(Long mem_num) {
        return itemMapper.selectItem_CartList(mem_num);
    }

    @Override
    public void cancleItem_Cart(Long mem_num, Long item_num) {
        itemMapper.deleteItem_Cart(mem_num, item_num);
    }
}
