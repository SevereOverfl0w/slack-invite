(ns slack-invite.core
  (:require [bidi.bidi :as b]
            [bidi.ring :refer (make-handler)]
            [environ.core :refer [env]]
            [clj-slack.core :as slack])
  (:use [selmer.parser]))

(def slack-connection {:api-url (env :api-url) :token (env :api-token)})
(def team-name (get env :team-name "Anonymous team"))

(defn showForm
  [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (render-file "templates/index.html" {})
   })

(defn handleForm
  [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Gratz"})

(def routes
  ["/" {:get #'showForm
        :post #'handleForm}])

(def handler
  (make-handler routes))
