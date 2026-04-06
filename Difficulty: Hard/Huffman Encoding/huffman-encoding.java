import java.util.*;

class Solution {
    
    static class Node {
        int freq;
        char ch;
        Node left, right;
        int index; // for tie-breaking
        
        Node(int f, char c, int i) {
            freq = f;
            ch = c;
            index = i;
        }
    }
    
    public ArrayList<String> huffmanCodes(String s, int f[]) {
        
        int n = s.length();
        ArrayList<String> res = new ArrayList<>();
        
        // 🔴 Edge Case 1: Empty input
        if (n == 0) return res;
        
        // 🔴 Edge Case 2: Only one character
        if (n == 1) {
            res.add("0");
            return res;
        }
        
        // Min Heap with proper tie-breaking
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq == b.freq) {
                return a.index - b.index; // earlier index first
            }
            return a.freq - b.freq;
        });
        
        // Create nodes
        for (int i = 0; i < n; i++) {
            pq.add(new Node(f[i], s.charAt(i), i));
        }
        
        // Build Huffman Tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            
            Node parent = new Node(
                left.freq + right.freq,
                '#',
                Math.min(left.index, right.index) // preserve order
            );
            
            parent.left = left;
            parent.right = right;
            
            pq.add(parent);
        }
        
        Node root = pq.poll();
        
        // Generate codes using preorder
        generate(root, "", res);
        
        return res;
    }
    
    private void generate(Node root, String code, ArrayList<String> res) {
        if (root == null) return;
        
        // Leaf node
        if (root.left == null && root.right == null) {
            res.add(code.length() > 0 ? code : "0"); // safety
            return;
        }
        
        generate(root.left, code + "0", res);
        generate(root.right, code + "1", res);
    }
}