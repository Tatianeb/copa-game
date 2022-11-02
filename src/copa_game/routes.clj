(ns copa-game.routes
  (:require [reitit.swagger :as swagger]))


(def routes
  ["/swagger.json"
   {:get {:no-doc true
          :swagger {:info {:title "test"
                           :description "test"}}
          :handler (swagger/create-swagger-handler)}}])
