package practice;
import java.util.*;
import java.util.Scanner;

public class sample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inarr1 = sc.next().split(",");
        String[] inarr2 = sc.next().split(",");
        
        String instr1 = sc.next();
        String instr2 = sc.next();

        int[] map1 = new int[26];
        int[] map2 = new int[26];
        int[] map3 = new int[26];
        int[] map4 = new int[26];



        for (int i = 0; i < inarr1.length; i++) {
            char ch = inarr1[i].charAt(0);
            map1[ch - 'a']++;
        }
        for (int i = 0; i < inarr2.length; i++) {
            char ch = inarr2[i].charAt(0);
            map2[ch - 'a']++;
        }

        for (int i = 0; i < instr1.length(); i++) {
            char ch = instr1.charAt(i);
            map3[ch - 'a']++;
        }

        for (int i = 0; i < instr2.length(); i++) {
            char ch = instr2.charAt(i);
            map4[ch - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            int x1 = Math.min(map1[i], map2[i]);
            int x2 = Math.min(map3[i], map4[i]);
            ans += Math.min(x1, x2);


        }

        System.out.println(ans);



      








    }
}