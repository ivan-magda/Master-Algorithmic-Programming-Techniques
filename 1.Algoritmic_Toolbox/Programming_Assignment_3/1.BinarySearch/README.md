# Binary Search

## Problem Introduction
In this problem, need to implement the binary search algorithm that allows searching very efficiently (even huge) lists, provided that the list is sorted.

## Problem Description
**Task.** The goal in this code problem is to implement the binary search algorithm.
**Input Format.** The first line of the input contains an integer 𝑛 and a sequence 𝑎0 < 𝑎1 < . . . < 𝑎𝑛−1 of 𝑛 pairwise distinct positive integers in increasing order. The next line contains an integer 𝑘 and 𝑘 positive integers 𝑏0, 𝑏1, . . . , 𝑏𝑘−1.
**Constraints.** 1≤𝑛, 𝑘≤10^5; 1≤𝑎𝑖 ≤10^9 for all 0≤𝑖<𝑛; 1≤𝑏𝑗 ≤10^9 for all 0≤𝑗<𝑘; **Output Format.** For all 𝑖 from 0 to 𝑘−1, output an index 0≤𝑗≤𝑛−1 such that 𝑎𝑗 =𝑏𝑖 or −1 if there is no such index.

### Sample
Input:
```
5 1 5 8 12 13
5 8 1 23 1 11
```
Output:
```
2 0 -1 0 -1
```
Explanation:
In this sample, we are given an increasing sequence 𝑎0 = 1, 𝑎1 = 5, 𝑎2 = 8, 𝑎3 = 12, 𝑎4 = 13 of length  ve and  ve keys to search: 8,1,23,1,11. We see that 𝑎2 = 8 and 𝑎0 = 1, but the keys 23 and 11 do not appear in the sequence 𝑎. For this reason, we output a sequence 2, 0, −1, 0, −1.