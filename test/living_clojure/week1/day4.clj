(ns living-clojure.week1.day4
  (:require [clojure.test :refer :all]))

(defn isPalindrome
  "Check if a sequence is palindrome"
  [s]
  (let [pivot (/ (count s) 2)]
    (if (= (take (Math/floor pivot) s)
           (reverse (drop (Math/ceil pivot) s)))
      true
      false))
  )

(defn duplicate
  "Repeat each element in a sequence"
  [s]
  (mapcat #(list % %) s)
  )

(deftest day4
  (testing "Penultimate Element"
    (let [penultimate #(->> % reverse second)]
      (is (= (penultimate (list 1 2 3 4 5)) 4))
      (is (= (penultimate ["a" "b" "c"]) "b"))
      (is (= (penultimate [[1 2] [3 4]]) [1 2]))
      )
    )

  (testing "Sum It All Up"
    (let [sum #(reduce + %)]
      (is (= (sum [1 2 3]) 6))
      (is (= (sum (list 0 -2 5 5)) 8))
      (is (= (sum #{4 2 1}) 7))
      (is (= (sum '(0 0 -1)) -1))
      (is (= (sum '(1 10 3)) 14))
      ))

  (testing "Find the odd numbers"
    (let [filter-odd #(filter odd? %)]
      (is (= (filter-odd #{1 2 3 4 5}) '(1 3 5)))
      (is (= (filter-odd [4 2 1 6]) '(1)))
      (is (= (filter-odd [2 2 4 6]) '()))
      (is (= (filter-odd [1 1 1 3]) '(1 1 1 3)))
      ))

  (testing "Palindrome Detector"
    (is (= false (isPalindrome '(1 2 3 4 5))))
    (is (= true (isPalindrome "racecar")))
    (is (= true (isPalindrome [:foo :bar :foo])))
    (is (= true (isPalindrome '(1 1 3 3 1 1))))
    (is (= false (isPalindrome '(:a :b :c))))
    )

  (testing "Duplicate a Sequence"
    (is (= (duplicate [1 2 3]) '(1 1 2 2 3 3))))
  )

