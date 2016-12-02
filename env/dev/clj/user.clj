(ns user
  (:require [mount.core :as mount]
            [galeri.figwheel :refer [start-fw stop-fw cljs]]
            galeri.core))

(defn start []
  (mount/start-without #'galeri.core/repl-server))

(defn stop []
  (mount/stop-except #'galeri.core/repl-server))

(defn restart []
  (stop)
  (start))


