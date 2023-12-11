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
    println("N queens problem start:")
    val chessBoard= Array(nQueens) { CharArray(nQueens) {'.'} }
    var solutions = mutableListOf<List<String>>()
    backtrack(0, chessBoard, solutions)
    return solutions
}

fun backtrack(col: Int, chessBoard: Array<CharArray>, solutions: MutableList<List<String>>) {
    if (col >= chessBoard.size) {
        solutions.add(chessBoard.map { String(it) })
        return
    }; // Finished!

    for (i in 0..< nQueens) {
        if (isSafeForQueen(i, col, chessBoard)) {
            chessBoard[i][col] = 'Q'
            backtrack(col + 1, chessBoard, solutions)
            chessBoard[i][col] = '.' // No solution, get back
        }
    }
}

fun isSafeForQueen(row: Int, col: Int, chessBoard: Array<CharArray>): Boolean {
    for (i in 0..< col) {
        if (chessBoard[row][i] == 'Q') { // check if there is a queen in the row
            return false
        }
        if (row - i >= 0 && chessBoard[row-i][col-i] == 'Q') return false
        if ((row - i >= 0) && (col + i < nQueens) && chessBoard[row-i][col+i] == 'Q') return false
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
