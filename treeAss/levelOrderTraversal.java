package treeAss;

import java.util.*;

public class levelOrderTraversal {
    static Scanner scn = new Scanner(System.in);
    static ArrayList<ArrayList<Integer>> res;
    static int sum;

	public static void main(String[] args) {
		levelOrderTraversal m = new levelOrderTraversal();
		BinaryTree bt = m.new BinaryTree();
        // res = new ArrayList<>();
        sum = 0;


		// bt.levelOrderZZ();
        
        // int sum  = scn.nextInt();
        // bt.findSum(bt.root, sum, new ArrayList<>());


        // int p = scn.nextInt();
        // int q = scn.nextInt();
        // System.out.println(bt.findLCA(bt.root, p, q).data);

        // bt.levelOrder();

        // bt.removeLeaves(bt.root);

        //  bt.display();
        // ArrayList<Integer> ans = new ArrayList<>();
        // bt.sibling(bt.root, ans);
        // for (int i = 0; i <  ans.size();i++) {
        //     // if(ans.get(i) != bt.root.data){
        //         System.out.print(ans.get(i) + " ");
            
        // }
        // System.out.println();

        // bt.levelOrder();
        
        // System.out.println(bt.sum(bt.root));

        // int val  = bt.isBalanced(bt.root);
        // System.out.println(val != -1);

        
       



	}

	

    class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public int isBalanced(Node root) {
            if(root == null) return 0;
            int lh = isBalanced(root.left);
            int rh = isBalanced(root.right);
            if(lh == -1 || rh == -1) return -1;
            if(Math.abs(lh - rh) > 1) return -1;
            return 1 + Math.max(lh, rh);
        }

        public int sum(Node root) {
            if(root == null) return 0;
            int left = sum(root.left);
            int right=  sum(root.right);
            return left + right + root.data;

        }

        public void sibling(Node root, ArrayList<Integer> ans) {
            if(root == null) return;
            

            if(root.left != null && root.right != null){
                // System.out.println(root.data);
                
                sibling(root.left, ans);
                sibling(root.right, ans);
                
            }else if(root.right != null){
                ans.add(root.right.data);
                sibling(root.right, ans);

            }else if(root.left != null){
                ans.add(root.left.data);
                sibling(root.left, ans);
            }



        }

        public Node removeLeaves(Node root) {
            if(root == null) return null;
            if(root.left == null && root.right == null) return null;
            root.left = removeLeaves(root.left);
            root.right= removeLeaves(root.right);

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

	

        public void levelOrder() {
            Queue<Node> q = new LinkedList<>();
            if(this.root == null) return;
            Node curr = this.root;
            q.add(curr);
            ArrayList<Integer> ans = new ArrayList<>();

            while(!q.isEmpty()){
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Node rem = q.remove();
                    
                    ans.add(rem.data);

                    
                        

                    
                    if(rem.left != null){
                        q.add(rem.left);
                    }
                    if(rem.right != null){
                        q.add(rem.right);
                    }
                }
                // for (int i = 0; i < ans.size(); i++) {
                //     System.out.print(ans.get(i) + " ");   
                // }
                // System.out.println();

                res.add(ans);

                ans = new ArrayList<>();


            }

            



        }


        public Node findLCA(Node root, int p, int q) {
            if(root == null || root.data == p || root.data == q) return root;
            Node left = findLCA(root.left, p, q);
            Node right = findLCA(root.right, p, q);
            if(left != null && right != null) return root;
            if(left == null) return right;



            return left;
        }

        public void findSum(Node root, int sum, ArrayList<Integer> ans) {
            if(root == null) return;
            ans.add(root.data);
            if(root.data == sum && root.left == null && root.right == null){
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print(ans.get(i) + " ");
                }
                System.out.println();
                return;
            }

            findSum(root.left, sum - root.data, ans);
            findSum(root.right, sum - root.data, ans);
            ans.remove(ans.size() - 1);
            


            


        }

        public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

		public void levelOrderZZ() {
			
			// write your code here
            Queue<Node> q = new LinkedList<>();
            if(this.root == null) return;
            Node curr = this.root;
            q.add(curr);
            ArrayList<Integer> ans = new ArrayList<>();
            boolean odd = false;
            while(!q.isEmpty()){
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Node rem = q.remove();
                    if(odd){
                        ans.add(0,rem.data);

                    }else{
                        ans.add(rem.data);

                    }
                    if(rem.left != null){
                        q.add(rem.left);
                    }
                    if(rem.right != null){
                        q.add(rem.right);
                    }
                }
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print(ans.get(i) + " ");   
                }
                ans = new ArrayList<>();

                odd = !odd;
            }

            

            System.out.println();


		}

	}

}
