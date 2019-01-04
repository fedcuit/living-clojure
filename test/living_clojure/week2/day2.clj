(ns living-clojure.week2.day2
  (:require [clojure.test :refer :all]))

(defn half-truth
  [& s]
  (and (boolean (some true? s)) (boolean (some false? s)))
  )

(defn gcd
  "Returns greated common divisor"
  [& nums]
  (->> nums
       sort
       first
       (#(range % 0 -1))
       (filter (fn [n] (every? #(= 0 (rem % n)) nums)))
       first
       )
  )

(deftest day2
  (testing "Advanced Destructuring"
    (is (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] [1 2 3 4 5]] [a b c d]))))

  (testing "A Half-Truth"
    (is (= false (half-truth false false)))
    (is (= true (half-truth true false)))
    (is (= false (half-truth true)))
    (is (= true (half-truth false true false)))
    (is (= false (half-truth true true true)))
    (is (= true (half-truth true true true false)))
    )

  (testing "Greatest Common Divisor"
    (is (= (gcd 2 4) 2))
    (is (= (gcd 10 5) 5))
    (is (= (gcd 5 7) 1))
    (is (= (gcd 1023 858) 33))
    )
  )