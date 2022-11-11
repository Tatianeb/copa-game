(ns integration.copagame.copagame-test
  (:require [clojure.test :as clojure.test]
            [com.stuartsierra.component :as component]
            [copa-game.routes :as routes]
            [integration.copagame.util :as util]
            [integration.parenthesin.util.http :as util.http]
            [integration.parenthesin.util.webserver :as util.webserver]
            [matcher-combinators.matchers :as matchers]
            [parenthesin.components.config :as components.config]
            [parenthesin.components.http :as components.http]
            [parenthesin.components.router :as components.router]
            [parenthesin.components.webserver :as components.webserver]
            [schema.test :as schema.test]
            [state-flow.api :refer [defflow]]
            [state-flow.assertions.matcher-combinators :refer [match?]]
            [state-flow.core :as state-flow :refer [flow]]))

(clojure.test/use-fixtures :once schema.test/validate-schemas)

(defn- create-and-start-components! []
  (component/start-system
   (component/system-map
    :config (components.config/new-config)
    :http (components.http/new-http-mock {})
    :router (components.router/new-router routes/routes)
    :webserver (component/using (components.webserver/new-webserver)
                                [:config :http :router]))))

(def teams
  [{:id "/nintendo-64/the-legend-of-zelda-ocarina-of-time"
    :titulo "The Legend of Zelda: Ocarina of Time (N64)"
    :nota 99.9
    :ano 1998,
    :urlImagem "https://l3-processoseletivo.azurewebsites.net/api/CapaJogo/nintendo-64/the-legend-of-zelda-ocarina-of-time"},
   {:id "/playstation/tony-hawks-pro-skater-2"
    :titulo "Tony Hawk's Pro Skater 2 (PS)"
    :nota 98.9
    :ano 2000
    :urlImagem "https://l3-processoseletivo.azurewebsites.net/api/CapaJogo/playstation/tony-hawks-pro-skater-2"}]
  )

(defflow
  flow-integration-copagame-test
  {:init (util/start-system! create-and-start-components!)
   :cleanup util/stop-system!
   :fail-fast? true}
  (flow "should interact with system"
    (flow "prepare system with http-out mocks"
      (util.http/set-http-out-responses! {"https://l3-processoseletivo.azurewebsites.net/api/Competidores?copa=games"
                                          {:body teams
                                           :status 200}})

      (flow "should list wallet deposits"
        (match? (matchers/embeds {:status 200
                                  :body teams})
                (util.webserver/request! {:method :get
                                          :uri    "/copagame/read"}))))))
