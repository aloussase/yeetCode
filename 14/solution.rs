impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        let init = (&strs[0]).clone();
        strs.into_iter().fold(init, |acc, s| {
            acc.chars().zip(s.chars())
                .take_while(|(c, k)| c == k)
                .map(|(c, _)| c)
                .collect()
        }) 
    }
}
