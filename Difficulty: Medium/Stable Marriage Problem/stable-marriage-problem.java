
class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n=men.length;
        int[] partnerOfWoman = new int[n]; // woman -> man
        int[] partnerOfMan = new int[n];   // man -> woman
        int[] nextProposal = new int[n];   // next woman index to propose
        
        // initialize all women as free
        for(int i = 0; i < n; i++) {
            partnerOfWoman[i] = -1;
        }
        
        // create ranking for women
        int[][] rank = new int[n][n];
        for(int w = 0; w < n; w++) {
            for(int i = 0; i < n; i++) {
                rank[w][women[w][i]] = i;
            }
        }
        
        Queue<Integer> freeMen = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            freeMen.add(i);
        }
        
        while(!freeMen.isEmpty()) {
            int man = freeMen.poll();
            
            int woman = men[man][nextProposal[man]];
            nextProposal[man]++;
            
            // if woman is free
            if(partnerOfWoman[woman] == -1) {
                partnerOfWoman[woman] = man;
                partnerOfMan[man] = woman;
            } 
            else {
                int currentMan = partnerOfWoman[woman];
                
                // check preference
                if(rank[woman][man] < rank[woman][currentMan]) {
                    // she prefers new man
                    partnerOfWoman[woman] = man;
                    partnerOfMan[man] = woman;
                    
                    // old man becomes free
                    freeMen.add(currentMan);
                } 
                else {
                    // she rejects new man
                    freeMen.add(man);
                }
            }
        }
        
        return partnerOfMan;
    }
}