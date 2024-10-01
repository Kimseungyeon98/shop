package ksy.shop.util;

public class DateUtil {
    // yy:MM:dd hh:mm:ss

    // date -> yy:MM:dd
    public static String formattingDate(String date){
        return date.substring(0,10).replaceAll(":","");
    }

}
