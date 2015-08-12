(defproject slack-invite "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.julienxx/clj-slack "0.4.3"]
                 [environ "1.0.0"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [bidi "1.20.3"]]
  :main ^:skip-aot slack-invite.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
