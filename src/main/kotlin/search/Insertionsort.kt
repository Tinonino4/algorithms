package search

/**
 * El algoritmo de ordenación por inserción es otro algoritmo simple pero eficaz para ordenar elementos en una lista.
 * Funciona construyendo una secuencia ordenada de elementos uno por uno, tomando cada elemento de la lista e
 * insertándolo en su posición correcta. Aquí tienes una explicación paso a paso:
 * Algoritmo de Ordenación por Inserción:
 * Inicio: Comienza con el segundo elemento de la lista (índice 1) y considera que ese elemento está "insertado" en la lista ordenada.
 * Comparación e Inserción: Compara el elemento actual con los elementos anteriores en la lista ordenada. Desplaza los elementos mayores hacia la derecha y coloca el elemento actual en su posición correcta.
 * Repetición: Repite este proceso para cada elemento de la lista, ampliando la lista ordenada en un elemento en cada iteración.
 * Condición de parada: Cuando todos los elementos han sido insertados en la lista ordenada, la lista completa estará ordenada.
 */
var insertionList = arrayOf(1,2,5,6,7,3,2,6,8) //result: 1,2,2,3,5,6,6,7,8

    fun main() {
        var result = insertionSort(insertionList)
        for (i in 0 until result.size) {
            print(result[i])
        }
    }
    fun insertionSort(list: Array<Int>): Array<Int> {
        if (list.size <= 1 ) return list
        for (i in 1..list.size-1) {
            sortPrev(list, i)
        }
        return list
    }

private fun sortPrev(list: Array<Int>, i: Int) {
    var value = list[i]
    // println("value: ${value}")
    var j = i - 1
    // println("j: ${j}")
    while (j >= 0 && list[j] > value) {
        list[j + 1] = list[j]
        j--
    }
    list[j + 1] = value
}