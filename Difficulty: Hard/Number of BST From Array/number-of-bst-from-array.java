
class Solution {
    
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        
        // Step 1: Sort array
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        
        // Step 2: Map value -> index
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sorted[i], i);
        }
        
        // Step 3: Precompute Catalan numbers
        long[] cat = new long[n + 1];
        cat[0] = cat[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            cat[i] = 0;
            for (int j = 0; j < i; j++) {
                cat[i] += cat[j] * cat[i - j - 1];
            }
        }
        
        // Step 4: Build result
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int idx = map.get(arr[i]);
            
            int left = idx;
            int right = n - idx - 1;
            
            long ways = cat[left] * cat[right];
            result.add((int) ways);
        }
        
        return result;
    }
}