import java.util.Random;

/**
 * Create  BST from scratch that have a method to getRandomNode in addition to find, insert and delete
 */
public class RandomNode {

    public class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;
        int size;

        public TreeNode(int data) {
            this.data = data;
            this.size = 1;
        }

        int getData() {
            return this.data;
        }

        int getSize() {
            return this.size;
        }

        TreeNode getRandomNode() {
            int leftSize = left==null ? 0 : this.left.size;
            Random random = new Random();
            int index = random.nextInt(this.size);
            if(index < leftSize) {
                return left.getRandomNode();
            } else if(index == leftSize) {
                return this;
            } else {
                return right.getRandomNode();
            }
        }

        TreeNode getRandomNodeV2() {
            Random random = new Random();
            int index = random.nextInt(this.size);
            return getIthNode(index);
        }

        private TreeNode getIthNode(int i) {
            int leftSize = left==null ? 0 : this.left.size;
            if(i < leftSize) {
                return left.getIthNode(i);
            } else if (i==leftSize) {
                return this;
            } else {
                return right.getIthNode(i - leftSize + 1);
            }
        }

        void insert(int val) {
            if(val <= data) {
                if(left == null) {
                    left = new TreeNode(val);
                } else {
                    left.insert(val);
                }
            } else {
                if(right == null) {
                    right = new TreeNode(val);
                } else {
                    right.insert(val);
                }
            }
            size++;
        }

        TreeNode find(int val) {
            if(val == data) {
                return this;
            } else if(val < data) {
                return left==null ? null : left.find(val);
            } else {
                return right==null ? null : right.find(val);
            }
        }
    }


}
