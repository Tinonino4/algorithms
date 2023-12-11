package nqueens

/**
 * N queens problem
 * The eight queens puzzle is the problem of placing eight chess queens on an 8×8
 * chessboard so that no two queens threaten each other;
 * thus, a solution requires that no two queens share the same row, column, or diagonal.
 * */

const val nQueens = 8

fun main() {
    val solutions = solveNQueens()
    printSolutions(solutions)
}

fun solveNQueens(): List<List<String>> {
    var solutions = mutableListOf<List<String>>()
    val chessBoard= Array(nQueens) { CharArray(nQueens) {'X'} }
    backtrack(0, chessBoard, solutions)
    return solutions
}

fun backtrack(row: Int, chessBoard: Array<CharArray>, solutions: MutableList<List<String>>) {
    if (row == chessBoard.size) {
        solutions.add(chessBoard.map { String(it) })
        return
    }; // Finished!

    for (col in chessBoard.indices) {
        if (isSafeForQueen(row, col, chessBoard)) {
            chessBoard[row][col] = 'Q'
            backtrack(row + 1, chessBoard, solutions)
            chessBoard[row][col] = 'X' // No solution, get back
        }
    }
}

fun isSafeForQueen(row: Int, col: Int, chessBoard: Array<CharArray>): Boolean {
    // check if there is a queen in the row
    for (i in 0 until  row) {
        if (chessBoard[i][col] == 'Q') return false
    }
    //check for queens in the upper left diagonal
    for (i in row -1 downTo 0) {
        val j = row - i + col
        if (j >= 0 && j < chessBoard.size && chessBoard[i][j] == 'Q') return false
    }
    //check for queens in the upper right diagonal
    for (i in row - 1 downTo 0) {
        val j = col - (row - i)
        if (j >= 0 && j < chessBoard.size && chessBoard[i][j] == 'Q') return false
    }
    return true
}

fun printSolutions(solutions: List<List<String>>) {
    for (solution in solutions) {
        for (row in solution) {
            println(row)
        }
        println()
    }
    println("Number of solutions: ${solutions.size}")
}
