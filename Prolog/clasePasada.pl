abuelos(A, N):-paternidad(A, X), paternidad(X, N).
abuelo(A, N):-abuelos(A, N), hombre(A).
abuela(A, N):-abuelos(A, N), mujer(A).

madre(M, H):-paternidad(M, H), mujer(M).
padre(P, H):-paternidad(P, H), hombre(P).

hermanos(X, Y):-paternidad(P, X), paternidad(P, Y).
hermana(X, Y):-hermanos(X, Y), mujer(X), X\=Y.
hermano(X, Y):-hermanos(X, Y), hombre(X), X\=Y.

mujer(pam).
mujer(liz).
mujer(ann).

hombre(tom).
hombre(bob).
hombre(pat).
hombre(jim).

paternidad(pam, bob).
