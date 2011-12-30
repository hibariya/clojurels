(ns clojurels.core
  (:gen-class))

(import '(java.io File))

(defn files-for [dirname]
  (map #(.getName %)
       (.listFiles (File. dirname))))

(defn -main [& args]
  (let [path (or (first args) ".")
        files (files-for path)]
    (println "ls: " path)
    (println (apply str (map #(println-str %) files)))))
