(ns
 ^{:deprecated true
   :doc "DEPRECATED: moved to clj-commons.byte-streams.utils"
   :no-doc true
   :superseded-by "clj-commons.byte-streams.utils"}
 byte-streams.utils)

(defmacro doit
  "A version of doseq that doesn't emit all that inline-destroying chunked-seq code."
  [[x it] & body]
  (let [it-sym (gensym "iterable")]
    `(let [~it-sym ~it
           it# (.iterator ~(with-meta it-sym {:tag 'java.lang.Iterable}))]
       (loop []
         (when (.hasNext it#)
           (let [~x (.next it#)]
             ~@body)
           (recur))))))
