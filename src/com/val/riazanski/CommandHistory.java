package com.val.riazanski;

import java.util.Stack;

class  CommandHistory {
    //fields
    private final Stack<Command> history;
    private final Stack<String> historyBackup;
    //constructors
    public CommandHistory() {
        this.history = new Stack<>();
        this.historyBackup = new Stack<>();
    }
    //methods
    public void push(Command command) {
        this.history.push(command);
    }
    public Command pop() {
        return history.pop();
    }
    public void pushBackup(Command command) {
        this.historyBackup.push(command.getBackup());
    }
    public String popBackup() {
        return historyBackup.pop();
    }
    public int stackSize() {
        return this.history.size();
    }
}