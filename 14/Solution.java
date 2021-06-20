import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import static java.lang.System.out;

class Solution {
    public static String longestCommonPrefix(String[] strs) {
        return Arrays.stream(strs).reduce(strs[0], (acc, s) -> {
            if (acc.startsWith(s)) return s;
            return IntStream.range(0, acc.length() < s.length() ? acc.length() : s.length())
                .takeWhile(i -> acc.charAt(i) == s.charAt(i))
                .mapToObj(i -> String.valueOf(acc.charAt(i)))
                .collect(Collectors.joining())
                .toString();
        });
    }

    public static void main(String[] args) {
        out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        out.println(longestCommonPrefix(new String[]{"Dog", "racecar", "car"}));
        out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }
}
