import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class RouteBetweenNodes {

    class Node {
        Node[] adjacentNodes;
        boolean marked;
    }

    class Graph {
        Node[] nodes;
    }

    public static boolean routeExists(Graph graph, Node n1, Node n2) {
        if(n1==null || n2==null) {
            return false;
        }
        Queue<Node> q = new LinkedBlockingQueue<>();
        n1.marked=true;
        q.add(n1);
        if(n1==n2) {
            return true;
        }
        Node cur;
        while(!q.isEmpty()) {
            cur=q.poll();
            for(Node n : cur.adjacentNodes) {
                if(n==n2) {
                  return true;
                } else if(!n.marked) {
                    q.add(n);
                }
            }
        }
        return false;
    }
}
