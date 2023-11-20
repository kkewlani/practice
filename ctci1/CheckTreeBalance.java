public class CheckTreeBalance {
    static class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }


    public boolean isBalanced(Node root) {
        if(root == null) {
            return false;
        }
        int level=1;
        return Math.abs(height(root.left, level+1) - height(root.right, level+1))<2;
    }

    private int height(Node node, int level) {
        if(node==null) {
            return level;
        }
        return Math.max(height(node.left, level+1), height(node.right,level+1));
    }

    public static void main(String[] args) {
        CheckTreeBalance checkBalance = new CheckTreeBalance();
        CheckTreeBalance.Node root = new CheckTreeBalance.Node(10);
        root.right = new CheckTreeBalance.Node(12);
        root.left = new CheckTreeBalance.Node(8);
        root.left.right = new CheckTreeBalance.Node(10);
        root.left.left = new CheckTreeBalance.Node(7);
        root.left.right.left = new CheckTreeBalance.Node(11);

        System.out.println(checkBalance.isBalanced(new CheckTreeBalance.Node(10)));
    }
}
