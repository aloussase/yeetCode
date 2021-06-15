from functools import reduce

class Solution:
    def common_prefix(self, string1, string2):
        for (i, (c, k)) in enumerate(zip_longest(string1, string2)):
            if c != k:
                return string1[:i]
        return string1
                
    
    def longestCommonPrefix(self, strs: List[str]) -> str:
        return reduce(self.common_prefix, strs, strs[0])