package polynom;

/**
 * Created by Olga on 10.02.2017.
 Написать программу для вычисления многочлена с использованием собственного семафора.
 1) Вид многочлена- а^3 + b^2 + c
 2) Использовать для вычисления куба, квадрата и c- отдельные классы
 3) Результат выводить в режиме реального времени в класс потребитель (Consumer). Использовать его функцию с 3мя аргументами met(int kube, int kvadro, int simple)
 3.1) Если функцию Consumer-а вызывает Кубатор- то он передает в нее такие аргументы (число, 0, 0)
 3.2) Если функцию Consumer-а вызывает Квадратор- то он передает в нее такие аргументы (0, число, 0)
 3.3) Если функцию Consumer-а вызывает Простатор- то он передает в нее такие аргументы (0, 0, число)
 4) Условие семафора- допускается одновременный вызов метода Consumer-а РАЗНЫМИ классами
 4.1) Пример: Кубатор, Квадратор параллельно- можно
 4.2) Пример: Кубатор, Кубатор- нельзя
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphor[] semaphors = { new Semaphor() };
        int[] ints = {1, 2, 3};
        Thread[] threads = new Thread[6];
        threads[0] = new Thread(new Cube(ints, semaphors));
        threads[1] = new Thread(new Cube(ints, semaphors));
        threads[2] = new Thread(new Square(ints, semaphors));
        threads[3] = new Thread(new Square(ints, semaphors));
        threads[4] = new Thread(new Simple(ints, semaphors));
        threads[5] = new Thread(new Simple(ints, semaphors));

        for (Thread th:threads) {
            th.start();
        }

        for (Thread th:threads) {
            th.join();
        }

        System.out.println( semaphors[0].getSum());
    }




}
