class Solution {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;

        // Step 1: Check all 9's
        boolean all9 = true;
        for (int x : num) {
            if (x != 9) {
                all9 = false;
                break;
            }
        }

        if (all9) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res;
        }

        // Step 2: Copy left to right
        int[] res = num.clone();
        for (int i = 0; i < n / 2; i++) {
            res[n - 1 - i] = res[i];
        }

        // Step 3: Check if already greater
        boolean greater = false;
        for (int i = 0; i < n; i++) {
            if (res[i] > num[i]) {
                greater = true;
                break;
            } else if (res[i] < num[i]) {
                break;
            }
        }

        if (greater) return res;

        // Step 4: Increment middle
        int carry = 1;
        int mid = n / 2;

        if (n % 2 == 1) {
            res[mid] += carry;
            carry = res[mid] / 10;
            res[mid] %= 10;
            int i = mid - 1;
            int j = mid + 1;

            while (i >= 0) {
                res[i] += carry;
                carry = res[i] / 10;
                res[i] %= 10;
                res[j] = res[i];
                i--;
                j++;
            }
        } else {
            int i = mid - 1;
            int j = mid;

            while (i >= 0) {
                res[i] += carry;
                carry = res[i] / 10;
                res[i] %= 10;
                res[j] = res[i];
                i--;
                j++;
            }
        }

        return res;
    }
}