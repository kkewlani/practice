import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepths {
    class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public List<LinkedList<Node>> getListOfDepths(Node root) {
        List<LinkedList<Node>> outerLists = new LinkedList<>();
        if(root==null) {
            return outerLists;
        }

        LinkedList<Node> currList = new LinkedList<>();
        currList.add(root);
        outerLists.add(currList);
        LinkedList<Node> nextList = getNextList(currList);
        while(!nextList.isEmpty()) {
            outerLists.add(nextList);
            nextList = getNextList(nextList);
        }
        return outerLists;

    }

    private LinkedList<Node> getNextList(LinkedList<Node> currList) {
        Iterator<Node> inner = currList.iterator();
        LinkedList<Node> nextList = new LinkedList<>();
        while(inner.hasNext()) {
            Node curr = inner.next();
            if(curr.left!=null) {
                nextList.add(curr.left);
            }
            if(curr.right!=null) {
                nextList.add(curr.right);
            }
            nextList = new LinkedList<>();
        }
        return nextList;
    }

    public ArrayList<LinkedList<Node>> simplerSolution(Node node) {
        ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();

        if(node==null) {
            return result;
        }

        LinkedList<Node> current = new LinkedList<>();
        current.add(node);
        while(current.size()>0) {
            result.add(current);
            LinkedList<Node> parents = current;
            current = new LinkedList<>();
            for(Node parent:parents) {
                if(parent.left!=null) {
                    current.add(parent.left);
                }
                if(parent.right!=null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }
}
