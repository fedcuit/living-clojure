(ns living-clojure.week3.day5
  (:require [clojure.test :refer :all]))

(defn anagram-finder
  [coll]
  (->> coll
       (group-by sort)
       vals
       (filter #(> (count %) 1))
       (map set)
       (set))
  )

(deftest day5
  (testing "Anagram Finder"
    (is (= (anagram-finder ["meat" "mat" "team" "mate" "eat"])
           #{#{"meat" "team" "mate"}}))
    (is (= (anagram-finder ["veer" "lake" "item" "kale" "mite" "ever"])
           #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}}))
    ))