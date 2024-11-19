package Search

fun binarySearch(array: IntArray, target: Int): Int {
    var low = 0
    var high = array.size - 1
    var middle: Int

    while (low <= high) {
        middle = low + (high - low) / 2  // como é uma divisão entre inteiros, no Kotlin o resultado é arredondado

        if (array[middle] == target) {
            return middle
        } else if (array[middle] < target) {
            low = middle + 1
        } else {
            high = middle
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
