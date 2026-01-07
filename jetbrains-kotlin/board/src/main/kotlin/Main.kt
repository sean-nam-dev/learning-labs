package org.example

fun main() {

}

fun createSquareBoard(width: Int): SquareBoard = Board(width)
fun <T> createGameBoard(width: Int): GameBoard<T> = TODO()

data class Cell(val i: Int, val j: Int) {
    override fun toString()= "($i, $j)"
}

enum class Direction {
    UP, DOWN, RIGHT, LEFT;

    fun reversed() = when (this) {
        UP -> DOWN
        DOWN -> UP
        RIGHT -> LEFT
        LEFT -> RIGHT
    }
}

interface SquareBoard {
    val width: Int

    fun getCellOrNull(i: Int, j: Int): Cell?
    fun getCell(i: Int, j: Int): Cell

    fun getAllCells(): Collection<Cell>

    fun getRow(i: Int, jRange: IntProgression): List<Cell>
    fun getColumn(iRange: IntProgression, j: Int): List<Cell>

    fun Cell.getNeighbour(direction: Direction): Cell?
}

interface GameBoard<T> : SquareBoard {

    operator fun get(cell: Cell): T?
    operator fun set(cell: Cell, value: T?)

    fun filter(predicate: (T?) -> Boolean): Collection<Cell>
    fun find(predicate: (T?) -> Boolean): Cell?
    fun any(predicate: (T?) -> Boolean): Boolean
    fun all(predicate: (T?) -> Boolean): Boolean
}

class Board(override val width: Int, ) : SquareBoard {
    val array = Array(width) { i ->
        Array(width) { j ->
            Cell(i + 1, j + 1)
        }
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? {
        return if (i in 1..width && j in 1..width) {
            getCell(i, j)
        } else {
            null
        }
    }

    override fun getCell(i: Int, j: Int): Cell {
        return array[i - 1][j - 1]
    }

    override fun getAllCells(): Collection<Cell> = array.flatten()

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        TODO("Not yet implemented")
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        TODO("Not yet implemented")
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        TODO("Not yet implemented")
    }

    private fun checkBounds(i: Int, j: Int): Boolean =
        i in 1..width && j in 1..width
}