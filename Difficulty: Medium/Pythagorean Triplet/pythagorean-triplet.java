import java.util.*;

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        
        int n = arr.length;
        
        int max = 0;
        for(int num : arr){
            max = Math.max(max, num);
        }
        
        boolean[] present = new boolean[max + 1];
        
        for(int num : arr){
            present[num] = true;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                
                long sum = (long)arr[i]*arr[i] + (long)arr[j]*arr[j];
                
                long c = (long)Math.sqrt(sum);
                
                if(c <= max && c*c == sum && present[(int)c]){
                    return true;
                }
            }
        }
        
        return false;
    }
}