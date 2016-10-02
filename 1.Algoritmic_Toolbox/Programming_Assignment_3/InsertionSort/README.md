# Insertion Sort

Idea behind insertion sort. Loop over positions in the array, starting with index 1. Each new position is like the new card handed to you by the dealer, and you need to insert it into the correct place in the sorted subarray to the left of that position.

**Inserting a value into a sorted subarray**
The main step in insertion sort is making space in an array to put the current value, which is stored in the variable key. As we saw above, we go through the subarray to the left of key's initial position, right to left, sliding each element that is greater than key one position to the right. Once we find an element that is less than key, or equal to key, we stop sliding and copy keyinto the vacated position just to the right of this element. (Of course, the position is not truly vacated, but its element was slid over to the right.)
