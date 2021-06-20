(defn common-prefix
  [s1 s2]
  (->> (map #(vector %1 %2) s1 s2)
       (#(take-while (fn [[c k]] (= c k)) %1))
       (map (fn [[c k]] c))
       (apply str)))

(defn solution
  [strs]
  (reduce common-prefix strs))

(println (solution ["ab" "a"])
         (solution ["flow" "flower" "flight"])
         (solution ["dog" "racecar" "car"]))
