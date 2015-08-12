(ns slack-invite.core
  (:require [bidi.bidi :as b]
            [bidi.ring :refer (make-handler)]
            [clj-slack.core :as slack]))

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
