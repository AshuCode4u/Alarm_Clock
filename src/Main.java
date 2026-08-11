import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {

        // Alarm Clock Project

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmtime = null;
        String filePath = "Audio/No One Here Gets In Alive - National Sweetheart.wav";

        while (alarmtime == null) {
            try {
                System.out.print("Enter an Alarm Time (HH:MM:SS): ");
                String inputTime = scanner.nextLine();

              LocalTime parsedTime = LocalTime.parse(inputTime, timeFormatter);
                LocalTime now = LocalTime.now();

                if (parsedTime.isBefore(now)) {
                    System.out.println("Alarm Time is before Now");
                }else {
                    alarmtime = parsedTime;
                    System.out.println("Alarm set for: " + alarmtime);
                }

            }
            catch (DateTimeParseException e) {
                System.out.println("Please enter alarm time in (HH:MM:SS) format!");
            }
        }

            AlarmClock alarmClock = new AlarmClock(alarmtime, filePath, scanner);
            Thread alarmThread = new Thread(alarmClock);
            alarmThread.start();

    }
}
