package Search

fun linearSearch(array : IntArray, target: Int) : Boolean {
    for (i in 0 until array.size) {
        if (array[i] == target) {
            return true
        }
    }
    return false
}

// Complexidade = O(n), cresce de acordo com o tamanho do array