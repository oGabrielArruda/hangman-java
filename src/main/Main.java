package main;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import Menu.MenuFrame;
import Constants.Constants;

public class Main {
    public static void main(String[] args) {
        // open the menu
        new MenuFrame();

        // plays the background music
        playBackgroundSong(Constants.SONG_PATH);
    }

    public static void playBackgroundSong(String audioFilePath) {
        try {
            // Create an AudioInputStream from the audio file
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(audioFilePath));

            // Get the audio format of the audio file
            AudioFormat format = audioStream.getFormat();

            // Create a DataLine.Info object for the SourceDataLine
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

            // Open the SourceDataLine
            final SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);
            audioLine.open(format);

            // Create a buffer to read the audio data
            byte[] buffer = new byte[4096];
            final int[] bytesRead = new int[1];

            // Start playing the audio in a separate thread
            Thread audioThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // Start the SourceDataLine
                        audioLine.start();

                        // Read the audio data and write it to the SourceDataLine buffer
                        while ((bytesRead[0] = audioStream.read(buffer)) != -1) {
                            audioLine.write(buffer, 0, bytesRead[0]);
                        }

                        // Clean up resources
                        audioStream.close();
                        audioLine.drain();
                        audioLine.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            audioThread.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
