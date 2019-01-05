(ns living-clojure.week3.day1
  (:require [clojure.test :refer :all]))

(defn bin-tree?
  "Check if a sequence is binary tree"
  [coll]
  (if (not (coll? coll))
    true
    (let [[_ l r] coll] (and (= 3 (count coll)) (bin-tree? l) (bin-tree? r))))
  )

(deftest day1
  (testing "To Tree, or not to Tree"
    (is (= true (bin-tree? '(:a (:b nil nil) nil))))
    (is (= false (bin-tree? '(:a (:b nil nil)))))
    (is (= true (bin-tree? [1 nil [2 [3 nil nil] [4 nil nil]]])))
    (is (= false (bin-tree? [1 [2 nil nil] [3 nil nil] [4 nil nil]])))
    (is (= true (bin-tree? [1 [2 [3 [4 nil nil] nil] nil] nil])))
    (is (= false (bin-tree? '(:a nil ()))))
    )
  )