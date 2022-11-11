(ns integration.copagame.util
  (:require [com.stuartsierra.component :as component]
            [parenthesin.logs :as logs]))

(defn start-system!
  [system-start-fn]
  (fn []
    (logs/setup [["*" :info]] :auto)
    (system-start-fn)))

(defn stop-system!
  [system]
  (component/stop-system system))