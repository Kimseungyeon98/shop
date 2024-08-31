package ksy.shop.item.service;

import ksy.shop.item.dao.ItemMapper;
import ksy.shop.item.vo.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public void registerItem(ItemVO item) {
        itemMapper.insertItem(item);
    }
}
