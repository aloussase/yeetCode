#include <algorithm>
#include <numeric>
#include <string>
#include <vector>
#include <iostream>

template<typename Char>
int
indexOf(std::string& str, Char c) 
{
    int index;
    const char *it = str.c_str();

    for (index = 0; index < str.size(); index++, it++) {
        if (it == &*c) {
            return index;
        }
    }

    return index;
}

std::string
longestCommonPrefix(const std::vector<std::string>& strs)
{
    return std::accumulate(strs.cbegin(), strs.cend(), strs[0], [](auto& acc, auto& str){
        auto [a, b] = std::mismatch(acc.begin(), acc.end(), str.begin());
        return a == acc.end() ? acc : acc.substr(0, indexOf(acc, a));
    });
}

int
main(int argc, char **argv)
{
    std::cout << longestCommonPrefix({"flow", "flower", "flight"}) << "\n";
    std::cout << longestCommonPrefix({"dog", "racecar", "car"}) << "\n";
    std::cout << longestCommonPrefix({"ab", "a"}) << "\n";

    return 0;
}
