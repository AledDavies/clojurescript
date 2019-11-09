(ns happy.main 
  (:require [cljs.nodejs :as nodejs]
            [clojure.string :as string]))

(nodejs/enable-util-print!)

(defn sum-square-digits 
  "Produce the sum of the square of the digits of a number"
  [n]
  (->> n
       (iterate #(quot % 10))
       (take-while pos?)
       (map #(mod % 10))
       (map #(* % %))
       (reduce + 0)))

(defn in? 
  "Returns true if xs contains x"
  [xs x]  
  (some #(= x %) xs))

(defn one?
  "Returns true if the value is equal to 1"
  [n]
  (= n 1))

(defn happy? 
  "Is the supplied number happy?"
  [n]
  (cond 
    (js/isNaN n) false
    :else 
    (one? 
      (loop [xs [n] y n]
        (let [x (sum-square-digits y)] 
          (if (in? xs x) x
            (recur (conj xs x) x)))))))

(defn -main [& args]
  (println 
    (string/join "" 
                 (->> args
                      (map js/parseInt)
                      (map #(str % "->" (happy? %) "\n"))))))

(set! *main-cli-fn* -main)
