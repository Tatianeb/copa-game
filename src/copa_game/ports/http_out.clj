(ns copa-game.ports.http-out
  (:require [copa-game.schemas.out :as schemas.out]
            [copa-game.schemas.types :as schemas.types]
            [parenthesin.components.http :as components.http]
            [schema.core :as s]))

(s/defn get-teams :- [schemas.out/Team]
  [{:keys [http]} :- schemas.types/Components]
  (->>
   (components.http/request http {:url "https://l3-processoseletivo.azurewebsites.net/api/Competidores?copa=games"
                                  :as :json
                                  :method :get})
   :body))