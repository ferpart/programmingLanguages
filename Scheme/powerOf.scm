; Program to elevate a number to a power of x Recursively

(define (powerOf x pow)
  (cond 
    [(= pow 0) 1]
    (else (* x (powerOf x (- pow 1))))
  )
)

; Program to elevate a number to a power of x Recursively

(define (powerOfI x pow r)
  (cond
    [(= pow 0) r]
    (else (powerOfI x (- pow 1) (* r x)))
  )
)

(define (powerOfS x pow)
  (cond
    [(= pow 0) 1]
    (else (powerOfI x pow 1))
  )
)
