(ns slack-invite.core
  (:require [bidi.bidi :as b]
            [bidi.ring :refer (make-handler)]
            [environ.core :refer [env]]
            [clj-slack.core :as slack]))

(def slack-connection {:api-url (env :api-url) :token (env :api-token)})

(defn showForm
  [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "<h1>Hello world!</h1>"})

(defn handleForm
  [request]
)

(def routes
  ["/" {:get showForm
        :post handleForm}])

(def handler
  (make-handler routes))
