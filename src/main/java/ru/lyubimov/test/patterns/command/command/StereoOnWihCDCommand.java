package ru.lyubimov.test.patterns.command.command;

import ru.lyubimov.test.patterns.command.reciver.Stereo;

public class StereoOnWihCDCommand implements Command {
    Stereo stereo;

    public StereoOnWihCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
