(ns copa-game.ports.http-in
  (:require
   [copa-game.ports.http-out :as http-out]))

(defn get-teams
  [{components :components}]
  (let [entries (http-out/get-teams components)]
    {:status 200
     :body entries}))