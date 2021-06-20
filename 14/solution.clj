(defn common-prefix
  [s1 s2]
  (->> (map vector s1 s2)
       (take-while (partial apply =))
       (map first)
       (apply str)))

(defn solution
  [strs]
  (reduce common-prefix strs))

(println (solution ["ab" "a"])
         (solution ["flow" "flower" "flight"])
         (solution ["dog" "racecar" "car"]))
