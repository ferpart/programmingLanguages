;GCD Iterative

(define (GCD a b)
  (cond
    [(or (not(number? a)) (not(number? b))) 'NotANumber] 
    [(= b 0) a]
    [(= a b) a]
    [(< a b) (GCD b a)]
    (else (GCD b (remainder a b)))
  )
)
