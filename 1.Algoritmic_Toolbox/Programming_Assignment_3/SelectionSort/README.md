# Selection Sort

## Description
Selection sort loops over positions in the array. For each position, it finds the index of the minimum value in the subarray starting at that position. Then it swaps the values at the position and at the minimum index.

## Asymptotic running-time analysis for selection sort
The total running time for selection sort has three parts:
	.	The running time for all the calls to indexOfMinimum.
	.	The running time for all the calls to swap.
	.	The running time for the rest of the loop in the selectionSort function.

The loop in indexOfMinimum will always make n^2 + n/2 iterations, regardless of the input. Therefore, we can say that selection sort runs in Θ(n^2) time in all cases.
