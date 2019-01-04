(ns living-clojure.week2.day3
  (:require [clojure.test :refer :all]))

(defn nth-power
  [n]
  (fn [x] (int (Math/pow x n)))
  )

(defn product
  "Cartesian product"
  [s1 s2]
  (into #{} (for [x s1 y s2] [x y]))
  )

(deftest day3
  (testing "Simple closures"
    (is (= 256 ((nth-power 2) 16),
           ((nth-power 8) 2)))
    (is (= [1 8 27 64] (map (nth-power 3) [1 2 3 4])))
    (is (= [1 2 4 8 16] (map #((nth-power %) 2) [0 1 2 3 4])))
    )

  (testing "Cartesian Product"
    (is (= (product #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
           #{["ace" "♠"] ["ace" "♥"] ["ace" "♦"] ["ace" "♣"]
             ["king" "♠"] ["king" "♥"] ["king" "♦"] ["king" "♣"]
             ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]}))
    (is (= (product #{1 2 3} #{4 5})
           #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}))
    (is (= 300 (count (product (into #{} (range 10))
                               (into #{} (range 30)))))))
  )
