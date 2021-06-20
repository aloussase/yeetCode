from functools import reduce, partial
from itertools import takewhile
from operator import eq

class Pipe:
    def __init__(self, f):
        self.f = f

    def __or__(self, func):
        def f(*args, **kwargs):
            return func(self.f(*args, **kwargs))
        return Pipe(f)

    def __call__(self, *args, **kwargs):
        return self.f(*args, **kwargs)


def longest_common_prefix(strs):
    return reduce(
            Pipe(zip)
            | partial(takewhile, lambda pair: eq(*pair))
            | partial(map, lambda pair: pair[0])
            | partial(str.join, ''),
            strs, strs[0])


# def pipe(init, *fs):
#     return reduce(lambda acc, f: f(acc), fs, init)


# def longest_common_prefix(strs):
#     return reduce(lambda s1, s2: pipe(
#             zip(s1, s2),
#             partial(takewhile, lambda pair: eq(*pair)),
#             partial(map, lambda pair: pair[0]),
#             partial(str.join, '')),
#         strs, strs[0])


# def longest_common_prefix(strs):
#     return reduce(lambda s1, s2: pipe(
#             zip(s1, s2),
#             lambda it: takewhile(lambda pair: eq(*pair), it),
#             lambda it: map(lambda pair: pair[0], it),
#             lambda it: ''.join(it)), 
#         strs, strs[0])


# def longest_common_prefix(strs):
#     return reduce(lambda s1, s2: ''.join(c for (c, k) in 
#             takewhile(lambda pair: pair[0] == pair[1], zip(s1, s2))),
#         strs, strs[0])
    # )


if __name__ == '__main__':
    print(longest_common_prefix(["flow", "flower", "flight"]))
    print(longest_common_prefix(["dog", "racecar", "car"]))
    print(longest_common_prefix(["ab", "a"]))
