# Maximizing Revenue in Online Ad Placement

## Problem Introduction
You have n ads to place on a popular Internet page. For each ad, you know how much is the advertiser willing to pay for one click on this ad. You have set up n slots on your page and estimated the expected number of clicks per day for each slot. Now, your goal is to distribute the ads among the slots to maximize the total revenue.

## Problem Description
**Task.** Given two sequences a1,a2,...,an (ai is the profit per click of the i-th ad) and b1,b2,...,bn (bi is the average number of clicks per day of the i-th slot), we need to partition them into n pairs (ai,bj) such that the sum of their products is maximized.
**Input Format.** The first line contains an integer n, the second one contains a sequence of integers a1,a2,...,an, the third one contains a sequence of integers b1,b2,...,bn.
**Constraints.** 1<=n<=10^3; 10^5 <=ai,bi <=10^5 for all 1<=i<=n.
**Output Format.** Output the maximum value of ai*ci where
c1, c2, . . . , cn is a permutation of b1,b2,...,bn.

### Sample 1
Input:
```
3
1 3 -5
-2 4 1
```
Output:
```
23
```
Explanation:
23 = 3 · 4 + 1 · 1 + (-5) · (-2).
