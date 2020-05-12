## Bomb Baby
You're so close to destroying the *LAMBCHOP* doomsday device you can taste it! But in order to do so, you need to deploy special self-replicating bombs designed for you by the brightest scientists on Bunny Planet. There are two types: *Mach* bombs (M) and *Facula* bombs (F). The bombs, once released into the *LAMBCHOP's* inner workings, will automatically deploy to all the strategic points you've identified and destroy them at the same time.

But there's a few catches. First, the bombs self-replicate via one of two distinct processes: Every Mach bomb retrieves a sync unit from a *Facula* bomb; for every Mach bomb, a *Facula* bomb is created; Every *Facula* bomb spontaneously creates a Mach bomb.

For example, if you had 3 Mach bombs and 2 Facula bombs, they could either produce 3 Mach bombs and 5 Facula bombs, or 5 Mach bombs and 2 Facula bombs. The replication process can be changed each cycle.

Second, you need to ensure that you have exactly the right number of Mach and Facula bombs to destroy the LAMBCHOP device. Too few, and the device might survive. Too many, and you might overload the mass capacitors and create a singularity at the heart of the space station - not good!

And finally, you were only able to smuggle one of each type of bomb - one Mach, one Facula - aboard the ship when you arrived, so that's all you have to start with. (Thus it may be impossible to deploy the bombs to destroy the LAMBCHOP, but that's not going to stop you from trying!)

You need to know how many replication cycles (generations) it will take to generate the correct amount of bombs to destroy the LAMBCHOP. Write a function answer(M, F) where M and F are the number of Mach and Facula bombs needed. Return the fewest number of generations (as a string) that need to pass before you'll have the exact number of bombs necessary to destroy the LAMBCHOP, or the string "impossible" if this can't be done! M and F will be string representations of positive integers no larger than 10^50. For example, if M = "2" and F = "1", one generation would need to pass, so the answer would be "1". However, if M = "2" and F = "4", it would not be possible.

## Test cases

Inputs:  `(string) M = "2" (string) F = "1"`

Output:  `(string) "1"`

Inputs:  `(string) M = "4" (string) F = "7"`

Output:  `(string) "4"`

Inputs:  `(string) M = "2" (string) F = "4"`

Output:  `(string) "impossible"`

## Editorial

To understand the problem think of F and M as just two numbers. Initially both of them are 1. You can add one number to the another. Finally you have to make them into specific given values.

**Valuable Observations**
 - F and M never can be equal after the first step.
   After the first step one becomes 2 and another stays 1. Now the difference between them are one. If you add the smaller one to the larger one their difference increases by the value of smaller number. If you add the larger number to the smaller number their difference stays the same. So whatever you do, The difference can not decrease. So the two numbers can not be equal. 
   `F != M where steps n >= 1`
   
 - Let's take two values `A` and `B` (`A<B`).
    if we add `A` to `B` then `B` becomes strictly greater than `B`
    if we add `B` to `A` then `A` becomes strictly greater than `A`
    so,
     if `F>M` last step was adding `M` to `F`
     if `M>F` last step was adding `F` to `M`

**Solution**

Because of the last observation we can [Reverse Engineer](https://en.wikipedia.org/wiki/Reverse_engineering) two final values.

    while(F>1 AND M>1)
		    if(F>M)F=F-M
		    if(M>F)M=M-F

In the end if both values are equal to one we can return a count of steps otherwise `impossible`

But for the given constraints of `10^50` this solution is not sufficient. We have to speed up our solution. 

 - In the loop if we encounter a situation of `F==M && F!=1` then the solution doesn't exist. We can return  `impossible`
 - if `F>>M OR M>>F` we will have to decrease the same number repeatedly. So we can do it in a single step and increment our count appropriately.
 How to do it is left for you to find out. (Tip: in a situation of `F>M` what is the relation between new value of `F` and `F MOD M`)

**Implementation tips (JAVA)**

 - Constraints are two high for basic numerical data types. So use *BigInteger*
 
 Check out my Code if you're completely stuck. But try to understand and write your own code.
 Good Luck
