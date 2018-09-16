package ru.lyubimov.test.patterns.command.command;

public class NoCommand implements Command{
    @Override
    public void execute() {
        System.out.println("There is no command");
    }

    @Override
    public void undo() {
        System.out.println("There is no command");
    }
}
