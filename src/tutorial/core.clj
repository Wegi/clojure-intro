(ns tutorial.core)

;; a comment

5
;; an integer

3.142
;; a float

3/5
;; another float?

231231231231829376128317892369871263178236981726378123
;; what is MAX_INT?

"Know when a legend becomes a prophecy? When it gains believers."
;; a string

:geralt
;; a keyword


'(:a :list :of :elements "could be anything" 1)
;; a list - dont mind the '


[:a :vector :of :elements "same"]
;; a vector

{:a "map" "can" "contain" :anything 4}
;; who needs a comma?
{:possible :as, :well 4}

#{:i "am" :a :set 5555}

;; ################
(+ 2 3)
;; data is code - code is data -> Homoikonizität
;; calling something is just writing a list

(def a :foobar)
a
;; define any symbol you desire

(def 生日 "utf-8 is fine - also cake")
生日
;; go ahead, speak russian - this is russian, right?

(def π 3)
(inc π)
π


(fn [parameter1 parameter2 parameter-three]
  (+ parameter1 parameter2 parameter-three))
;; a function! yay

(def plus-three (fn [number]
                  (+ 3 number)))

(plus-three 7)

(defn minus-1
  "Takes a number and decreases it by one"
  [number]
  (dec number))
;; shortcut
(minus-1 -5)


(defn greeter
  ([person1]
   (str "Hi there " person1))
  ([p1 p2]
   (str "Hello Mr. " p1 ". Good evening Mrs. " p2))
  ([p1 p2 p3]
   "Three 's a crowd, get out!"))

(greeter "Wegi")
(greeter "Christian" "Krauti")
(greeter "Julie" "Joe" :hans-meier)

(defn exact-greeter
  [& args]
  (map (fn [name] (str "Hello " name ".")) args))

(exact-greeter "Geralt" "Ciri" "Yennefer" "Triss" "Sigismund" "Gaunter" "Keira")


(if true
  :foo
  :bar)

(when true
  :neat)

;; Don't we need some loops? Nah we get by.

(map minus-1 [1 2 3 4 5 6 7 8 9])

(class (map odd? [1 2 3 4]))
;; I am lazy

(filter odd? [1 2 3 4])

(filter (fn [x] (when (> (* x x) 15) x)) [1 2 3 4 5 6 7 8 9])

(apply + [1 2 3 4 5])

(let [a 25
      b 6
      c :foobar]
  (when (> (+ a b) 30)
    c))

;; where dem elixir threading mandem at?
(->> [1 2 3 4 5 6 7 8 9]
    (filter odd?)
    (map (fn [x] (+ 4)))
    (apply +))

(-> 5
    inc
    (+ 5)
    dec
    (* 5))

;; to infinity and beyond
(def odd-numbers
  (filter #(odd? %) (range)))

(take 100 odd-numbers)


;; now lets get meta 

(defn build-incrementer
  "Builds a custom incrementer"
  [incrementer-number]
  #(+ incrementer-number %))

(def inc-by-5 (build-incrementer 5))

(inc-by-5 51)


;; MACROS - OH NOOOOOO!
;; example stolen from "Clojure for the brave and true". Go read it

(defmacro infix
  "Use this macro when you pine for the notation of your childhood"
  [infixed]
  (list (second infixed) (first infixed) (last infixed)))

(infix (1 + 3))

(macroexpand '(infix (1 + 3)))


;; Now for some matters of state *ahem*
(def evil-state (atom {}))

evil-state
(deref evil-state)
@evil-state

(swap! evil-state #(assoc % :foo :bar))
@evil-state


;; More to know: Multimethods, Protocols, futures, refs, etc. Now: Happy Hacking!

