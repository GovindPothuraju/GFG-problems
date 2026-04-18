class Solution {
    int maxOnes(int[] arr) {
        // code here
        int totalOnes = 0;
        int n=arr.length;
        // Count original 1s
        for(int i = 0; i < n; i++) {
            if(arr[i] == 1) totalOnes++;
        }
        
        // Apply Kadane
        int maxGain = 0;
        int currentGain = 0;
        
        for(int i = 0; i < n; i++) {
            int val = (arr[i] == 0) ? 1 : -1;
            
            currentGain = Math.max(val, currentGain + val);
            maxGain = Math.max(maxGain, currentGain);
        }
        
        return totalOnes + maxGain;
    }
};