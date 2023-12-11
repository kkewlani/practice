import model.TNode;

import java.util.Hashtable;

/**
 * Count all possible paths in a tree that yield the sum provided as input
 */
public class TreePathSum {

    int getPathCount(TNode root, int targetSum) {
        //return countSumPath(root, targetSum, 0);
        return countSumPathV2(root, targetSum, 0, new Hashtable<>());
    }
    int countSumPath(TNode root, int targetSum, int currentSum) {
        if(root == null) {
            return 0;
        }

        int pathCount = 0;
        currentSum += root.data;
        if(currentSum == targetSum) {
            pathCount++;
        }
        // get paths from child (excluding current node)
        pathCount += countSumPath(root.left, targetSum, 0);
        pathCount += countSumPath(root.right, targetSum, 0);

        // get paths including current node
        pathCount += countSumPath(root.left, targetSum, currentSum);
        pathCount += countSumPath(root.right, targetSum, currentSum);
        return pathCount;
    }

    int countSumPathV2(TNode node, int targetSum, int runningSum, Hashtable<Integer, Integer> pathCountTable) {
        if(node == null) {
            return 0;
        }

        int pathCount = 0;
        runningSum += node.data;
        int sumDiff = runningSum - targetSum;

        pathCount += pathCountTable.getOrDefault(sumDiff, 0);

        if(runningSum == targetSum) {
            pathCount++;
        }

        pathCountTable.put(runningSum, pathCountTable.getOrDefault(runningSum, 0) + 1);
        pathCount += countSumPathV2(node.left, targetSum, runningSum, pathCountTable);
        pathCount += countSumPathV2(node.right, targetSum, runningSum, pathCountTable);
        pathCountTable.put(runningSum, pathCountTable.get(runningSum) - 1);
        return pathCount;
    }

    public static void main(String[] args) {
        TNode root = new TNode(10);
        root.left = new TNode(5);
        root.left.right = new TNode(2);
        root.left.right.right = new TNode(1);
        root.left.left = new TNode(3);
        root.left.left.left = new TNode(3);
        root.left.left.right = new TNode(-2);
        root.right = new TNode(-3);
        root.right.right = new TNode(11);
        TreePathSum t = new TreePathSum();

        System.out.println(t.getPathCount(root, 7));
    }



}
