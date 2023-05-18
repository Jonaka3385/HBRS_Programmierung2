package iterator_classes;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

import java.util.Iterator;

public class SnakeIterator2DArray<T> implements Iterator<T> {
    private final T[][] array;
    private final int numRows;
    private final int numCols;
    private int currentRow;
    private int currentCol;
    private boolean isMovingRight;

    @Contract(pure = true)
    public SnakeIterator2DArray(T @NotNull [][]array) {
        this.array = array;
        this.numRows = array.length;
        this.numCols = array[0].length;
        this.currentRow = 0;
        this.currentCol = 0;
        this.isMovingRight = true;
    }

    @Override
    public boolean hasNext() {
        return currentRow < numRows;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T element = array[currentRow][currentCol];

        if (isMovingRight) {
            if (currentCol == numCols - 1) {
                currentRow++;
                isMovingRight = false;
            } else {
                currentCol++;
            }
        } else {
            if (currentCol == 0) {
                currentRow++;
                isMovingRight = true;
            } else {
                currentCol--;
            }
        }

        return element;
    }
}
