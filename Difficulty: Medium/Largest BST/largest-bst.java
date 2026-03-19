class Solution {

    static class BSTNode {
        int size;
        int min;
        int max;

        BSTNode(int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int maxSize = 0;

    static int largestBst(Node root) {
        maxSize = 0;
        traversal(root);
        return maxSize;
    }

    static BSTNode traversal(Node curr) {
        if (curr == null) {
            return new BSTNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        BSTNode left = traversal(curr.left);
        BSTNode right = traversal(curr.right);

        // Check BST condition
        if (left.max < curr.data && curr.data < right.min) {

            int size = 1 + left.size + right.size;
            maxSize = Math.max(maxSize, size);

            int min = Math.min(left.min, curr.data);
            int max = Math.max(right.max, curr.data);

            return new BSTNode(size, min, max);
        }

        // Not a BST
        return new BSTNode(Math.max(left.size, right.size),
                           Integer.MIN_VALUE,
                           Integer.MAX_VALUE);
    }
}