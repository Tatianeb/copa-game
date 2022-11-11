(ns copa-game.routes
  (:require [copa-game.ports.http-in :as ports.http-in]
            [copa-game.schemas.out :as out]
            [reitit.swagger :as swagger]
            [schema.core :as s]))

(def routes
  [["/swagger.json"
    {:get {:no-doc true
           :swagger {:info {:title "copa-game"
                            :description "Batalha de copa game"}}
           :handler (swagger/create-swagger-handler)}}]
   ["/copagame"
    {:swagger {:tags ["copagame"]}}

    ["/read"
     {:get {:summary "get all teams"
            :responses {200 {:body [out/Team]}
                        500 {:body s/Str}}
            :handler ports.http-in/get-teams}}]]])
