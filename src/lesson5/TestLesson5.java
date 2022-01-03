package lesson5;

public class TestLesson5 {

    static final int size = 10000000;
    static final int h = 5000000;

    public static void main(String[] args) throws InterruptedException {
        calculationInOneTread();
        calculationInTwoTread();
    }

    private static void calculationInOneTread() {

        float[] arr = new float[size];
        for (int i = 0; i < size; i++)
            arr[i] = 1;

        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//      Выборочная проверка идентичности результатов работы методов.
//      System.out.println(arr[8234567]);
        System.out.println(System.currentTimeMillis() - a + " миллисекунд - время выполнения первого метода");
    }

    private static void calculationInTwoTread() throws InterruptedException {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++)
            arr[i] = 1;

        long a = System.currentTimeMillis();
        float[] arr1 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        float[] arr2 = new float[h];
        System.arraycopy(arr, h, arr2, 0, h);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < h; i++)
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < h; i++)
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
//      Выборочная проверка идентичности результатов работы методов.
//      System.out.println(arr[8234567]);
        System.out.println(System.currentTimeMillis() - a + " миллисекунд - время выполнения второго метода");
    }

}
