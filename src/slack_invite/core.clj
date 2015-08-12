(ns slack-invite.core
  (:require [bidi.ring :refer (make-handler)]
            [environ.core :refer [env]]
            [clj-slack.core :as slack]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [selmer.parser :as sel])
  (:use [ring.middleware.params]))

(def slack-connection {:api-url (env :api-url) :token (env :api-token)})
(def team-name (get env :team-name "Anonymous team"))

(defn render-file
  [file vars]
  (sel/render-file file (merge {:group team-name} vars)))

(defn show-form
  [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (render-file "templates/index.html" {})
   })

(defn keywordize
  [m]
  (into {}
        (for [[k v] m]
          [(keyword k) v])))

(defn handle-form
  [request]
  (let [form-data (:form-params request)
        validation (b/validate form-data
                    "email" v/email)]
      {:status 200
       :headers {"Content-Type" "text/html"}
       :body (render-file (if (nil? (first validation))
                            "templates/success.html"
                            "templates/index.html"
                            ) {:errors (keywordize  (first validation))})}))

(def routes
  ["/" {:get #'show-form
        :post #'handle-form}])

(def handler
  (-> (make-handler routes)
      wrap-params))
