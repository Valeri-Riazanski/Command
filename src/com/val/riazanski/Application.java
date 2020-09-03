package com.val.riazanski;

class Application {
    //fields
    private final Editor editor;
    private final CommandHistory history;
    private String clipboard ="";
    //constructors
    public Application(Editor editor) {
        this.editor = editor;
        history = new CommandHistory();
    }
    //methods
    public void setText(String text) {
        editor.setText(text);
    }
    public void setClipboard(String str) {
        this.clipboard = str;
    }
    public String getClipboard() {
        return this.clipboard;
    }
    public String getText() {
        return editor.getText();
    }
    public void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
            history.pushBackup(command);
        }
    }
    public void unDo() {
        Command command = history.pop();
        //System.out.println("undo " + command.getBackup());
        if (command != null) {
            String str = history.popBackup();
            this.editor.setText(str);
            //command.unDo();
        }

    }
    public static void main(String[] args) {
        String text = "lwqekfjqwlekfj'qwel;kfjq'w;elfkj;wqe";
        Editor editor = new Editor(text);
        Application app = new Application(editor);
        System.out.println(app.getText());
        app.setText("результат работы команды COPY проверяем в текстовом окне");
        System.out.println(app.getText());
        CutCommand cut = new CutCommand(app, editor, 3,7);
        System.out.println("stackSize= " + app.history.stackSize() + " "  + app.getText());
        app.executeCommand(cut);
        System.out.println("stackSize= " + app.history.stackSize() + " "  + app.getText());
        app.executeCommand(cut);
        System.out.println("stackSize= " + app.history.stackSize() + " "  + app.getText());
        app.executeCommand(cut);
        System.out.println("stackSize= " + app.history.stackSize() + " "  + app.getText());
        app.unDo();
        System.out.println("stackSize= " + app.history.stackSize() + " "  + app.getText());
        app.unDo();
        System.out.println("stackSize= " + app.history.stackSize() + " "  + app.getText());
        app.unDo();
        System.out.println("stackSize= " + app.history.stackSize() + " "  + app.getText());

    }


}
