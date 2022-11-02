(ns copa-game.controllers
  (:require [copa-game.ports.http-out :as http-out]
            [copa-game.schemas.types :as schemas.types]
            [schema.core :as s]))

(s/defn get-teams
        [{:keys [http]} :- schemas.types/Components]
        (let [teams (http-out/get-teams http)]
          {:entries teams}))