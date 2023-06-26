package manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Constants.Constants;
import Popup.PopupFrame;
import model.Quest;

public class QuestRandomizer {
    public static Quest selectRandomQuest() {
        List<Quest> questItems = readQuestItems();
        if (questItems.isEmpty()) {
            new PopupFrame("Error", "No quests found!");
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(questItems.size());
        return questItems.get(randomIndex);
    }

    private static List<Quest> readQuestItems() {
        List<Quest> questItems = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(Constants.QUESTS_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    String word = parts[0].trim();
                    String clue = parts[1].trim();
                    Quest quest = new Quest(word, clue);
                    questItems.add(quest);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the quests file: " + e.getMessage());
        }

        return questItems;
    }
}