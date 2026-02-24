class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        // code here
        int n=a1.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);
        int sum1=0,sum2=0;
        int max=0;
        for(int i=0;i<n;i++){
            sum1+=a1[i];
            sum2+=a2[i];
            
            int diff=sum1-sum2;
            
            if(hm.containsKey(diff)){
                max=Math.max(max,i-hm.get(diff));
            }else{
                hm.put(diff,i);
            }
        }
        return max;
    }
}