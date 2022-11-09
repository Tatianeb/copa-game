(ns copa-game.ports.http-out
  (:require [parenthesin.components.http :as components.http]
            [copa-game.schemas.types :as schemas.types]
            [schema.core :as s]
            [copa-game.schemas.out :as schemas.out]))

(s/defn get-teams :- [schemas.out/Team]
  [{:keys [http]} :- schemas.types/Components]
  (->>
    (components.http/request http {:url "https://l3-processoseletivo.azurewebsites.net/api/Competidores?copa=games"
                                   :as :json
                                   :method :get})
    :body))

(comment
(def http (:http @system-atom))
  (get-teams http))