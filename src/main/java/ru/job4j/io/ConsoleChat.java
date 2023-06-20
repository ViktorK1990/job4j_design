package ru.job4j.io;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

    public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private boolean turnOn = true;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        List<String> list = new ArrayList<>();
        if(text.equals(OUT)) {
           System.out.println("Exit");
           return;
        }
        if(text.equals(STOP)) {
            turnOn = false;
            System.out.println("Bot is turned OFF");
            list.add("Bot is turned OFF");
            list.add(text);
            saveLog(list);
            run();
        }
        if(text.equals(CONTINUE)) {
            turnOn = true;
            list.add("Bot is turned ON");
            System.out.println("Bot is turned ON");
            list.add(text);
            list.add(readPhrases().get(new Random().nextInt(readPhrases().size() -1)));
            System.out.println(readPhrases().get(new Random().nextInt(readPhrases().size() -1)));
            saveLog(list);
            run();
        }
        else {
            if(turnOn) {
                list.add(text);
                list.add(readPhrases().get(new Random().nextInt(readPhrases().size() -1)));
                System.out.println(readPhrases().get(new Random().nextInt(readPhrases().size() -1)));
                saveLog(list);
                run();
            }
            else {
                list.add(text);
                saveLog(list);
                run();
            }
        }
        }


    private List<String> readPhrases() throws IOException {
        Path answers = Path.of(botAnswers);
        String text = Files.readAllLines(answers).toString();
        return List.of(text.split(","));
    }

    private void saveLog(List<String> log) throws FileNotFoundException {
    File file = new File(path);
    PrintWriter pw = new PrintWriter(file);
    for (String e : log) {
        pw.println(e);
    }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("C:/projects/job4j_design/data/dialog.txt", "C:/projects/job4j_design/data/BotAnswers.txt");
        cc.run();
    }
}