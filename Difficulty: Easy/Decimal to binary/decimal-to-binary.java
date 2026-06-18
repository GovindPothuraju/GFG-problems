class Solution {
    static String decToBinary(int n) {
        // code here
        StringBuilder sb = new StringBuilder();
        int k=0;
        int sum=0;
        while(n>0){
            int rem = n%2;
            sb.append((char)(rem+'0'));
            n/=2;
        }
        return sb.reverse().toString();
    }
}