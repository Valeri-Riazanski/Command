package com.val.riazanski;

import javax.swing.*;
import javax.swing.text.*;

public class EditorPlus extends JFrame {
    //fields
    private static final long serialVersionUID = 1L;
    private static JTextArea text;
    private static Caret caret;
    //constructors
    public EditorPlus(String str) {
        super("editor+ ver " + serialVersionUID);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Многострочное текстовое поле
        text = new JTextArea();
        // Вставка текст
        text.append(str);
        // Создание курсора
        caret = text.getCaret();
        caret.setBlinkRate(1);
        // Размещение текстового поля в интерфейсе окна
        getContentPane().add(new JScrollPane(text));
        // Выводим окно
        super.setSize(500, 500);
        super.setLocation(50, 100);
        super.setVisible(true);
    }

    //methods
    public static String getSelection(int mark, int dot) {
        caret.setDot(mark);
        caret.moveDot(dot);
        return text.getText().substring(caret.getMark(), caret.getDot());
    }

    public static void deleteSelection(int mark, int dot) {
        caret.setDot(mark);
        caret.moveDot(dot);
        text.cut();
    }

    public static void replaceSelection(int mark, int dot, String str) {
        caret.setDot(mark);
        caret.moveDot(dot);
        text.cut();
        text.insert(str, mark);
    }

    public static String getText() {
        return text.getText();
    }

    public static void setText(String str) {
        caret.setDot(0);
        caret.moveDot(text.getText().length());
        text.cut();
        text.append(str);
    }
}