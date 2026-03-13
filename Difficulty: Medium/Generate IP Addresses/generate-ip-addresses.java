
class Solution {

    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> generateIp(String s) {
        backtrack(new StringBuilder(), 0, s, 0);
        return res;
    }

    private void backtrack(StringBuilder sb, int st, String s, int count) {

        // If 4 segments formed
        if (count == 4) {
            if (st == s.length()) {
                res.add(sb.toString());
            }
            return;
        }

        int len = sb.length();

        for (int i = st; i < Math.min(st + 3, s.length()); i++) {

            String part = s.substring(st, i + 1);

            // Leading zero check
            if (part.length() > 1 && part.charAt(0) == '0')
                break;

            int num = Integer.parseInt(part);

            if (num > 255)
                break;

            if (sb.length() != 0)
                sb.append(".");

            sb.append(part);

            backtrack(sb, i + 1, s, count + 1);

            sb.setLength(len); // backtrack
        }
    }
}