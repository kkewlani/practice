import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TopSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        int[] result = new int[4];
        HashMap<Integer, Vertice> verticeMap = new HashMap();

        for(int[] edge : edges) {
            int u = edge[0]; // parent
            int v = edge[1]; // child
            Vertice uVertice = verticeMap.getOrDefault(u, new Vertice(u));
            Vertice vVertice = verticeMap.getOrDefault(v, new Vertice(v));
            uVertice.children.add(vVertice);
            vVertice.parentCount +=1;
            verticeMap.put(u, uVertice);
            verticeMap.put(v, vVertice);
        }
        //int[] order = new int[vertices];
        int offset=processVertices(verticeMap.values(), result, 0);
        if(offset==result.length) {
            return null;
        }
        //ArrayList<Vertice> childre
        for (int toProcess=0; toProcess < vertices; toProcess++) {
            int n = result[toProcess];
            Vertice vertice = verticeMap.get(n);
            for(Vertice v : vertice.children) {
                v.parentCount--;
            }
            offset = processVertices(vertice.children, result, offset);
            if(toProcess>offset) {
                return null;
            }
        }

        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    private static int processVertices(Collection<Vertice> vertices, int[] result, int offset) {
        for(Vertice vertice: vertices) {
            if(vertice.parentCount==0) {
                result[offset]= vertice.verticeNumber;
                offset++;
            }
        }
        return offset;
    }


    static class Vertice {
        int parentCount;
        int verticeNumber;
        ArrayList<Vertice> children;
        public Vertice(int v) {
            this.verticeNumber = v;
            this.parentCount = 0;
            this.children = new ArrayList();
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,0}};
        sort(3,edges).forEach(System.out::println);
        //Arrays.stream(sort(4, edges)).forEach(System.out::println);
    }
}
