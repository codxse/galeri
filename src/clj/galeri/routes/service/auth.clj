(ns galeri.routes.service.auth
  (:require [galeri.db.core :as db]
            [galeri.validation :refer [registration-errors]]
            [ring.util.http-response :as response]
            [buddy.hashers :as hashers]
            [clojure.tools.logging :as log]))

(defn handle-registration-error [e]
  (if (-> e
          (.getNextException)
          (.getMessage)
          (.startsWith "ERROR: duplicate key value"))
    (response/precondition-failed
      {:result :error
       :message "User with selected ID already exist!"})
    (do
      (log/error e)
      (response/internal-server-error
        {:reslut :error
         :message "Could not add new user! server error."}))))


(defn register!
  [{:keys [session]} user]
  (if (registration-errors user)
    (response/precondition-failed
      {:result :error})
    (try
      (db/create-user!
        (-> user
            (dissoc :pass-confirm)
            (update :pass hashers/encrypt)))
      (-> {:result :ok}
          (response/ok)
          (assoc :session (assoc session :identity (:id user))))
      (catch Exception e
        (handle-registration-error e)))))


