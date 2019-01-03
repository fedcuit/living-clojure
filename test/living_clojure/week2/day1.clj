(ns living-clojure.week2.day1
  (:require [clojure.test :refer :all]))

(defn fib-seq
  "Fibonacci Sequence"
  []
  (->> (iterate (fn [[nMinus2 nMinus1]] [nMinus1 (+ nMinus1 nMinus2)]) [0 1])
       (map last))
  )

(defn caps
  "Return uppercase letters in a string"
  [s]
  (->> s
       (filter #(Character/isUpperCase %))
       (apply str))
  )

(defn factorial
  "Returns factorial of n"
  [n]
  (loop [input n result 1]
    (if (= 1 input)
      result
      (recur (dec input) (* result input))))
  )

(deftest day1
  (testing "Fibonacci Sequence"
    (is (= (take 3 (fib-seq)) '(1 1 2)))
    (is (= (take 6 (fib-seq)) '(1 1 2 3 5 8)))
    (is (= (take 8 (fib-seq)) '(1 1 2 3 5 8 13 21))))

  (testing "Get the Caps"
    (is (= (caps "HeLlO, WoRlD!") "HLOWRD"))
    (is (empty? (caps "nothing")))
    (is (= (caps "$#A(*&98yZf")) "AZ"))

  (testing "Factorial Fun"
    (is (= (factorial 1) 1))
    (is (= (factorial 3) 6))
    (is (= (factorial 5) 120))
    (is (= (factorial 8) 40320)))

  (testing "Intro to Destructuring"
    (is (= [2 4] (let [[_ _ c _ e] [0 1 2 3 4]] [c e]))))
  )
