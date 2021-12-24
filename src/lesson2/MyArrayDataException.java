package lesson2;

public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(int i, int j) {
        super("Не числовой формат данных в элементе array[" + i + "][" + j + "]");
    }
}