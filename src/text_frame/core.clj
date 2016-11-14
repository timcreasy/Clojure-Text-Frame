(ns text-frame.core
  (:gen-class))

(defn get-longest-word
  [text]
  (count (apply max-key count text))
)

(defn print-header-footer
  [longest-word-length]
  (println
    (apply str (repeat (+ longest-word-length 4) "*"))
  )
)

(defn right-padding
  [amount]
  (apply str (repeat amount " "))
)

(defn print-word
  [word, longest-word-length]
  (if (< (count word) longest-word-length)
    (println (str "* " word (right-padding (- longest-word-length (count word))) " *"))
    (println (str "* " word " *"))
  )
)

(defn print-frame
  [input-text]
  (def longest-word-length (get-longest-word input-text))
  (print-header-footer longest-word-length)
  (doseq [word input-text] (print-word word longest-word-length))
  (print-header-footer longest-word-length)
)

(defn -main
  []
  (print-frame ["Hello", "World", "in", "a", "frame"])
)
