(ns galeri.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [galeri.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[galeri started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[galeri has shut down successfully]=-"))
   :middleware wrap-dev})
