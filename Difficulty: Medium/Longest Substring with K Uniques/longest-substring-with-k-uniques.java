class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> hm=new HashMap<>();
        int res=-1;
        int l=0;
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.size()>k){
                hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
                if(hm.get(s.charAt(l)) == 0){
                    hm.remove(s.charAt(l));
                }
                l++;
            }
            if(hm.size()==k){
                res=Math.max(res,r-l+1);
            }
        }
        return res;
    }
}