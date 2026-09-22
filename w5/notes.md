# Week 5 Notes

## Terms

- Problem: what question are we trying to answer?
- Algorithm: how are we going to answer that question?
- Implementation: the code that implements the algorithm

Example

- Problem: search an array to find whether it contains a specific element
- Algorithm: sequential/linear search
- Implementation: our UnsortedIntArrayList's contains and remove methods

## Best/Average/Worst Case

For linear search:

- Best case: first element is the one we're looking for
- Worst case: element isn't in the collection
- Average case: element is in the middle of the collection

## Big-Oh, Big-Omega, and Big-Theta

- Big-Oh: upper bound
- Big-Omega: lower bound
- Big-Theta: upper and lower bound

## Easy/Default

We're usually talking Big-Oh of the average case.

## Growth Rates

We can rank different growth rates as follows (smallest to largest):

1. constant: doesn't change with input size; f(n) = c, where c is some constant
2. logarithmic: grows logarithmically with input size; f(n) = log(n)
3. linear: grows linearly; f(n) = n
4. linear-logarithmic: f(n) = n log(n)
5. quadratic: f(n) = n^2
6. cubic, quartic, etc.: n^3, n^4, ...
7. exponential: f(n) = 2^n (or 3^n, 4^n, etc.)
8. factorial: f(n) = n!

## What is an Upper Bound?

good online graphing calculator: <https://www.desmos.com/calculator>

Big-Oh only cares about the fastest-growing term because:

- no matter how small a (positive) coefficient it has, it will always outpace
  slower-growing terms after a certain point

**NOTE to Zach**: left off in the middle of this, finish explaining how big-oh
works as an upper bound

