# tracing mergesort

          0   1  2   3  4
array = { 5, 11, 0, -3, 1 }

sort(array, start = 0, end = 5):
    sort(array, start = 0, end = 2)
        sort(array, start = 0, end = 1)
            return;
        sort(array, start = 1, end = 2)
            return;
        merge(array, start = 0, end = 2)
            first half:  5
            second half: 11
            merged: 5, 11
    sort(array, start = 2, end = 5)
        sort(array, start = 2, end = 3)
            return
        sort(array, start = 3, end = 5)
            sort(array, start = 3, end = 4)
                return;
            sort(array, start = 4, end = 5)
                return;
            merge(array, start = 3, end = 5)
                first half: -3
                second half: 1
                merged: -3, 1
        merge(array, start = 2, end = 5)
            first half: 0
            second half: -3, 1
            merged: -3, 0, 1
            array = { 5, 11, -3, 0, 1 }
    merge(array, start = 0, end = 5)
        first half: 5, 11
        second half: -3, 0, 1
        merged: -3, 0, 1, 5, 11
        array = { -3, 0, 1, 5, 11 }

# sort of visualizing mergesort

round 1 = { 5, 11, 0, -3, 1 }
round 2 = { 5, 11 } { 0, -3, 1 }
round 3 = { 5 } { 11 } { 0 } { -3, 1 }
round 4 =                    { -3 } { 1 }
merge 1 =                    { -3, 1 }
merge 2 = { 5, 11 } { -3, 0, 1 }
merge 3 = { -3, 0, 1, 5, 11 }

# sort of visualizing quicksort

round 1 = { 5, 11, 0, -3, 1 }
        pivot = 5
        left = 1, -3, 0
        right = 11
round 2 = { 1, -3, 0 }, 5, { 11 }
round 2 left
        pivot = 1
        left = 0, -3
        right = nothing
round 2 right
        nothing to do, size is 1
round 3 = { 0, -3 }, 1, 5, 11 
round 3 left's left
        pivot = 0
        left = -3
        right = nothing
round 3 left's right
        nothing to do, size is 0
round 4 = { -3 }, 0, 1, 5, 11
