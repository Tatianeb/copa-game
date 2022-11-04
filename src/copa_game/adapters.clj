(ns copa-game.adapters
  (:require [schema.core :as s]))

(s/defn wire->teams
        [wire]
        (get-in wire [:id :titulo :nota :ano :urlImagem]))