package ru.lyubimov.test.patterns.command.command;

public interface Command {
    void execute();
    void undo();
}
