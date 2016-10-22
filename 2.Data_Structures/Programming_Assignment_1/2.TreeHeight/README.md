# Compute tree height

## Problem Introduction
In this problem, your goal is to read a description of a tree from the input, implement the tree data structure, store the tree and compute its height.

## Problem Description
**Task.** You are given a description of a rooted tree. Your task is to compute and output its height. Recall that the height of a (rooted) tree is the maximum depth of a node, or the maximum distance from a leaf to the root. You are given an arbitrary tree, not necessarily a binary tree.

**Input Format.** The first line contains the number of vertices n. The second line contains n integer numbers from -1 to n - 1 parents of vertices. If the i-th one of them (0 <= i <= n - 1) is  1, vertex i is the root, otherwise it’s 0-based index of the parent of i-th vertex. It is guaranteed that there is exactly one root. It is guaranteed that the input represents a tree.

**Output Format.** Output the height of the tree.

### Sample 1
Input:
```
5
4 -1 4 1 1
```
Output:
```
3
```
Explanation:

The input means that there are 5 nodes with numbers from 0 to 4, node 0 is a child of node 4, node 1 istheroot,node2isachildofnode4,node3isachildofnode1andnode4isachildofnode1. To see this, let us write numbers of nodes from 0 to 4 in one line and the numbers given in the input in the second line underneath:

0  1 2 3 4

4 -1 4 1 1

Now we can see that the node number 1 is the root, because  1 corresponds to it in the second line. Also, we know that the nodes number 3 and number 4 are children of the root node 1. Also, we know that the nodes number 0 and number 2 are children of the node 4.

The height of this tree is 3, because the number of vertices on the path from root 1 to leaf 2 is 3.

### Sample 2
Input:
```
5
-1 0 4 0 3
```
Output:
```
4
```
Explanation:

The input means that there are 5 nodes with numbers from 0 to 4, node 0 is the root, node 1 is a child of node 0, node 2 is a child of node 4, node 3 is a child of node 0 and node 4 is a child of node 3. The height of this tree is 4, because the number of vertices on the path from root 0 to leaf 2 is 4.

