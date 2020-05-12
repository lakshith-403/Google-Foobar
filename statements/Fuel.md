
# Fuel Injection Perfection

Commander Lambda has asked for your help to refine the automatic quantum antimatter fuel injection system for her LAMBCHOP doomsday device. It's a great chance for you to get a closer look at the LAMBCHOP - and maybe sneak in a bit of sabotage while you're at it - so you took the job gladly.

Quantum antimatter fuel comes in small pellets, which is convenient since the many moving parts of the LAMBCHOP each need to be fed fuel one pellet at a time. However, minions dump pellets in bulk into the fuel intake. You need to figure out the most efficient way to sort and shift the pellets down to a single pellet at a time.

The fuel control mechanisms have three operations:

1.  Add one fuel pellet
2.  Remove one fuel pellet
3.  Divide the entire group of fuel pellets by 2 (due to the destructive energy released when a quantum antimatter pellet is cut in half, the safety controls will only allow this to happen if there is an even number of pellets)

Write a function called answer(n) which takes a positive integer as a string and returns the minimum number of operations needed to transform the number of pellets to 1. The fuel intake control panel can only display a number up to 309 digits long, so there won't ever be more pellets than you can express in that many digits.

For example:

```
answer(4) returns 2: 4 -> 2 -> 1  
answer(15) returns 5: 15 -> 16 -> 8 -> 4 -> 2 -> 1

```
## Languages

To provide a Python solution, edit solution.py To provide a Java solution, edit solution.java

# Test cases

Inputs:

```
(string) n = "4"

```

Output:

```
(int) 2

```

Inputs:

```
(string) n = "15"

```

Output:

```
(int) 5

```

Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder

## Editorial
You have 3 options for a number.

 - add one
 - subtract one 
 - divide by 2
 
 Naive Solution would be to recursively trying all three possibilities until the final condition is met. But this Brute force solution is exponential to a base of 3. For the given constraints this time complexity is not sufficient .
 
 **Improvements**
 
 
It is clear that if the number is even the best option is to divide it.
If the number is odd you have two options, you can either increment it or decrement it. 
Here the best option is to arrive at the value with maximum number of 0 in the right side of the binary representation. Rightmost bit being zero means that the number is divisible by two. If the number has `n` 0 at the rightmost end the number can be divided by 2 `n` times. This leads us to the minimum number of operations. For further info check out [Binary Number Theory](https://www.britannica.com/science/binary-number-system) 


**Implementation**
 - Don't forget to use BigInteger class.
 - Use bitwise operations for division and checking bit values. This can dramatically decrease the running time.

Good luck
