## Power Hungry


You need to figure out which sets of panels in any given array you can take offline to repair while still maintaining the maximum amount of power output per array, and to do THAT, you'll first need to figure out what the maximum output of each array actually is. Write a function answer(xs) that takes a list of integers representing the power output levels of each panel in an array, and returns the maximum product of some non-empty subset of those numbers. So for example, if an array contained panels with power output levels of `[2, -3, 1, 0, -5]`, then the maximum product would be found by taking the subset: `xs[0] = 2, xs[1] = -3, xs[4] = -5`, giving the product `2*(-3)*(-5) = 30`. So answer `([2,-3,1,0,-5])` will be `"30"`.

Each array of solar panels contains at least 1 and no more than 50 panels, and each panel will have a power output level whose absolute value is no greater than 1000 (some panels are malfunctioning so badly that they're draining energy, but you know a trick with the panels' wave stabilizer that lets you combine two negative-output panels to produce the positive output of the multiple of their power values). The final products may be very large, so give the answer as a string representation of the number.

# Languages

To provide a Python solution, edit solution.py To provide a Java solution, edit solution.java

# Test cases

```
Inputs:
    (int list) xs = [2, 0, 2, 2, 0]
Output:
    (string) "8"

Inputs:
    (int list) xs = [-2, -3, 4, -5]
Output:
    (string) "60"
```
### Editorial
This problem can be simplified into,

> Given an array of integers what is the maximum product that can be gained by a non-empty sub array

The solution is quite simple.
We have 3 types of numbers.

 - Positive Integers
 - Negative Integers
 - Zero


If we add Zero to our Sub Array then the product will be zero. So we have to skip any zero we get.
Adding positive integers will never decrease the product so we can add all of them.
Negative Integers are the tricky part. Note that even number of negative integers make the product positive. So if there are even number of negative integers we can add all of them. If there are odd number of negative integers best solution is to skip the minimum **absolute** value and add the others.
### Edge cases

    input: 0 , 0 , 0 , -100 , 0 , 0
   According to our current algorithm we skip zero values. Then the output will be `-100`. But Zero is greater than a negative integer. So in case of a negative answer if there are any zero values, return 0 instead.

### A note about My solution
When i was writing my solution i thought we can't use any library. So i implemented everything myself. I wrote Addition and Multiplication Methods to handle large inputs. And in the latter part i wrote a sorting algorithm to sort negative integers. But actually we don't need to sort. Because we only ignore a single element we can just keep track of the minimum absolute value.
