package ru.lyubimov.test.patterns.command.command;

import ru.lyubimov.test.patterns.command.reciver.Stereo;

public class StereoOffCommand implements Command{
    private Stereo stereo;

    public StereoOffCommand(Stereo stereo){
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
    }
}
