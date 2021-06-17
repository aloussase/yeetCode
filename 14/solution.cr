require "spec"

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
end

describe Solution do
  describe "#longest_common_prefix" do
    it "[\"flower\",\"flow\",\"flight\"]" do
      (Solution.longest_common_prefix ["flower","flow","flight"]).should eq "fl"
    end

    it "[\"dog\",\"racecar\",\"car\"]" do
      (Solution.longest_common_prefix ["dog","racecar","car"]).should eq ""
    end

    it "[\"ab\", \"a\"]" do
      (Solution.longest_common_prefix ["ab", "a"]).should eq "a"
    end
  end
end
