# List Notes

## Unordered

- elements are internally stored in an array, so they technically have an order
- the interface, however, makes no promises about how they'll be ordered
- we also don't let the user access elements by index
- from the user's side, looking at the interface, the list elements have no order

two main operations, simplest implementation:

- add: place new element at the end of the list
- remove: replace removed element with the last element of the list

example:

starting list: 1, 4, 11, 100

add 5, then 7

list after adding: 1, 4, 11, 100, 5, 7

remove 4

list after removing: 1, 7, 11, 100, 5

remove 11, then 5

list after removing: 1, 7, 100

## Memory Layout

example list: 1, 4, 11, 100

- data: 1, 4, 11, 100, 1, 2, 3, 100, 0, 0
- size: 4
- capacity: 10



