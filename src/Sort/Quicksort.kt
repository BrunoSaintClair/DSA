package DataStructures.Sort

fun quicksort(array: IntArray, low: Int = 0, high: Int = array.size -1){
    if (low >= high) {
        return
    }

    val pivotIdx = partition(array, low, high)
    quicksort(array, low, pivotIdx - 1)
    quicksort(array, pivotIdx + 1, high)
}

fun partition(array: IntArray, low: Int = 0, high: Int = array.size - 1): Int {
    val pivot = array[high]
    var idx = low - 1

    for (i in low until high) {
        if (array[i] <= pivot) {
            idx++
            val tmp = array[i]
            array[i] = array[idx]
            array[idx] = tmp
        }
    }
    idx++
    array[high] = array[idx]
    array[idx] = pivot
    return idx
}
