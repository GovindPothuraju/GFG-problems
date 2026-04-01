class Solution {
    int countStrings(int n) {
        
        if (n == 1) return 2;
        
        int zero = 1; // length 1 ending with 0
        int one = 1;  // length 1 ending with 1
        
        for (int i = 2; i <= n; i++) {
            int newZero = zero + one;
            int newOne = zero;
            
            zero = newZero;
            one = newOne;
        }
        
        return zero + one;
    }
}