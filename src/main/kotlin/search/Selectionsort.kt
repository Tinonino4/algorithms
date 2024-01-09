package search

/**
 * El algoritmo de ordenación por selección (Selection Sort) es un algoritmo sencillo y directo que funciona dividiendo
 * la lista original en dos partes: la parte ordenada y la parte no ordenada.
 * En cada iteración, se busca el elemento más pequeño de la parte no ordenada y se intercambia con el primer
 * elemento de la parte no ordenada.
 * Pasos del Algoritmo:
 * 1. Inicialización: Se inicia con toda la lista considerando que la parte ordenada está vacía.
 * 2. Búsqueda del Mínimo: Se busca el elemento mínimo en la parte no ordenada de la lista.
 * 3. Intercambio: Se intercambia el elemento mínimo con el primer elemento no ordenado.
 * 4. Expansión de la Parte Ordenada: El elemento recién intercambiado se considera parte de la sección ordenada.
 * La parte ordenada crece en cada iteración.
 * 5. Repetición: Se repiten los pasos 2-4 hasta que la lista esté completamente ordenada.
*/
var selectionList = arrayOf(1,2,5,6,7,3,2,6,8) //result: 1,2,2,3,5,6,6,7,8

    fun main() {
        var result = selectionSort(selectionList)
        for (i in 0 until result.size) {
            print(result[i])
        }
    }
    fun selectionSort(list: Array<Int>): Array<Int> {
        if (list.size <= 1 ) return list
        for (i in 0..list.size - 1) {
            var minIndex = i
            for (j in (i + 1)..<list.size) {
                if (list[j] < list[minIndex]) {
                    minIndex = j
                    var value = list[i]
                    list[i] = list[minIndex]
                    list[minIndex] = value
                }
            }
        }
        return list
    }