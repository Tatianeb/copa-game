(ns copa-game.server
  (:require
   [com.stuartsierra.component :as component]
   [copa-game.routes :as routes]
   [parenthesin.components.config :as config]
   [parenthesin.components.http :as http]
   [parenthesin.components.router :as router]
   [parenthesin.components.webserver :as webserver]
   [parenthesin.logs :as logs]))

(def system-atom (atom nil))

(defn- build-system-map []
  (component/system-map
   :config (config/new-config)
   :http (http/new-http)
   :router (router/new-router routes/routes)
   :webserver (component/using (webserver/new-webserver) [:config :http :router])))

(defn start-system! [system-map]
  (logs/setup [["*" :info]] :auto)
  (->> system-map
       component/start
       (reset! system-atom)))

(defn stop-system! []
  (swap!
   system-atom
   (fn [s] (when s (component/stop s)))))

(defn -main
  "The entry-point for 'gen-class'"
  [& _args]
  (start-system! (build-system-map)))

(comment
  (build-system-map)
  (start-system! (build-system-map))
  (stop-system!))