module Solution
  extend self

  def longest_common_prefix(strs : Array(String)): String
    strs.each.reduce do |acc, s|
      acc.each_char.zip(s.each_char)
        .take_while {|(c, k)| c == k}
        .map {|(c, k)| c}
        .join
    end
  end

  puts longest_common_prefix ["flower", "flow", "flight"]
  puts longest_common_prefix ["dog", "racecar", "car"]
  puts longest_common_prefix ["ab", "a"]
end
