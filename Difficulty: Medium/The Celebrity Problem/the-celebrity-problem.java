class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int n=mat.length;
        int col[]=new int[n];
        int row[]=new int[n];
        int k=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum+=mat[i][j];
            }
            row[k++]=sum;
        }
        k=0;
        for(int j=0;j<n;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=mat[i][j];
            }
            col[k++]=sum;
        }
        for(int i=0;i<n;i++){
            if(row[i]==1 && col[i]==n){
                return i;
            }
        }
        return -1;
    }
}