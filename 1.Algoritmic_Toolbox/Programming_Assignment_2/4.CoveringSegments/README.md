# Collecting Signatures

## Problem Introduction
You are responsible for collecting signatures from all tenants of a certain build- ing. For each tenant, you know a period of time when he or she is at home. You would like to collect all signatures by visiting the building as few times as possible.
The mathematical model for this problem is the following. You are given a set of segments on a line and your goal is to mark as few points on a line as possible so that each segment contains at least one marked point.

## Problem Description
**Task.** Given a set of n segments {[a0, b0], [a1, b1], . . . , [an 1, bn 1]} with integer coordinates on a line, find the minimum number m of points such that each segment contains at least one point. That is, find a set of integers X of the minimum size such that for any segment [ai,bi] there is a point x 2 X such that ai <=x <= bi.
**Input Format.** The first line of the input contains the number n of segments. Each of the following n lines contains two integers ai and bi (separated by a space) defining the coordinates of endpoints of the i-th segment.
**Constraints.** 1<=n<=100; 0<=ai <=bi <=10^9 for all 0<=i<n.
**Output Format.** Output the minimum number m of points on the first line and the integer coordinates of m points (separated by spaces) on the second line. You can output the points in any order. If there are many such sets of points, you can output any set. (It is not difficult to see that there always exist a set of points of the minimum size such that all the coordinates of the points are integers.)

### Sample 1
Input:
```
3
1 3
2 5
3 6
```
Output:
```
1
3
```
Explanation:
In this sample, we have three segments: [1,3],[2,5],[3,6] (of length 2,3,3 respectively). All of them containthepointwithcoordinate3: 1 <= 3 <= 3, 2 <= 3 <= 5, 3 <= 3 <= 6.

### Sample 2
Input:
```
4
4 7
1 3
2 5
5 6
```
Output:
```
2
3 6
```
Explanation:
The second and the third segments contain the point with coordinate 3 while the first and the fourth segments contain the point with coordinate 6. All the four segments cannot be covered by a single point, since the segments [1, 3] and [5, 6] are disjoint.
