% 3. Write a predicate head/2 which takes a list as its first argument and returns the head of the list as its second argument. It should fail if there is no first element.

head([H|_], H).

% 4. Write a predicate tail/2 which takes a list as its first argument and returns the tail of the list as its second argument. It should fail if there is no first element.

tail([_|T], T).

% 5. Write a predicate last/2 which takes a list as its first argument and returns the last element of the list.

last([H|T], L) :-
    lasts(T, H, L).

lasts([], L, L).
lasts([H|T], _, L) :-
      	  lasts(T, H, L).

% 6. Write a predicate max/3 which takes three arguments, the first two are positive integer numbers and returns in the third the max of them.

max(X, Y, R) :-
	X > Y,
	R is X.
max(X, Y, R) :-
	Y > X,
	R is Y.
  
% 7. Write a predicate fact/2 which takes a natural number as first argument, and returns the factorial of the number.

fact(0, 1).
fact(N, R) :-
	N > 0,
	N1 is N-1, 
	fact(N1, R1),
	R is R1*N.

% 8. Write a predicate fib/2 which takes a natural number as first argument, and returns the value of the Fibonacci sequence for that position (counting from 1).

fib(0, 0).
fib(1, 1).
fib(N, R):-
        N > 1,
        N1 is N - 1,
        fib(N1, R1),
        N2 is N - 2,
        fib(N2, R2),
        R is R1 + R2.

% 9. Write a predicate length2/2 which takes a list as first argument, and returns in the second one the number of elements in the list.

length2([], 0).
length2([_|L] , R) :-
        length2(L, R1),
        R is R1 + 1.

% 10. Write a predicate power/3 which takes a number as first argument, a natural number as second argument and returns the first number to the power of the second.

power(_, 0, 1).
power(A, N, R) :-
	N > 0,
	N1 is N-1,
	power(A, N1, R1),
	R is R1*A.

% 16. Define sum/2 to take a list of integers as input and return the output as their sum.

sum(0, 0).
sum(N, R):-
        N > 0,
        N1 is N - 1,
        sum(N1, R1),
        R is R1 + N.

% Write a predicate dupli/2 which takes two inputs: the first is a list, and the second will be the list with every element duplicated.

dupli([],[]).	
dupli([H|T],[H,H|T1]):-
	dupli(T,T1).
