public class LowestCommonAncestor {
    class Node {
        Node left;
        Node right;
        Node parent;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
    private static boolean pFound;
    private static boolean qFound;

    public static Node lca(Node root, Node p , Node q) {
        if(p==q && p!=null) {
            if(exists(root, p)) {
                return p;
            } else {
                return null;
            }
        } else {
            Node node = lcaHelper(root, p, q);
            return pFound && qFound ? node : null;
        }
    }

    private static boolean exists(Node root, Node p) {
        if(root==null) {
            return false;
        }
        if(root == p) {
            return true;
        }
        return exists(root.left, p) || exists(root.right, p);
    }


    private static Node lcaHelper(Node root, Node p , Node q) {
        if(root==null) {
            return root;
        }
        Node left = lcaHelper(root.left, p, q);
        Node right = lcaHelper(root.right, p, q);

        if (root==p) {
            pFound=true;
            return root;
        }
        if (root==q) {
            qFound=true;
            return root;
        }
        if(left==null) {
            return right;
        } else if(right==null) {
            return left;
        } else {
            return root; // LCA
        }
    }

    public static void main(String[] args) {

    }
}
