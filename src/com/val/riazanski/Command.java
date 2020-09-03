package com.val.riazanski;

abstract class Command {
    private Editor editor;
    private String backup;

    //constructors
    public Command(Application app, Editor editor, int mark, int dot) {
        //fields
        this.editor = editor;
    }
    //methods
    public void saveBackup() {
        backup = editor.getText();
    }
    public String getBackup() {
        return this.backup;
    }
    public void unDo() {
        editor.setText(backup);
    }
    abstract boolean execute();
}

class CopyCommand extends Command {
    //fields
    private final Editor editor;
    private Application app;
    private int mark;
    private int dot;
    //constructors
    public CopyCommand(Application app, Editor editor, int mark, int dot) {
        super(app,editor, mark, dot);
        this.app = app;
        this.editor = editor;
        this.mark = mark;
        this.dot = dot;
    }
    //methods
    @Override
    public boolean execute() {
        app.setClipboard(editor.getSelection(mark, dot));
        return false;
    }
}
class CutCommand extends Command {
    //fields
    private Application app;
    private Editor editor;
    private String backup;
    private int mark;
    private int dot;
    //constructors
    public CutCommand(Application app, Editor editor, int mark, int dot) {
        super(app,editor, mark, dot);
        this.app = app;
        this.editor = editor;
        this.mark = mark;
        this.dot = dot;
    }
    //methods
    @Override
    boolean execute() {
        saveBackup();
        app.setClipboard(editor.getSelection(this.mark, this.dot));
        editor.deleteSelection(this.mark, this.dot);
        return true;
    }
}
class PasteCommand extends Command {
    //fields
    private Application app;
    private Editor editor;
    private String backup;
    private int mark;
    private int dot;
    //constructors
    public PasteCommand(Application app, Editor editor, int mark, int dot) {
        super(app,editor, mark, dot);
        this.app = app;
        this.editor = editor;
        this.mark = mark;
        this.dot = dot;
    }
    //methods
    @Override
    public boolean execute() {
        saveBackup();
        editor.replaceSelection(mark, dot, app.getClipboard());
        return true;
    }
}
class UndoCommand extends Command {
    //fields
    private Application app;
    private Editor editor;
    private int mark;
    private int dot;
    //constructors
    public UndoCommand(Application app, Editor editor, int mark, int dot) {
        super(app,editor, mark, dot);
        this.app = app;
        this.editor = editor;
        this.mark = mark;
        this.dot = dot;
    }
    //methods
    @Override
    public boolean execute() {
        super.unDo();     // realisation ???
        return false;   //mb true ?
    }
}
