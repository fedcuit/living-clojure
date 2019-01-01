(ns living-clojure.week1.day3
  (:require [clojure.test :refer :all]))

(deftest day3
  (testing "Regular Expressions"
    (is (= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))))

  (testing "Simple Recursion"
    (is (= '(5 4 3 2 1) ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))))

  (testing "Recurring theme"
    (is (= [7 6 5 4 3]
           (loop [x 5 result []]
             (if (> x 0)
               (recur (dec x) (conj result (+ 2 x)))
               result
               )))))

  (testing "Rearranging Code: -> (insert x to form as second item)"
    (is (= '(1 2 3 4 5) (sort (rest (reverse [2 5 4 1 3 6])))))
    (is (= '(1 2 3 4 5) (-> [2 5 4 1 3 6] reverse rest sort)))
    (is (= ":CAT" (-> [:cat :dog :fish]
                      first
                      str
                      .toUpperCase))))

  (testing "Rearranging Code: ->> (insert x to form as last item)"
    (is (= '(5 2 4) (map inc (take 3 (drop 2 [2 5 4 1 3 6])))))
    (is (= 11 (->> [2 5 4 1 3 6]
                   (drop 2)
                   (take 3)
                   (map inc)
                   (reduce +)))))

  (testing "For the win (generate a lazy sequence)"
    (is (= '(1 5 9 13 17 21 25 29 33 37)
           (for [x (range 40)
                 :when (= 1 (rem x 4))]
             x)))
    (is (= (->> (range 1 40)
                (filter #(< % 40))
                (filter #(= 1 (rem % 4)))
                (take 10))
           (take 10 (for [x (iterate #(+ 4 %) 0)
                          :let [z (inc x)]
                          :when (< z 40)]
                      z))))
    (is (= (->> (range 20)
                (partition 2)
                (map (fn [[x y]] (+ x y)))
                (take 10))
           (take 10 (for [[x y] (partition 2 (range 20))] (+ x y))))))
  )
