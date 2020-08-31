package com.val.riazanski;

class Application {
    //fields
    private String text;
    private Editor editor;
    private CommandHistory history;
    private static int mark;
    private static  int dot;
    //constructors
    public Application(Editor editor, String text) {
        this.text = text;
        this.editor = editor;
        history = new CommandHistory();
    }
    //methods
    public void setMark(int mark) {
        this.mark = mark;
    }
    public void setMarkDot(int mark, int dot) {
        this.mark = mark;
        this.dot = dot;
    }
    public void setText(String text) {
        this.text = text;
        editor.setText(text);
    }public String getText() {
        return editor.getText();
    }
    public static String clipBoard(String str) {
        return str;
    }
    public void unDo() {

    }
    public static void main(String[] args) {
        String text = "lwqekfjqwlekfj'qwel;kfjq'w;elfkj;wqe";
        Editor editor = new Editor(text);
        Application app = new Application(editor,text);
        System.out.println(app.getText());
        app.setText("эцущкгтэцузкгщстгэцйзущзкгстэзцущкг");
        System.out.println(app.getText());
        CutCommand cut = new CutCommand(app, editor, 2, 9);
        if (cut.execute()) {
        app.history.push(cut);
        }
        System.out.println(app.history.toString());
        System.out.println(app.getText());
    }


}
