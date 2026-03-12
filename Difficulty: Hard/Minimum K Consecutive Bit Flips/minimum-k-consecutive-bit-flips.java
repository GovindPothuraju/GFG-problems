class Solution {
    public int kBitFlips(int[] arr, int k) {
        // code here
        int n = arr.length;
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            while(!q.isEmpty() && q.peek() + k <= i) {
                q.poll();
            }
            int current = arr[i];
            if(q.size() % 2 == 1) {
                if(current == 0) current = 1;
                else current = 0;
            }
            if(current == 0) {
                if(i + k > n)
                    return -1;
                q.add(i);
                res++;
            }
        }

        return res;
    }
}
