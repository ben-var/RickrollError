package views;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class ErrorView {

    private static String arg;

    public static void displayError(){
        picture();
    }

    private static void audio()
    {
        try {
            File file = new File("doc/rickroll.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            System.err.println("Put the music.wav file in the sound folder if you want to play background music, only optional!");
        }
    }

    private static void picture()
    {
        Icon icon = new ImageIcon("doc/rickroll.gif");
        JLabel label = new JLabel(icon);

        JFrame f = new JFrame("Error!");
        f.getContentPane().add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        audio();
    }
}