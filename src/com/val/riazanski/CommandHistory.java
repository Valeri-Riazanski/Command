package com.val.riazanski;

import java.util.Stack;

class  CommandHistory {
    //fields
    private Stack<Command> history;
    //constructors
    public CommandHistory() {
        this.history = new Stack<Command>();
    }
    //methods
    public void push(Command command) {
        this.history.push(command);
    }
    public void pop() {
        this.history.pop();
    }
}