package com.val.riazanski;

//import javafx.application.Application;

import java.util.ArrayList;
import java.util.Stack;

abstract class Command {
    //fields
    private Application app;
    private Editor editor;
    private Text backup;
    //constructors
    public Command(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
    }
    //methods
    void saveBackup() {
        backup = editor.getText();
    }
    void unDo() {
        editor.setText(backup);
    }
    boolean execute() {
        return false;
    }
}
class CopyCommand extends Command {
    //constructors
    public CopyCommand(Application app, Editor editor) {
        super(app, editor);
    }
    //methods
    public boolean execute() {
        app.clipBoard(editor.getSelection());
        return false;
    }
}
class CutCommand extends Command {
    //constructors
    public CutCommand(Application app, Editor editor) {
        super(app, editor);
    }
    //methods
    public boolean execute() {
        saveBackup();
        app.clipBoard(editor.getSelection());
        return true;
    }
}
class PasteCommand extends Command {
    //constructors
    public PasteCommand(Application app, Editor editor) {
        super(app, editor);
    }
    //methods
    public boolean execute() {
        saveBackup();
        editor.replaceSelection(app.cipBoard());
        return true;
    }
}
class UndoCommand extends Command {
    //constructors
    public UndoCommand(Application app, Editor editor) {
        super(app, editor);
    }
    //methods
    public boolean execute() {
        app.unDo();
        return false;
    }
}
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
class  Editor {
    //fields
    private StringBuilder text;
    //constructors
    public Editor(StringBuilder text) {
        this.text = text;
    }
    //methods
    public StringBuilder getSelection() {
        return new StringBuilder("selection of text");
    }
    public void deleteSelection() {
    }
    public void replaceSelection(StringBuilder text) {
    }
}
class Application {
    //fields
    private String clipBoard;
    private ArrayList<Editor> editors;
    private Editor activeEditor;
    private CommandHistory history;
    //constructors
    public Application() {}
    //methods
    public void createUI() {

    }

}

