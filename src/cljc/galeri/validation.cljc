(ns galeri.validation
  (:require [bouncer.core :as bouncer]
            [bouncer.validators :as validator]))

(defn registration-errors
  [{:keys [pass-confirm] :as params}]
  (first
    (bouncer/validate
      params
      :id validator/required
      :pass [validator/required
             [validator/min-count 8 :message "Password must contain at least 8 chars!"]
             [= pass-confirm :message "Re-entered password does not match!"]])))

