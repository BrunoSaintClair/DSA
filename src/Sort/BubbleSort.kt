package Sort

fun bubbleSort(arr: IntArray) {
    for (i in 0 until arr.size - 1) {
        for (j in 0 until arr.size - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}

/*
Complexidade: O(n²)
Um array ordenado é basicamente: x[i] < x[i + 1]
Em uma iteração com o bubble sort o último elemento do array sempre vai ser o maior,
então na próxima iteração, não precisa checar o último elemento.

Descobrir a soma entre todos os valores em um intervalo n: n+1 * n/2
*/