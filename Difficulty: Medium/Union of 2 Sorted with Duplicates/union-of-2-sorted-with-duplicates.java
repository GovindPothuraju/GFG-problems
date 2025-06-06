// User function Template for Java

// a,b : the arrays
class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
       /* ArrayList<Integer> arr=new ArrayList<>();
        int n1=a.length;
        int n2 =b.length;
        int i=0;
        int j=0;
        while(i<n1&&j<n2){
            if(a[i]==b[j]){
                arr.add(a[i]);
                i++;
                j++;
            }else if(a[i]<b[j]){
                arr.add(a[i]);
                i++;
            }else if(a[i]>b[j]){
                arr.add(b[j]);
                j++;
            }
        }
        while(i<n1-1){
            arr.add(a[i]);
            i++;
        }
        while(j<n2-1){
            arr.add(b[j]);
            j++;
        }
        return arr;*/
        
        int n1=a.length;
        int n2 =b.length;
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<n1;i++){
            hs.add(a[i]);
        }
        for(int i=0;i<n2;i++){
            hs.add(b[i]);
        }
        ArrayList<Integer> arr=new ArrayList<>(hs);
        Collections.sort(arr);
        return arr;
    }
}
