(ns living-clojure.week1.day2
  (:require [clojure.test :refer :all]))

(deftest day2
  (testing "Sequences: rest"
    (is (= [20 30 40] (rest [10 20 30 40]))))
  (testing "Intro to Functions"
    (is (= 8 ((fn add-five [x] (+ x 5)) 3)))
    (is (= 8 ((fn [x] (+ x 5)) 3)))
    (is (= 8 (#(+ % 5) 3)))
    (is (= 8 ((partial + 5) 3)))
    )

  (testing "Double Down"
    (let [double #(* % 2)]
      (is (= (double 2) 4))
      (is (= (double 3) 6))
      (is (= (double 11) 22))
      (is (= (double 7) 14))
      )
    )

  (testing "Hello World"
    (let [hello #(str "Hello, " %, "!")]
      (is (= (hello "Dave") "Hello, Dave!"))))

  (testing "map function"
    (is (= '(6 7 8) (map #(+ 5 %) '(1 2 3)))))

  (testing "filter function"
    (is (= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))))

  (testing "Local bindings"
    (is (= 7 (let [x 5] (+ 2 x))))
    (is (= 7 (let [x 3 y 10] (- y x))))
    (is (= 7 (let [x 21] (let [y 3] (/ x y)))))
    )

  (testing "Let it be"
    (is (= 10 (let [x 7 y 3] (+ x y))))
    (is (= 4 (let [y 3 z 1] (+ y z))))
    (is (= 1 (let [z 1] z))))
  )