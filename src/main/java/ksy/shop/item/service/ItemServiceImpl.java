package ksy.shop.item.service;

import ksy.shop.item.dao.ItemMapper;
import ksy.shop.item.vo.ItemVO;
import ksy.shop.item.vo.Item_CartVO;
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
}
