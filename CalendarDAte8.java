package com.p7;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CalendarDAte8 {
    public static void main(String[] args) throws ParseException {
        // 使用默认时区时钟瞬时时间创造 Clock.systemDefaultZone() -->即相对于
        // ZoneId.systemDefault()默认时区
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // 自定义时区
        LocalDateTime now2 = LocalDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(now2);

        //构造一个对象
        LocalDateTime d1 = LocalDateTime.of(2013,12,31,23,59,59);

        // 解析 String ---> LocalDateTime
        LocalDateTime d4 = LocalDateTime.parse("2013-12-31T23:59:59");
        System.out.println(d4);

        // 使用 DateTimeFormatter API 解析和格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime d6 = LocalDateTime.parse("2013/12/31 23:59:59", formatter);
        System.out.println(d6);

        // 时间获取的一部分
        System.out.println(d6.getYear());
        System.out.println(d6.getMonth());
        System.out.println(d6.getDayOfYear());
        System.out.println(d6.getDayOfMonth());
        System.out.println(d6.getDayOfWeek());
        System.out.println(d6.getHour());
        System.out.println(d6.getMinute());
        System.out.println(d6.getSecond());
        System.out.println(d6.getNano());

        // 时间增减
        LocalDateTime d7 = d6.minusDays(1);
        LocalDateTime d8 = d6.plusHours(1).plusMinutes(30);
        System.out.println(d7);
        System.out.println(d8);
    }
}
