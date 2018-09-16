package ru.lyubimov.test.patterns.command.reciver;

public class Stereo {

    public void on(){
        System.out.println("Stereo on.");
    }

    public void off() {
        System.out.println("Stereo off.");
    }

    public void setCD() {
        System.out.println("Setting the CD");
    }

    public void setVolume(int volume) {
        System.out.println("Volume changed to " + volume);
    }

    public void setDVD() {
        System.out.println("Setting the DVD");
    }

    public void setRadio() {
        System.out.println("Setting the radio");
    }
}
