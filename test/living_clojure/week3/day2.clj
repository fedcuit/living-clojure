(ns living-clojure.week3.day2
  (:require [clojure.test :refer :all]))

(defn flip-args
  "Flip args of given function"
  [f]
  (fn [& args] (apply f (reverse args)))
  )

(defn rotate
  "Rotate a sequence"
  [n s]
  (let [shift (pos? n) offset (Math/abs (rem n (count s)))]
    (if shift
      (concat (drop offset s) (take offset s))
      (concat (take-last offset s) (take (- (count s) offset) s))
      ))
  )

(defn rotate-c
  "Rotate a sequence"
  [n s]
  (let [len (count s) off (rem n len)]
    (->> (cycle s)
         (drop (+ len off))
         (take len)
         ))
  )

(deftest day2
  (testing "Flipping out"
    (is (= 3 ((flip-args nth) 2 [1 2 3 4 5])))
    (is (= true ((flip-args >) 7 8)))
    (is (= 4 ((flip-args quot) 2 8)))
    (is (= [1 2 3] ((flip-args take) [1 2 3 4 5] 3)))
    )

  (testing "Rotate a sequence"
    (is (= (rotate 2 [1 2 3 4 5]) '(3 4 5 1 2)))
    (is (= (rotate -2 [1 2 3 4 5]) '(4 5 1 2 3)))
    (is (= (rotate 6 [1 2 3 4 5]) '(2 3 4 5 1)))
    (is (= (rotate 1 '(:a :b :c)) '(:b :c :a)))
    (is (= (rotate -4 '(:a :b :c)) '(:c :a :b)))
    )

  (testing "Rotate a sequence (cycle)"
    (is (= (rotate-c 2 [1 2 3 4 5]) '(3 4 5 1 2)))
    (is (= (rotate-c -2 [1 2 3 4 5]) '(4 5 1 2 3)))
    (is (= (rotate-c 6 [1 2 3 4 5]) '(2 3 4 5 1)))
    (is (= (rotate-c 1 '(:a :b :c)) '(:b :c :a)))
    (is (= (rotate-c -4 '(:a :b :c)) '(:c :a :b)))
    )
  )