(ns copa-game.schemas.types
  (:require
   [com.stuartsierra.component :as component]
   [parenthesin.components.http :as components.http]
   [schema.core :as s]))

(def HttpComponent (s/protocol components.http/HttpProvider))

(s/defschema Components
  {:config (s/protocol component/Lifecycle)
   :http HttpComponent
   :router (s/protocol component/Lifecycle)})