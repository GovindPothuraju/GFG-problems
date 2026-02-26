class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        // code here
        HashMap<Character,Character> hm1=new HashMap<>();
        HashMap<Character,Character> hm2=new HashMap<>();
        
        for(int i=0;i<s1.length();i++){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            
            if(!hm1.containsKey(ch1)){
                hm1.put(ch1,ch2);
            }
            if(!hm2.containsKey(ch2)){
                hm2.put(ch2,ch1);
            }
            
            if((hm1.containsKey(ch1) && hm1.get(ch1)!=ch2) ||
               (hm2.containsKey(ch2) && hm2.get(ch2)!=ch1)){
                   return false;
               }
        }
        return true;
    }
}