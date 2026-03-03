class Solution {
    public int totalElements(int[] arr) {
        // code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        int res=0;
        int l=0;
        for(int r=0;r<arr.length;r++){
            hm.put(arr[r],hm.getOrDefault(arr[r],0)+1);
            while(hm.size()>2){
                hm.put(arr[l],hm.get(arr[l])-1);
                if(hm.get(arr[l])==0){
                    hm.remove(arr[l]);
                }
                l++;
            }
            if(hm.size()<=2){
                res=Math.max(res,r-l+1);
            }
        }
        return res;
    }
}