class Solution {
    boolean canFormPalindrome(String s) {
        // code here
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int count=0;
        for(int val:hm.values()){
            if(val%2 != 0){
                count++;
            }
        }
        return count<=1;
    }
}