# Week 8 Notes

## summary of efficiency for n-squared algorithms

comparisons:

- bubble sort: looks at about (n^2) / 2 elements 
- insertion sort: looks at about (n^2) / 4 elements
- selection sort: looks at about (n^2) / 2 elements

swaps:

- bubble sort: if swaps are 50% likely, (n^2) / 4 swaps
- insertion sort: same assumption gives (n^2) / 8 swaps
- selection sort: n swaps, one per pass

## my bad attempt at a visualization for bubble sort

bubble sort

- N passes through the array
- each pass goes through one fewer elements than the previous pass

traverses about N^2 / 2

A B C D E

--------- first pass goes through all elements

-------   second pass skips the last element

-----     third pass skips the last two elements

---       and so on...

-         final pass doesn't do anything, so it's really N-1 passes


-----
----.
---..
--...
-....


insertion sort

- N passes through the array
- each pass inserts into the sorted section, which starts empty and grows to N by the last pass
- each insertion will on average cover HALF of the sorted section (linear search average case)

traverses about N^2 / 4

A B C D E

not going through the rest of the visual here
