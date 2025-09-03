class Solution {
    public String FirstNonRepeating(String s) {
        // code here
        int[] freq=new int[26];
        StringBuilder sb=new StringBuilder();
        Queue<Character> q=new LinkedList<>();
        
        for(int i=0;i<s.length();i++){
            
            char ch=s.charAt(i);
            freq[ch-'a']++;
            q.offer(ch);
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.poll();
            }
            sb.append(q.isEmpty()?'#':q.peek());
        }
        return sb.toString();
    }
}