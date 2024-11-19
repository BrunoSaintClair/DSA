package Search

fun binarySearch(array: IntArray, target: Int): Int {
    var low = 0
    var high = array.size - 1

    while (low <= high) {
        val middleIdx = low + (high - low) / 2  // como é uma divisão entre inteiros, no Kotlin o resultado é arredondado
        val middleItem = array[middleIdx]

        if (middleItem == target) {
            return middleIdx
        } else if (middleItem < target) {
            low = middleIdx + 1
        } else {
            high = middleIdx - 1
        }
    }
    return -1
}

/*
Complexidade: O(log n), pois divide o intervalo de pesquisa pela metade a cada iteração.
Consiste em dividir a lista repetidamente em duas partes, eliminando metade a cada passo até encontrar o elemento
Se o input reduz pela metade a cada passo, então é O(log n) ou O(*log n)
Serve como base para outros algoritmos de busca
Sempre se perguntar, o array está ordenado?
*/
