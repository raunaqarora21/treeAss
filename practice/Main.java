package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] mat = new int[n][m];

        // HashSet<Integer> row = new HashSet<>();
        // HashSet<Integer> col = new HashSet<>();

        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();

        

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1){
                    // if(row.contains(i) || col.contains(j)) ans++;
                    row.put(i, row.getOrDefault(i, 0) + 1);
                    col.put(j, col.getOrDefault(j, 0) + 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j] == 1){
                   
                
                if(row.containsKey(i) && row.get(i) > 1){
                   ans++;
                }
                else if(col.containsKey(j) && col.get(j) > 1){
                    ans++;
                }
            }
            }
            
        }

        System.out.println(ans);


    }
    
}
