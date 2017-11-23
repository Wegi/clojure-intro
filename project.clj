(defproject tutorial "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.9.0-alpha20"]
                 [org.clojure/core.async "0.3.443"]]
  :profiles {:dev {:dependencies [[org.clojure/test.check "0.9.0"]
                                  [nightlight "1.9.0"]]

                   :plugins [[cider/cider-nrepl "0.16.0-SNAPSHOT"]
                             [refactor-nrepl "2.4.0-SNAPSHOT"]]}
             :uberjar {:aot :all}}
  )
