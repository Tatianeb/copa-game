(ns copa-game.ports.http-in
  (:require [copa-game.controllers :as controllers]))

(defn get-teams
  [{components :components}]
  (let [{:keys [entries]} (controllers/get-teams components)]
    {:status 200
     :body entries}))
