package treeAss;

import java.util.*;


public class Main {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		int[] post = takeInput();
		int[] in = takeInput();
		BinaryTree bt = m.new BinaryTree(post, in);
		bt.display();
	}

	public static int[] takeInput() {
		int n = scn.nextInt();

		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			rv[i] = scn.nextInt();
		}

		return rv;
	}

   

	private class BinaryTree {
		

       
        

        

		private Node root;
		private int size;
        HashMap<Integer, Integer> map;
        int idx;

		public BinaryTree(int[] post, int[] in) {
			this.root = this.construct(post, 0, post.length - 1, in, 0, in.length - 1);
		}



		private Node construct(int[] post, int plo, int phi, int[] in, int ilo, int ihi) {

			// write your code here
            idx = phi;
            map = new HashMap<>();
            
            for(int i = 0; i <= ihi; i++){
                

                map.put(in[i], i);
            }



            return createTree(post, in, 0, ihi);
            // return 
		}

        private Node createTree(int[] postorder, int[] inorder, int left, int right) {
            if(right < left) return null;
            if(idx < 0) return null;
            
            int pos = map.get(postorder[idx--]);
            Node root = new Node(inorder[pos]);
            
            root.right = createTree(postorder, inorder, pos + 1, right);

            root.left = createTree(postorder, inorder, left, pos - 1);


        
            return root;
        
        }

		public void display() {
			this.display(this.root);
		}

		private void display(Node node) {
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

			this.display(node.left);
			this.display(node.right);
		}

	}
    

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
