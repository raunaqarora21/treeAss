package treeAss;

import java.util.HashMap;
import java.util.Scanner;



public class largestBST {
   static HashMap<Integer, Integer> map;
   static Info val;
   static int idx;

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new HashMap<>();

        idx = 0;
        int[] preorder = new int[n];
        int[] inorder = new int[n];

        for(int i = 0; i < n; i++){
            preorder[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        for(int i = 0; i < n; i++){
            
            inorder[i] = sc.nextInt();
            map.put(inorder[i], i);
        }
        val = new Info();

        Node root = createTree(preorder, inorder, 0, n - 1);
        // int ans = checkForBSTHelper(root);
        display(root);
        // System.out.println();
        // System.out.println(ans);
        sc.close();

   }



private static int checkForBSTHelper(Node root) {
    checkForBST(root, val, val, val, val);
    return val.max_size;
}



private static int checkForBST(Node root, Info maxRef, Info minRef, Info max_sizeRef, Info isBstRef) {
    if(root == null){
        isBstRef.is_bst = true;
        return 0;
    }
    boolean left = false;
    int min = Integer.MAX_VALUE;
    maxRef.max = Integer.MIN_VALUE;
    
    int leftSize, rightSize;
    leftSize = checkForBST(root.left, maxRef, minRef, max_sizeRef, isBstRef);
    if(isBstRef.is_bst && root.data > maxRef.max){
        left = true;
    }
    

    boolean right = false;

    minRef.min = Integer.MAX_VALUE;
    rightSize = checkForBST(root.right, maxRef, minRef, max_sizeRef, isBstRef);
    if(isBstRef.is_bst && root.data < minRef.min){
        right = true;
    }

    min = minRef.min;
    if(root.data < minRef.min){
        minRef.min = root.data;
    }

    if(root.data > maxRef.max){
        maxRef.max = root.data;
    }
    

    if(left && right){
        if(leftSize + rightSize + 1 > max_sizeRef.max_size){
            max_sizeRef.max_size = leftSize + rightSize + 1;
        }
        return leftSize + rightSize + 1;

    }else{
        isBstRef.is_bst = false;
        return 0;
    }
   

}



private static int height(Node root) {
    if(root == null) return -1;
    return 1 + Math.max(height(root.left), height(root.right));
}



private static boolean isBST(Node root, int maxValue, int minValue) {
    if(root == null) return true;
    if(root.data >= maxValue || root.data <= minValue) return false;

    return isBST(root.left, root.data, minValue) && isBST(root.right, maxValue, root.data);
}





private static void display(Node node) {
    if (node == null) {
        return;
    }

    String str = "";

    if (node.left != null) {
        str += node.left.data;
    } else {
        str += "END";
    }

    str += " => " + node.data + " <= ";

    if (node.right != null) {
        str += node.right.data;
    } else {
        str += "END";
    }

    System.out.println(str);

    display(node.left);
    display(node.right);
}


private static Node createTree(int[] preorder, int[] inorder, int left, int right) {
    if(right < left) return null;
    
    int pos = map.get(preorder[idx++]);
    Node root = new Node(inorder[pos]);
    root.left = createTree(preorder, inorder, left, pos - 1);
    root.right = createTree(preorder, inorder, pos + 1, right);

    return root;

}







}
class Info{
    
    int max_size = 0;
    boolean is_bst = false;
    int min = Integer.MAX_VALUE;  
    int max = Integer.MIN_VALUE;
    
}

class Node{
    int data;
    Node left;
    Node right;
    Node(){};
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
    
}
