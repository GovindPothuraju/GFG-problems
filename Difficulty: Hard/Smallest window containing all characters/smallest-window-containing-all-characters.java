class Solution {
    public static String minWindow(String s, String p) {
        // code here
        
        int n1=s.length();
        int n2=p.length();
        
        HashMap<Character,Integer> hm2=new HashMap<>();
        for(int i=0;i<n2;i++){
            hm2.put(p.charAt(i),hm2.getOrDefault(p.charAt(i),0)+1);
        }
        
        HashMap<Character,Integer> hm1=new HashMap<>();
        
        int st=-1;
        int minl=Integer.MAX_VALUE;
        
        int l=0;
        int count=0;
        
        for(int r=0;r<n1;r++){
            char ch=s.charAt(r);
            if(hm2.containsKey(ch)){
                hm1.put(ch,hm1.getOrDefault(ch,0)+1);
                if(hm1.get(ch)<=hm2.get(ch))count++;
            }
            while(count==n2){
               if(r-l+1 < minl){
                   minl=r-l+1;
                   st=l;
               }
               if(hm2.containsKey(s.charAt(l))){
                   
                    hm1.put(s.charAt(l),hm1.get(s.charAt(l))-1);
                    if(hm1.get(s.charAt(l)) < hm2.get(s.charAt(l))){
                        count--;
                    }
                    if(hm1.get(s.charAt(l))==0){
                        hm1.remove(s.charAt(l));
                    }
               }
               l++;
            }
        }
        if(st==-1)return "";
        return s.substring(st,st+minl);
    }
}