(ns living-clojure.week3.day4
  (:require [clojure.test :refer :all]))

(defn prime?
  [n]
  (->> (range 2 n)
       (not-any? #(= 0 (rem n %)))
       )
  )

(defn nth-prime-num
  [n]
  (->> (iterate #(+ 1 %) 2)
       (filter prime?)
       (take n)
       )
  )

(deftest day4
  (testing "Prime Numbers"
    (is (= (nth-prime-num 2) [2 3]))
    (is (= (nth-prime-num 5) [2 3 5 7 11]))
    (is (= (last (nth-prime-num 100)) 541))
    ))