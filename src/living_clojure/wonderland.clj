(ns living-clojure.wonderland
  (:require [clojure.set :as s]))

(defn common-fav-foods [foods1 foods2]
  (let [food-set1 (set foods1)
        food-set2 (set foods2)
        common-foods (s/intersection food-set1 food-set2)]
    (str "Common Foods: " common-foods))
  )

(defn -main []
  (let [foods (common-fav-foods [:jam :brownies :toast] [:lettuce :carrots :jam])]
    (println foods))
  )