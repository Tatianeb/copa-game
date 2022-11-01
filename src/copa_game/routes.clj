(ns copa-game.routes
  (:require [reitit.swagger :as swagger]))


(def routes
  ["/swagger.json"
   {:get {:no-doc true
          :swagger {:info {:title "btc-wallet"
                           :description "small sample using the microservice-boilerplate"}}
          :handler (swagger/create-swagger-handler)}}])
