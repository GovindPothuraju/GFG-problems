class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        // code here
        ArrayList<ArrayList<Integer>> temp=new ArrayList<>();
        
        int n=mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int index=i+j;
                while(temp.size()<=index){
                    temp.add(new ArrayList<>());
                }
                temp.get(index).add(mat[i][j]);
            }
        }
        
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<temp.size();i++){
            ArrayList<Integer> arr=temp.get(i);
            for(int num:arr){
                res.add(num);
            }
        }
        return res;
    }
}
