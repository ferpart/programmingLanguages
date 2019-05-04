persona(alex).
persona(ana).
persona(ricardo).
persona(paola).
persona(humberto).
persona(luis).

hombre(alex).
hombre(ricardo).
hombre(humberto).
hombre(luis).

mujer(ana).
mujer(paola).

profesor(alex).
profesor(ana).
profesor(ricardo).

alumno(paola).
alumno(humberto).
alumno(luis).

%alumno(X):-persona(X), not(profesor(X)).

estudiaT(X):-mujer(X), alumno(X).

imparteT(X):-hombre(X), profesor(X).
imparteT(ana).

doctorado(alex).

maestria(ricardo).
maestria(X):-doctorado(X).
maestria(X):-imparteT(X).

excelente(X):-estudiaT(X).
excelente(humberto).
excelente(luis).

alumnoP(humberto, alex).
alumnoP(luis, alex).
alumnoP(paola, ricardo).
