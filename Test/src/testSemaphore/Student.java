package testSemaphore;

import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Student implements Runnable {

    Random rand = new Random();

    //Определяется порядковый номер студента в очереди
    int turn;
    //Определяется семафор
    Semaphore roomAvailable;

    //В конструкторе передаются кол-во разрешений в семафоре + порядковый номер
    //студента в очереди.
    Student(Semaphore roomAvailable, int turn) {
        this.turn = turn;
        this.roomAvailable = roomAvailable;
    }

    @Override
    public void run() {
        try {
            //Проверяется доступность семафора для потока. Если доступен, студент заходит.
            //Если недоступен, студент=поток ждет доступа.
            roomAvailable.acquire();
            System.out.println("student " + turn + " in");

            //Произвольно определяется время подвисания для каждого потока, чтобы был
            //виден результат выполнения.
            int r = rand.nextInt(5000);
            Thread.sleep(r);
        } catch (InterruptedException e) {
        };

        //После подвисания поток возобновляет работу. Студент выходит из комнаты.
        int randMark = rand.nextInt(3) + 3;
        System.out.println("student " + turn + " out with mark " + randMark);

        try {
            DbUpdate rec = new DbUpdate();
            rec.recordInDb(turn, randMark);
        } catch (SQLException e) {
        }

        roomAvailable.release();

    }

}
