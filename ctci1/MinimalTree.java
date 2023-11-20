public class MinimalTree {

    class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    /** Build BST
     *
     * @param arr
     * @return
     */
    public  Node buildMinimalTree(int[] arr) {
        return buildMinimalTreeHelper(arr, 0, arr.length-1);
    }

    private Node buildMinimalTreeHelper(int[] arr, int start, int end) {
        Node root = null;
        if(start<=end) {
            int mid =(start+end)/2;
            root = new Node(arr[mid]);
            root.left = buildMinimalTreeHelper(arr, start, mid-1);
            root.right = buildMinimalTreeHelper(arr, mid+1, end);
        }
        return root;
    }

    public static void main(String[] args) {
        MinimalTree mt = new MinimalTree();
        inorderTraversal(mt.buildMinimalTree(new int[]{0,1,2,3,4,5}));


    }

    public static void inorderTraversal(Node root) {
        if(root==null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val);
        inorderTraversal(root.right);
    }

}
