# Queue Notes

## Implementation Challenges

stack was easy because we only operated on one end of the array or node chain

queue has to operate on both ends: add to one, remove from the other

solution: circular array

- track front and back
- wrap back around to start of the array instead of shifting to keep the front of the
  queue at the start of the array
- keep an empty space or track the size in addition to front/back index to distinguish
  between full and empty queue



