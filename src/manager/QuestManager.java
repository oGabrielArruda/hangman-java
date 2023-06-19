package manager;

import java.io.FileWriter;
import java.io.IOException;

import model.Quest;

public class QuestManager {
    public static final String QUESTS_FILE_PATH = "./files/quests.txt";

    public void save(Quest quest) {
        try {
            String word = quest.getWord(); 
            String clue = quest.getClue();

            FileWriter fileWriter = new FileWriter(QUESTS_FILE_PATH, true);
            fileWriter.write(word + ";" + clue + "\n");
            fileWriter.close();
            System.out.println("Quest saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the quest: " + e.getMessage());
        }
    }
}
