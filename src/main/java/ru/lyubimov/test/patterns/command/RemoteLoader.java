package ru.lyubimov.test.patterns.command;

import ru.lyubimov.test.patterns.command.command.LightOffCommand;
import ru.lyubimov.test.patterns.command.command.LightOnCommand;
import ru.lyubimov.test.patterns.command.command.StereoOffCommand;
import ru.lyubimov.test.patterns.command.command.StereoOnWihCDCommand;
import ru.lyubimov.test.patterns.command.reciver.Light;
import ru.lyubimov.test.patterns.command.reciver.Stereo;

public class RemoteLoader {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Stereo stereo = new Stereo();
        StereoOnWihCDCommand stereoOnWihCDCommand = new StereoOnWihCDCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        remoteControl.setCommand(0, lightOnCommand, lightOffCommand);
        remoteControl.setCommand(1, stereoOnWihCDCommand, stereoOffCommand);

        remoteControl.onButtonWasPushed(0);
        remoteControl.undoButtonPushed();
        remoteControl.onButtonWasPushed(1);

        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonPushed();
        remoteControl.offButtonWasPushed(1);
        remoteControl.undoButtonPushed();
    }
}
