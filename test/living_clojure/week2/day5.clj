(ns living-clojure.week2.day5
  (:require [clojure.test :refer :all]))

(defn calc-row
  "Calculate next row of Pascal's Triangle"
  [row]
  (->> (reduce (fn [acc n] (conj acc [(last (last acc)) n])) [[]] row)
       (drop 2)
       (map (partial reduce +))
       ))

(defn p-triangle
  "Pascal's Triangle"
  []
  (iterate (fn [prev-row] (concat [1] (calc-row prev-row) [1])) [1])
  )

(defn nth-row
  "Returns nth row of Pascal's triangle"
  [n]
  (nth (p-triangle) (dec n))
  )

(deftest day5
  (testing "Pascal's Triangle"
    (is (= (nth-row 1) [1]))
    (is (= (map nth-row (range 1 6)) [
                                      [1]
                                      [1 1]
                                      [1 2 1]
                                      [1 3 3 1]
                                      [1 4 6 4 1]]))
    (is (= (nth-row 11) [1 10 45 120 210 252 210 120 45 10 1])))
  )
