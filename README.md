MathLib
=======

Java Math Engine


I decided to make an app that solves complex expressions. 
Originally, I decided to make an app that does differential and integral calculus. 
I found many 3rd party math parsing libraries online that I could use to accomplish this,
but I decided not to use any of them. Some of the ones I found were either too easy to implement, 
a mere 5 lines of code in one case, or the documentation was too obtuse to comprehend easily. 
So in the end, I decided to write my own library. 
		
My library, MathLib, is in a primitive state at the moment. It supports the following operations, 

+, -, * , / , ^ (exponential), % (modulus) and parenthesis (). 

It supports the Functions

sin cos tan csc sec cot asin acos atan ln log and abs



However, I have designed in to be expandable, and adding your own functions is very simple. 
The postfixer class converts the inputted string into RPN format using the shunting yard algorithm. 
With Java, one can simple input an expression and the system will calculate an answer. 
However, with the functions I want to add in the future, such as the trigonometric functions, differentiation etc, 

RPN format makes the process simpler. 

My ultimate goal is to create an app that does differential and integral calculus, perhaps even something on par with Wolfram Alpha's engine. 
Right now, my Engine can parse complex expressions, solve them or convert them into RPN format. 
