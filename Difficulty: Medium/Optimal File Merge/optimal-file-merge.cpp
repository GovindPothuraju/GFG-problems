// User function Template for C++

#include <queue>
#include <vector>
using namespace std;

class Solution
{
public:
    // Function to find minimum computation
    int minComputation(vector<int> files)
    {
        // Min heap
        priority_queue<int, vector<int>, greater<int>> pq;

        // Insert all file sizes
        for (int i = 0; i < files.size(); i++) {
            pq.push(files[i]);
        }

        int res = 0;

        while (pq.size() > 1) {
            int v1 = pq.top();
            pq.pop();

            int v2 = pq.top();
            pq.pop();

            int temp = v1 + v2;
            res += temp;

            pq.push(temp);
        }

        return res;
    }
};