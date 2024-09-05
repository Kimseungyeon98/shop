package ksy.shop.util;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class PagingUtil {
    // startRow : 시작 번호
    // endRow : 끝 번호
    // currentPage : 현재 페이지
    // itemNum : 한 페이지의 아이템 갯수

    public static Map<String,String> paging(String currentPage, String itemNum){
        int currentPageTmp = Integer.parseInt(currentPage);
        int itemNumTmp = Integer.parseInt(itemNum);

        Map<String,String> map = new HashMap<>();
        String startRow = String.valueOf(((currentPageTmp-1)*(itemNumTmp))+1);
        String endRow = String.valueOf(((currentPageTmp)*(itemNumTmp))+1);

        map.put("startRow", startRow);
        map.put("endRow", endRow);
        map.put("currentPage", currentPage);
        map.put("itemNum",itemNum);

        return map;
    }
}