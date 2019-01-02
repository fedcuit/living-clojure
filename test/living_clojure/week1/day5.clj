(ns living-clojure.week1.day5
  (:require [clojure.test :refer :all]))

(defn compress
  "Compress a sequence"
  [s]
  (reduce (fn [acc e] (if (= e (last acc))
                        acc
                        (conj acc e))
            ) [] s)
  )

(defn compress2
  "Compress a sequence using partition-by"
  [s]
  (->> s
       (partition-by identity)
       (mapcat (partial take 1)))
  )

(defn dropNth
  "Drop every nTh item"
  [s nth]
  (->> s
       (partition-all nth)
       (mapcat #(take (dec nth) %)))
  )

(defn inflate
  "Repeat each item in a sequence given times"
  [s n]
  (mapcat #(repeat n %) s)
  )

(deftest day5
  (testing "Compress a sequence"
    (is (= (compress [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)))
    (is (= (apply str (compress "Leeeeeerrroyyy")) "Leroy"))
    (is (= (compress2 [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])))
    )

  (testing "Pack a sequence"
    (is (= (partition-by identity [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))))
    (is (= (partition-by identity [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))))
    (is (= (partition-by identity [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))))

  (testing "Drop Every nth Item"
    (is (= (dropNth [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])))

  (testing "Intro to Iterate"
    (is (= '(1 4 7 10 13) (take 5 (iterate #(+ 3 %) 1)))))

  (testing "Replicate a Sequence"
    (is (= (inflate [1 2 3] 2) '(1 1 2 2 3 3)))
    (is (= (inflate [:a :b] 4) '(:a :a :a :a :b :b :b :b)))
    (is (= (inflate [4 5 6] 1) '(4 5 6)))
    )
  )