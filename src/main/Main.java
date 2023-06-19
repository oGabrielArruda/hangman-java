package main;

import java.util.Scanner;

import manager.QuestManager;
import manager.QuestRandomizer;
import model.Quest;

public class Main {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        QuestManager qm = new QuestManager();
        for (;;) {
            System.out.println("word:");
            String word = myObj.nextLine();

            System.out.println("hint:");
            String hint = myObj.nextLine();

            Quest quest = new Quest(word, hint);
            qm.save(quest);

            Quest random = QuestRandomizer.selectRandomQuest();
            System.out.println("The random quest is: " + random.getWord() + "; " + random.getHint());
        }
    }
}
