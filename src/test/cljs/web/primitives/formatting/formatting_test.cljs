(ns web.primitives.formatting.formatting-test
  (:require [clojure.test :refer [run-tests deftest is]]
            [web.primitives.formatting.core :as formatting]))

(deftest format-numbers
  (is (= "1,23" (formatting/format-number 123000000)))
  (is (= "0,89" (formatting/format-number 88800000)))
  (is (= "0,22" (formatting/format-number 22400000)))
  (is (= "0,00" (formatting/format-number 49999)))
  (is (= "0,18" (formatting/format-number 18000000 :mn)))
  (is (= "5,76" (formatting/format-number 576000000 :mn)))
  (is (= "5,77" (formatting/format-number 576700000 :mn)))
  (is (= "1,00" (formatting/format-number 100000059 :mn)))
  (is (= "3.733,60" (formatting/format-number 373359624800 :mn)))
  (is (= "123" (formatting/format-number 12300000 :tsd)))
  (is (= "9.876" (formatting/format-number 987600000 :tsd)))
  (is (= "9.877" (formatting/format-number 987680000 :tsd)))
  (is (= "2.325" (formatting/format-number 232454462 :tsd)))
  (is (= "9.615.576" (formatting/format-number 961557625586 :tsd)))
  (is (= "123.456" (formatting/format-number 12345600 :full)))
  (is (= "123.457" (formatting/format-number 12345692 :full)))
  (is (= "792" (formatting/format-number 79200 :full)))
  (is (= "3.215.233.226" (formatting/format-number 321523322579 :full)))
  (is (= "" (formatting/format-number nil)))
  (is (= "" (formatting/format-number "")))
  (is (= "NaN" (formatting/format-number "OqkxyV")))
  (is (= "NaN" (formatting/format-number "osP9/Bs7"))))

(deftest format-percent
  (is (= "25,00 %" (formatting/format-percent 0.25)))
  (is (= "1,00 %" (formatting/format-percent 0.01)))
  (is (= "15,90 %" (formatting/format-percent 0.159)))
  (is (= "75,31 %" (formatting/format-percent 0.7531)))
  (is (= "96,78 %" (formatting/format-percent 0.96783)))
  (is (= "24,94 %" (formatting/format-percent 0.24937)))
  (is (= "123,45 %" (formatting/format-percent 1.2345)))
  (is (= "987,65 %" (formatting/format-percent 9.87654)))
  (is (= "" (formatting/format-percent nil)))
  (is (= "" (formatting/format-percent "")))
  (is (= "" (formatting/format-percent "PwnXks")))
  (is (= "" (formatting/format-percent "pqX7/dw9"))))

(run-tests 'web.primitives.formatting.formatting-test)