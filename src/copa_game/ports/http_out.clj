(ns copa-game.ports.http-out
  (:require [copa-game.adapters :as adapters]
            [copa-game.schemas.types :as schemas.types]
            [parenthesin.components.http :as components.http]
            [schema.core :as s]))

(s/defn get-teams
        [http :- schemas.types/HttpComponent]
        (->> {:url "https://l3-processoseletivo.azurewebsites.net/api/Competidores?copa=games"
              :as :json
              :method :get}
             (components.http/request http)
             :body
             adapters/wire->teams))