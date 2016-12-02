(ns galeri.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [galeri.core-test]))

(doo-tests 'galeri.core-test)

