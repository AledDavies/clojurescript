(require '[lumo.build.api :as b])

(b/build "src"

{:main 'happy.main 
 :output-to "out/main.js" 
 :output-dir "build" 
 :target :nodejs 
 :verbose true})
