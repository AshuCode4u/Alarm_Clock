import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock implements Runnable{

    private final LocalTime alarmTime;
    private final String filePath;
    private final Scanner scanner;

    AlarmClock (LocalTime alarmTime,  String filePath,  Scanner scanner){

        this.alarmTime = alarmTime;
        this.filePath = filePath;
        this.scanner = scanner;
    }

    @Override
    public void run(){

        while(LocalTime.now().isBefore(alarmTime)){
            try {

                Thread.sleep(1000);

                LocalTime now = LocalTime.now();

                int hours = now.getHour();
                int minutes = now.getMinute();
                int seconds = now.getSecond();

                System.out.printf("\r%02d:%02d:%02d",
                        now.getHour(),
                        now.getMinute(),
                        now.getSecond());
            }
            catch (InterruptedException e) {
                System.out.println("AlarmClock thread interrupted");
            }
        }

        System.out.println("\n*BEEP*");
        playSound(filePath);
    }
    private void playSound(String filePath){

        File audioFile = new File(this.filePath);

        try(AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            System.out.println("Press *ENTER* to Stop The Alarm");
            scanner.nextLine();
            clip.stop();
            scanner.close();

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Audio file not supported");

        } catch (IOException e) {
            System.out.println("Something went wrong");

        } catch (LineUnavailableException e) {
            System.out.println("Line not available");
        }
    }
}
