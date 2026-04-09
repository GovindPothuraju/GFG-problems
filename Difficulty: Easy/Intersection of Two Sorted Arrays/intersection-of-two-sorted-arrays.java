class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        // code here
        HashSet<Integer> hs=new HashSet<>();
        for(int num:a){
            hs.add(num);
        }
        HashSet<Integer> hs2=new HashSet<>();
        ArrayList<Integer> res=new ArrayList<>();
        for(int num:b){
            if(hs.contains(num) && !hs2.contains(num)){
                res.add(num);
                hs2.add(num);
            }
        }
        return res;
    }
}