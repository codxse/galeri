(ns galeri.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[galeri started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[galeri has shut down successfully]=-"))
   :middleware identity})
