# Week 3 Notes

## Exceptions

- Throwable
  - Error: very bad, probably can't recover
  - Exception: (checked exceptions) errors that you should deal with and can't always prevent
    - examples: FileNotFoundException
    - RuntimeException: (unchecked exceptions) errors that you can often prevent by writing good code
      or easily verify are impossible
      - examples: ArrayIndexOutOfBoundsException, ArithmeticException, NullPointerException

```java

int[] array = ...;

...

// not good because the array might be shorter than 10 elements
// for (int i = 0; i < 10; i++) {

// better because we will never go out of bounds
for (int i = 0; i < array.length; i++) {
    System.out.println(array[i]);
}

// if we wanted to cap repetitions at 10 and keep the condition fast:
int count = Math.min(10, array.length);
for (int i = 0; i < count; i++) {
    ...
}

```
