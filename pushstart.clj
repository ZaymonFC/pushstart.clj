#!/usr/bin/env bb
(require '[clojure.pprint :as pp]
         '[clojure.string :refer [join]])

(defn lines [& lines] (reduce (fn [a b] (str a "\n" b)) lines))

(defn quote->string [code]
  (with-out-str (pp/pprint code)))

(def deps-edn
  (quote->string
   '{:deps
     {org.clojure/clojure {:mvn/version "1.10.1"}
      org.clojure/data.json {:mvn/version "2.4.0"}
      org.clojure/data.csv {:mvn/version "1.0.0"}
      clojure.java-time/clojure.java-time {:mvn/version "0.3.2"}
      clj-http/clj-http {:mvn/version "3.12.3"}
      camel-snake-kebab/camel-snake-kebab {:mvn/version "0.4.2"}}}))

(def git-ignore
  (lines
   "pom.xml"
   "pom.xml.asc"
   "*.jar"
   "*.class"
   "/lib/"
   "/classes/"
   "/target/"
   "/checkouts/"
   ".lein-deps-sum"
   ".lein-repl-history"
   ".lein-plugins/"
   ".lein-failures"
   ".nrepl-port"
   ".cpcache/"
   ".lsp"
   ".calva"
   ".clj-kondo"))

(def read-me
  (lines
   "## README"
   ""
   "Generated with pushstart.clj"))


(def script
  "Quoted code block that becomes 'script.clj'"
  (->>
   ['(require '[clojure.data.json :as json]
              '[clojure.data.csv :as csv]
              '[camel-snake-kebab.core :as csk]
              '[java-time :as time]
              '[clj-http.client :as client])
    '(println "Hello World!")]
   (map quote->string)
   (join "\n")))

(def files-to-generate
  [["deps.edn" deps-edn]
   ["script.clj" script]
   [".gitignore" git-ignore]
   ["README.md" read-me]])

(->> files-to-generate
     (map (fn [[filename content]]
            (spit filename content)))
     doall)

(->> files-to-generate
     (map first)
     (into []))
