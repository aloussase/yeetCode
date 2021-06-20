pub fn longest_common_prefix(strs: Vec<&str>) -> String {
    strs.iter()
        .map(|s| s.to_string())
        .reduce(|acc, s| {
            acc.chars().zip(s.chars())
                .take_while(|(c, k)| c == k)
                .map(|(c, _)| c)
                .collect()
        })
        .unwrap_or_else(|| String::from(""))
}

fn main() {
    println!("{}", longest_common_prefix(vec!["flower", "flow", "flight"]));
    println!("{}", longest_common_prefix(vec!["dog", "racecar", "car"]));
    println!("{}", longest_common_prefix(vec!["ab", "a"]));
}
