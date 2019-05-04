sumN(0, 0).
sumN(N, R):-
	N > 0,
	N1 is N - 1,
	sumN(N1, R1),
	R is R1 + N.

fibonacci(0, 0).
fibonacci(1, 1).
fibonacci(N, R):-
	N > 1,
	N1 is N - 1,
	fibonacci(N1, R1),
	N2 is N - 2,
	fibonacci(N2, R2),
	R is R1 + R2.

p([the, cat, sat, [on, the, mat]]).

long([], 0).
long([_|L] , R) :-
	long(L, R1),
	R is R1 + 1.


