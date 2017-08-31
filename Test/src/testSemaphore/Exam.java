package testSemaphore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Exam {

    void exam() throws SQLException {

        //Кол-во студентов всего
        final int N = 5;
        //Максимальное кол-во студентов, которые одновременно могут быть в комнате
        final int MAX_STUDENTS = 2;
        //Создан семафор с укзанием кол-ва разешений доступа к комнате.
        Semaphore roomAvailable = new Semaphore(MAX_STUDENTS);
        //В цикле создается N студентов, каждому передается кол-во доступов в семафоре
        //+ каждый поток-студент запускаются на выполнение
        for (int i = 0; i < N; i++) {
            Student stud = new Student(roomAvailable, i + 1);
            Thread s = new Thread(stud);
            s.start();
        }

    }

}
