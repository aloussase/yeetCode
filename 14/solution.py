from functools import reduce
from itertools import takewhile

class Solution:
    def longestCommonPrefix(self, strs):
        return reduce(
            lambda s1, s2: ''.join(c for (c, k) in takewhile(
                lambda pair: pair[0] == pair[1], zip(s1, s2))),
            strs, strs[0]
        )
