package Landlords;

import java.util.*;

/*
斗地主简单实现
 */
public class Landlords01 {
    public static void main(String[] args) {
        // 准备牌
        ArrayList<String> poker = new ArrayList<>();
        // String[] colors = {"\uF346", "\uF3A4", "\uF33C", "\uF325"};
        String[] colors = {"黑桃", "梅花", "红桃", "方块"};
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        poker.add("\uF578"); // 大王
        poker.add("\uF58D"); // 小王
        // poker.add("大王");
        // poker.add("小王");
        for (String co : colors) {
            for (String num : numbers) {
                poker.add(co + num);
            }
        }

        // 洗牌
        Collections.shuffle(poker);
        // System.out.println(poker);

        // 发牌
        ArrayList<String> player01 = new ArrayList<>();
        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();
        for (int i = 0; i < poker.size(); i++) {
            String p = poker.get(i);

            if (i >= 51) {
                diPai.add(p);
            }else if (i % 3 == 0) {
                player01.add(p);
            }else if (i % 3 == 1) {
                player02.add(p);
            }else if (i % 3 == 2) {
                player03.add(p);
            }
        }

        // 查看牌
        System.out.println("player01: " + player01);
        System.out.println("player02: " + player02);
        System.out.println("player03: " + player03);
        System.out.println("底牌: " + diPai);
    }
}
