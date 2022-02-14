package maxPath;

import java.util.Optional;

public class MaxPathSum {

    public void calculateMaxPathSum(Node root) {
        if(root==null) {
            return;
        }

        MaxSum maxSum = new MaxSum();
        maxSum.sum = Integer.MIN_VALUE;
        System.out.println("startValue:"+ maxSum.sum);
        calculateNodeMaxSum(root, maxSum);
        System.out.println("MaxPathSum:"+maxSum.sum);

    }

    public int calculateNodeMaxSum(Node current, MaxSum maxSum) {
        if(current == null) {
            return Integer.MIN_VALUE;
        }

        long maxLeftSum = calculateNodeMaxSum(current.left, maxSum);
        long maxRightSum = calculateNodeMaxSum(current.right, maxSum);
        long self = current.value;

        maxSum.sum = Math.max(Math.max(Math.max(Math.max(Math.max( Math.max(maxLeftSum, maxRightSum), maxLeftSum+maxRightSum+self), maxLeftSum+self), maxRightSum+self), maxSum.sum),self);

        System.out.println("maxLeftSum:"+maxLeftSum+",self:"+self+",maxRightSum:"+maxRightSum+",maxSum:"+maxSum.sum);
        return (int) Math.max(Math.max(maxLeftSum , maxRightSum) + self, self);

    }

    public static void main(String[] args) {
        Node root = new Node(-2);
        //root.left =

        Node n1 = new Node(4);
        Node n2 = new Node(-3);
        Node n3 = new Node(-1);
        Node n4 = new Node(4);
        Node n5 = new Node(8);
        Node n6 = new Node(9);
        Node n7 = new Node(-7);
        Node n8 = new Node(5);
        Node n9 = new Node(6);

        n2.left = n1;
        n4.left = n3;
        n4.right = n2;
        n6.left = n5;
        n7.right = n6;
        n9.left = n8;
        n9.right = n7;
        root.left = n1;
        root.right = n9;

        MaxPathSum maxPathSum = new MaxPathSum();
        maxPathSum.calculateMaxPathSum(root);

    }

}

class MaxSum {
    long sum;
}


class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.value = value;
    }
}

/*
Sample  output:

 */
