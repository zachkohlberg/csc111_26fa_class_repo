# Generics Notes

Problem: we need to use our data structure with multiple element types
throughout our program.

We'll use Box to demo this, but it might help to imagine the amount of work
required if you were doing this with a stack or a more complex data structure.

## Solution 1: Multiple Types

```java
class IntBox {
    int value;
}

class CharBox {
    char value;
}

class StringBox {
    String value;
}
```

## Solution 2: No Type Checking

```java
class Box {
    Object value;
}
```

## Solution 3: Generics

```java
class Box<T> {
    T value;
}

Box<String> b1 = new Box<>("hello");
Box<Integer> b2 = new Box<>(5);
```


