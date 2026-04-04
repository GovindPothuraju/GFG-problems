class Solution {
    ArrayList<String> res=new ArrayList<>();
    String bit="01";
    public ArrayList<String> graycode(int n) {
        // code here
        StringBuilder sb=new StringBuilder();
        backtrack(sb,n,true);
        return res;
    }
    private void backtrack(StringBuilder sb,int n,boolean forward){
        if(sb.length()==n){
            res.add(sb.toString());
            return;
        }
        if(forward){
            for(int i=0;i<2;i++){
                sb.append(bit.charAt(i));
                backtrack(sb,n,bit.charAt(i) == '0');
                sb.deleteCharAt(sb.length()-1);
            }
        }else{
            for(int i=1;i>=0;i--){
                sb.append(bit.charAt(i));
                backtrack(sb,n,bit.charAt(i) != '0');
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}