# Small Fibonacci Number

## Problem Introduction
Recall the definition of Fibonacci sequence: F0 = 0, F1 = 1, and Fi = Fi-1 + Fi-2 for i >= 2. Your goal in this problem is to implement an efficient algorithm for computing Fibonacci numbers. The starter files for this problem contain an implementation of the following naive recursive algorithm for computing Fibonacci numbers in C++, Java, and Python3:

```
 Fibonacci(n):
  if n <= 1:
  	return n
 return Fibonacci(n - 1) + Fibonacci(n - 2)
```

## Problem Description
**Task.** Given an integer n, find the nth Fibonacci number Fn.
**Input Format.** The input consists of a single integer n.
**Constraints.** 0 <= n <= 45.
**Output Format.** Output Fn.

### Sample 1
Input:
```
3
```
Output:
```
2
```
Explanation: 
F3 = 2.

### Sample 2
Input:
```
10
```
Output:
```
55
```
Explanation: 
F10 = 55.