(ns living-clojure.week3.day3
  (:require [clojure.test :refer :all]))

(defn un-interleave
  [coll n]
  (reduce-kv
    (fn [acc idx e] (update-in acc [(rem idx n)] (fn [l] (conj l e))))
    (into [] (repeat n []))
    (vec coll))
  )

(defn split-by-type
  [coll]
  (->> coll
       (group-by type)
       vals
       )
  )

(deftest day3
  (testing "Reverse Interleave"
    (is (= (un-interleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6))))
    (is (= (un-interleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8))))
    (is (= (un-interleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9))))
    )

  (testing "Split by Type"
    (is (= (set (split-by-type [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}))
    (is (= (set (split-by-type [:a "foo" "bar" :b])) #{[:a :b] ["foo" "bar"]}))
    (is (= (set (split-by-type [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]}))
    ))