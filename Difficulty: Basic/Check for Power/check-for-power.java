class Solution {
    public static boolean isPower(int x, int y) {
        // Edge case
        if (y == 1) return true;
        if (x == 1) return y == 1;

        // Divide y by x repeatedly
        while (y % x == 0) {
            y = y / x;
        }

        return y == 1;
    }

    public static void main(String[] args) {
        int x = 2, y = 8;
        System.out.println(isPower(x, y)); // true
    }
}