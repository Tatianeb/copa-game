(ns copa-game.schemas.out
  (:require
   [schema.core :as s]))

(s/defschema Team
  {:id      s/Str
   :titulo  s/Str
   :nota    s/Num
   :ano     s/Num
   :urlImagem s/Str})
