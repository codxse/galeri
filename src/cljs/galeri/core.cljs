(ns galeri.core)

(defn init! []
  (-> (.getElementById js/document "app")
      (.-innerHTML)
      (set! "Welcome to galeri")))
