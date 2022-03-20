package hello.servlet.AconfirmTest;

import java.time.LocalDateTime;

public class LocalDateTest {
    private static LocalDateTime time;
    public static void main(String[] args) {
        time = LocalDateTime.now();
        System.out.println("time = " + time);

    }
}
