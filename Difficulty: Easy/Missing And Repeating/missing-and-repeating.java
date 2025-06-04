// User function Template for Java

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n=arr.length;
        int a=-1,b=-1;
        HashSet<Integer> hs=new HashSet();
        for(int i=0;i<n;i++){
            int key=arr[i];
            if(hs.contains(key)){
                a=key;
            }
            hs.add(key);
        }
        for(int i=1;i<=n;i++){
            if(!hs.contains(i)){
                b=i;
                break;
            }
        }
        return new ArrayList<>(Arrays.asList(a,b));
    }
}
