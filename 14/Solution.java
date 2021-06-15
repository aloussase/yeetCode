import java.util.Arrays;

class Solution {
    public int mismatch(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int shortest = lenA < lenB ? lenA : lenB;

        int i;
        for (i = 0; i < shortest; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return i;
            }
        }

        return i;
    }

    public String longestCommonPrefix(String[] strs) {
        return Arrays.stream(strs)
                .reduce(strs[0], (acc, s) -> s.substring(0, mismatch(acc, s)));
    }
}
