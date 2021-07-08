package com.p4;

enum Direction {
    EAST("东",1),SOUST("南",2),
    WEsT("西",3),NORTH("北",4);

    private String desc;
    private int num;

    private Direction(String desc, int num) {
        this.desc = desc;
        this.num = num;
    }

    public String getDesc() { return desc; }
    public int getNum() { return num; }
}

public class EnumDemo2 {
    public static void main(String[] args) {
        Direction dir = Direction.NORTH;
        for (Direction d : Direction.values())
            System.out.println(
                    d.getDesc() + "," + d.getNum() + "," + d.ordinal()
            );
    }
}
