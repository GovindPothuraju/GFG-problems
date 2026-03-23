class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        List<int[]> events=new ArrayList<>();
        
        for(int i=0;i<start.length;i++){
            events.add(new int[]{start[i],1});
            events.add(new int[]{end[i],-1});
        }
        
        Collections.sort(events,(a,b)->{
            if(a[0]==b[0])return a[1]-b[1];
            return a[0]-b[0];
        });
        
        int count=0;
        int max=0;
        for(int[] e:events){
            count+=e[1];
            max=Math.max(max,count);
        }
        return max;
    }
}
