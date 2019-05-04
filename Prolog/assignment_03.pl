/**
* The "Tower of Hanoi" is simply a mathematical game or puzzle. it has 3 rods or
* poles and multiple discs of different sizes, which can be sled into any pole.
* The general objective is that od noving the entire stack of discs into another
* pole, whilst following the next set of rules.
* 	1. Only one disc is permitted to move at a time.
* 	2. Each move consists of taking the upper disk from one of the stacks
* 	and placing it on top of another stack or empty pole.
* 	3. No larger disk may be placed on top of any smaller disk.
*
* This game was created on 1883 by a french mathematician named "Eduoard Lucas".
*/

hanoi(1, X, Y,_):-
	write('Move from '),
	write(X),
	write('to '),
	write(Y),
	nl.

/** 
* For simplicity's sake, take 
* N as the number of discs.
* X as the right pole.
* Y as the left pole.
* Z as the center pole. 
*/

hanoi(N,X,Y,Z):-
	N>1,
	M is N-1,
  	hanoi(M,X,Z,Y),
  	hanoi(1,X,Y,_),
  	hanoi(M,Z,Y,X).
