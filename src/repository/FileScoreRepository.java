package repository;

import model.scoreInstance;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileScoreRepository implements IScoreRepository {

    @Override
    public void saveScore(int score, String userNickname) throws IOException {
        //If there is "no score", shows error message and returns
        if (score == -1) {
            System.out.println("No score to save.");
            return;
        }

        //Checks if folder titled "score" exists, i not, creates it
        File folder = new File("score");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        //Finds the txt file to save to
        File file = new File(folder, "score.txt");

        //Gets local data and time, formats it
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);

        //tries to write a new line to the txt file containing the score, nickname and timestamp
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(score + " ** " + userNickname + " ** " + timestamp + System.lineSeparator());
        }

        //Informs user of success
        System.out.println("Score saved.");
    }

    @Override
    public List<scoreInstance> loadScore() throws FileNotFoundException {
        //Finds folder and the txt file, in there is no file, gives error message and returns
        File folder = new File("score");
        File file = new File(folder, "score.txt");

        if (!file.exists()) {
            System.out.println("No score file found.");
            return new ArrayList<>();
        }

        //Creates an empty(so far) list of score entries
        List<scoreInstance> entries = new ArrayList<>();

        //Tries to read the file one line at a time, and separates parts by **
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s\\*\\*\\s");

                //If the parts are less than 3 or more, something is worng so gives error
                if (parts.length != 3) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                //Tries to parse number form the txt file to score, if fails, prints error, if success puts score to place 1/3 in the list
                int score;
                try {
                    score = Integer.parseInt(parts[0].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Skipping line with invalid score: " + line);
                    continue;
                }

                //Puts nickname in the place 2/3 of the list, and time at place 3/3
                String nickname = parts[1].trim();
                String timestamp = parts[2].trim();

                entries.add(new scoreInstance(score, nickname, timestamp));
            }
        }

        //Sorts scores so the biggest is on the top
        entries.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));

        return entries;
    }

    //Prints scoreboard for the user
    public void printScore(List<scoreInstance> entries) {
        System.out.println("----- Scoreboard -----");
        if (entries.isEmpty()) {
            System.out.println("No scores yet.");
        } else {
            for (scoreInstance entry : entries) {
                System.out.println(entry);
            }
        }
        System.out.println("-------------------------");
    }

}