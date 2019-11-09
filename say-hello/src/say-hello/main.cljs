(ns say-hello.main (:require [cljs.nodejs :as nodejs][clojure.string :as string]))

(nodejs/enable-util-print!)

(defn say-hello 
  "Say Hello"  
  [args]
  (let [x (count args)]
    (cond (> x 0) (println "Hello" 
                           (str (string/join " "  args) "!!!"))
          :else (println "Hello Someone!!!")))
  )

(defn -main [& args] (say-hello args))

(set! *main-cli-fn* -main)
