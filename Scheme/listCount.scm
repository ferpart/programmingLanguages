;List Count in recursive format

(define (listCnt x) 
      (cond          
        [(not (null? x)) (+ 1 (listCnt (cdr x)))]
        (else 0)
      )
)

;List Count in iterative format

(define (listCntI i x)
    (if (null? x)
        i
        [listCntI (+ 1 i) (cdr x)]
    )
)

(define (listCntS x)
    (listCntI 0 x)
)


