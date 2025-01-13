package Sort

fun insertionSort(array: Array<Int>): Array<Int>{
	val n = array.size

	for (i in 1 until n){
		val key = array[i]
		var j = i - 1
		while (j >= 0 && array[j] > key){
			array[j + 1] = array[j]
			j--
			array[j + 1] = key
		}
	}

	return array
}
