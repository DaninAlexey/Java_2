package lesson2;

public class TestEexepLesson2 {

    public static void main(String[] args) {

        String[][] str = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};

        try {
            testSize(str);
            int sum = testSum(str);
            System.out.println("Сумма элементов равна " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static void testSize(String[][] array) {
        if (array.length != 4)
            throw new MyArraySizeException();
        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4)
                throw new MyArraySizeException();
        }
    }

    public static int testSum(String[][] array) {
        int sum = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        return sum;
    }
}
