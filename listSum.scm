;Recursive list elements sum with validation

(define (listSum x)
  (cond
    [(not(list? x)) 'NotListException]
    [(null? x) 0]
    [(not(number? (car x))) (+ 0 (listSum (cdr x)))]
    (else (+ (car x) (listSum (cdr x))))
  )
)

;Iterative list elements sum with validation

(define (listSumI x r)
  (cond
    [(not(list? x)) 'NotListException]
    [(null? x) r]
    [(not(number? (car x))) (listSumI (cdr x) (+ 0 r))]
    (else (listSumI  (cdr x) (+ (car x) r)))
  )
)

(define (listSumS x)
  (listSumI x 0)
)
