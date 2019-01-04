(ns living-clojure.week2.day4
  (:require [clojure.test :refer :all]))

(defn symDiff
  "Symmetric Difference"
  [s1 s2]
  (into #{} (concat
              (filter #(not (contains? s2 %)) s1)
              (filter #(not (contains? s1 %)) s2)
              ))
  )

(defn lcm
  "Least Common Multiple"
  [& nums]
  (let [sorted (sort nums)]
    (->> sorted
         first
         (iterate #(+ % (first sorted)))
         (filter (fn [n] (every? #(= "0" (str (rem n %))) nums)))
         first
         ))
  )

(deftest day4
  (testing "Symmetric Difference"
    (is (= (symDiff #{:a :b :c} #{}) #{:a :b :c}))
    (is (= (symDiff #{} #{4 5 6}) #{4 5 6}))
    (is (= (symDiff #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]}))
    (is (= (symDiff #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})))

  (testing "Least Common Multiple"
    (is (== (lcm 2 3) 6))
    (is (== (lcm 5 3 7) 105))
    (is (== (lcm 1/3 2/5) 2))
    (is (== (lcm 3/4 1/6) 3/2))
    (is (== (lcm 7 5/7 2 3/5) 210))
    )
  )