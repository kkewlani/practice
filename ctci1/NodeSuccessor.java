public class NodeSuccessor {
    class Node {
        Node left;
        Node right;
        Node parent;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node successor(Node node) {
        if(node==null) {
            return null;
        }

        if(node.right!=null) {
            return leftMostChild(node.right);
        } else {
            Node curr = node;
            Node parent = node.parent;

            while(parent!=null && parent.left != curr) {
                curr = parent;
                parent = curr.parent;
            }
            return parent;
        }

    }

    private static Node leftMostChild(Node node) {
        if(node==null) {
            return null;
        }

        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}
