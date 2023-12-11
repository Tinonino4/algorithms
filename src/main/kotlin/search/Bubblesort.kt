package search

/**
 * El algoritmo de ordenación por burbuja es un sencillo algoritmo de ordenación que funciona comparando pares de
 * elementos adyacentes y realizando intercambios si están en el orden incorrecto. Este proceso se repite hasta que no
 * se realizan más intercambios, lo que indica que la lista está ordenada. Aquí tienes una explicación paso a paso:
 * Algoritmo de Ordenación por Burbuja:
 * Inicio: Comienza desde el principio de la lista.
 * Comparación de elementos adyacentes: Compara el primer elemento con el siguiente. Si el primer elemento es mayor que
 * el segundo, intercámbialos.
 * Movimiento a través de la lista: Continúa comparando y realizando intercambios a lo largo de la lista, avanzando de
 * un par a otro.
 * Una pasada completa: Después de una pasada completa a través de la lista, el elemento más grande estará en la última
 * posición.
 * Repetición: Repite estos pasos para el resto de la lista, excluyendo el último elemento que ya está en su posición
 * correcta.
 * Condición de parada: Continúa realizando pasadas a través de la lista hasta que no se realicen intercambios en una
 * pasada completa. En ese momento, la lista estará ordenada.
 */
    var list = arrayOf(1,2,5,6,7,3,2,6,8) //result: 1,2,2,3,5,6,6,7,8

    fun main() {
        var result = bubbleSort(list)
        for (i in 0 until result.size) {
            print(result[i])
        }
    }
    fun bubbleSort(list: Array<Int>): Array<Int> {
        var swapped = true
        while(swapped) {
            swapped = false
            for (i in 0 until list.size - 2) {
                if (list[i] > list[i + 1]) {
                    swap(list, i)
                    swapped = true;
                }
            }
        }

        return list
    }

    private fun swap(list: Array<Int>, i: Int) {
        var x = list[i]
        list[i] = list[i+1]
        list[i+1] = x
    }