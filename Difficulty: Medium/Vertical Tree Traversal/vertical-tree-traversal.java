/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> tm=new TreeMap<>();
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // code here
        traversal(root,0,0);
        
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        for(int key:tm.keySet()){
            TreeMap<Integer,ArrayList<Integer>> temp=tm.get(key);
            ArrayList<Integer> arr=new ArrayList<>();
            for(int innerKey : temp.keySet()){
                for(int val:temp.get(innerKey)){
                    arr.add(val);
                }
            }
            res.add(arr);
        }
        return res;
    }
    private void traversal(Node root,int col,int row){
        
        if(!tm.containsKey(col)){
            tm.put(col,new TreeMap<>());
        }
        
        if(!tm.get(col).containsKey(row)){
            tm.get(col).put(row,new ArrayList<>());
        }
        tm.get(col).get(row).add(root.data);
        
        
        if(root.left != null) traversal(root.left,col-1,row+1);
        if(root.right!= null) traversal(root.right,col+1,row+1);
    }
}









