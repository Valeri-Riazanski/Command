package com.val.riazanski;

abstract class Command {
    //fields
    private Application app;
    private Editor editor;
    private String backup;
    private int mark;
    private int dot;
    //constructors
    public Command(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
    }
    //methods
    public void saveBackup() {
        backup = editor.getText();
    }
    public void unDo() {
        editor.setText(backup);
    }
    abstract boolean execute();
}

class CopyCommand extends Command {
    //fields
    private Editor editor;
    private Application app;
    private String backup;
    private int mark;
    private int dot;
    //constructors
    public CopyCommand(Application app, Editor editor, int mark, int dot) {
        super(app,editor);
        this.mark = mark;
        this.dot = dot;
    }
    //methods
    @Override
    public boolean execute() {
        app.clipBoard(editor.getSelection(mark, dot));
        return false;
    }
}
class CutCommand extends Command {
    //fields
    Application app;
    Editor editor;
    String backup;
    private int mark;
    private int dot;
    //constructors
    public CutCommand(Application app, Editor editor, int mark, int dot) {
        super(app, editor);
        this.mark = mark;
        this.dot = dot;
    }
    //methods
    @Override
    boolean execute() {
        saveBackup();
        app.clipBoard(editor.getSelection(this.mark, this.dot));
        editor.deleteSelection(this.mark,this.dot);
        return true;
    }
}
class PasteCommand extends Command {
    //fields
    Application app;
    Editor editor;
    String backup;
    private int mark;
    private int dot;
    //constructors
    public PasteCommand(Application app, Editor editor, int mark, int dot) {
        super(app, editor);
        this.mark = mark;
        this.dot = dot;
    }
    //methods
    @Override
    public boolean execute() {
        saveBackup();
        editor.replaceSelection(mark, dot, app.clipBoard(backup)); // 3-rd parametr?
        return true;
    }
}
class UndoCommand extends Command {
    //fields
    Application app;
    Editor editor;
    //constructors
    public UndoCommand(Application app, Editor editor) {
        super(app, editor);
    }
    //methods
    @Override
    public boolean execute() {
        app.unDo();
        return false;   //mb true ?
    }
}
