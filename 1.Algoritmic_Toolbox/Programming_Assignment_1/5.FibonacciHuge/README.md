# Huge Fibonacci Number modulo m

## Problem Introduction
In this problem, your goal is to compute Fn modulo m, where n may be really huge: up to 1018. For such values of n, an algorithm looping for n iterations will not fit into one second for sure. Therefore we need to avoid such a loop.
To get an idea how to solve this problem without going through all Fi for i from 0 to n, let’s see what happens when m is small   say, m = 2 or m = 3.


i 				0 1 2 3 4 5 6  7  8  9 10 11  12  13  14  15
Fi 				0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 
F i mod 2 		0 1 1 0 1 1 0  1  1  0  1  1   0   1   1   0 
F i mod 3 		0 1 1 2 0 2 2  1  0  1  1  2   0   2   2   1

Take a detailed look at this table. Do you see? Both these sequences are periodic! For m = 2, the period is 011 and has length 3, while for m = 3 the period is 01120221 and has length 8. Therefore, to compute, say, F2015 mod 3 we just need to find the remainder of 2015 when divided by 8. Since 2015 = 251 · 8 + 7, we conclude that F2015 mod 3 = F7 mod 3 = 1.
This is true in general: for any integer m   2, the sequence Fn mod m is periodic. The period always starts with 01 and is known as Pisano period.

## Problem Description
**Task.** Given two integers n and m, output Fn mod m (that is, the remainder of Fn when divided by m).
**Input Format.** The input consists of two integers n and m given on the same line (separated by a space).
**Constraints.** 1 <= n <= 10^18, 2 <= m <= 10^5.
**Output Format.** Output Fn mod m.

### Sample 1
Input:
```
1 239
```
Output:
```
1
```
Explanation: 
F1 mod239=1mod239=1.

### Sample 2
Input:
```
239 1000
```
Output:
```
161
```
Explanation: 
F239 mod 1000 = 39679027332006820581608740953902289877834488152161 (mod 1000) = 161.