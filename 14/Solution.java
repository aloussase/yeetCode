import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        return Arrays.stream(strs).reduce(strs[0], (acc, s) -> {
            if (s2.startsWith(s1)) return s1;
            return IntStream.range(0, s1.length() < s2.length() ? s1.length() : s2.length())
                .takeWhile(i -> s1.charAt(i) == s2.charAt(i))
                .mapToObj(i -> String.valueOf(s1.charAt(i)))
                .collect(Collectors.joining())
                .toString();
        });
    }
}
