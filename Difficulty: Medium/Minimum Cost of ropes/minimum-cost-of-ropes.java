class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : arr) {
            q.offer(num);
        }
        int res=0;
        while (!q.isEmpty()) {
            int x=q.poll();
            if(q.isEmpty()){
                return res;
            }
            int y=q.poll();
            res+=(x+y);
            q.offer(x+y);
        }
        return res;
    }
}