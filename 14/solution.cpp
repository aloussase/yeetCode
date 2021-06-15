#include <algorithm>
#include <numeric>
#include <string>
#include <vector>

class Solution {
public:
    template<typename Char>
    int indexOf(std::string& str, Char c) {
        int index;
        const char *it = str.c_str();

        for (index = 0; index < str.size(); index++, it++) {
            if (it == &*c) {
                return index;
            }
        }

        return index;
    }

    std::string longestCommonPrefix(std::vector<std::string>& strs) {
        return std::accumulate(strs.begin(), strs.end(), strs[0], [this](auto& acc, auto& str){
            auto [a, b] = std::mismatch(acc.begin(), acc.end(), str.begin());
            return a == acc.end() ? acc : acc.substr(0, indexOf(acc, a));
        });
    }
};
