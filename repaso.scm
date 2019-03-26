;Contar los elementos dentro de una lista

(define (count l)
  (cond
    [(null? l) 0]
    [(not (list?  l)) 1 ]
    [else
      (+
	(count (car l))
	(count (cdr l)))
    ]
  )
)

;Concatenar dos listas en orden (se asume que es una lista

(define (concat l1 l2)
  (cond
    [(not(null? l1)) 
     (cons (car l1) (concat (cdr l1) l2))]
    [(null? l2) '()]
    (else 
      (cons (car l2) (concat l1 (cdr l2))))
   )
)

;Producto punto de dos listas las cuales son especificamente del mismo tamaño

(define (prodPuntoI l1 l2 r)
  (cond
    [(null? l1) r]
    (else
      (prodPuntoI (cdr l1) (cdr l2) (+ r (* (car l1) (car l2)))))
  )
)

(define (prodPuntoS l1 l2)
  (prodPuntoI l1 l2 0)
)
