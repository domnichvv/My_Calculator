package com.vlad.example.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import com.vlad.example.MyConstants;
import com.vlad.example.calc.CalcOperations;

/**
 * Created by Влад on 07.11.2016.
 */

public class CalculationGUI extends JFrame implements ActionListener {

    private JButton btnAdd;
    private JButton btnSubstract;
    private JButton btnDivide;
    private JButton btnMultiply;

    private JLabel labelNum1;
    private JLabel labelNum2;
    private JLabel labelResult;

    private JTextField textNum1;
    private JTextField textNum2;
    private JTextField textResult;
    private JTextField field;

    private Box horizontalLayoutLabelText, horizontalLayoutButtons, horizontalLayoutResult, verticalLayoutPanel;

    public CalculationGUI(){
        super(MyConstants.VIEW_SCREEN_TITLE);

        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //создаем первую горизонтальную панель
        horizontalLayoutLabelText = Box.createHorizontalBox();
        labelNum1 = new JLabel(MyConstants.VIEW_LABEL_NUM_1);
        horizontalLayoutLabelText.add(labelNum1);
        horizontalLayoutLabelText.add(Box.createHorizontalStrut(MyConstants.DISTANCE_BETWEEN_COMPONENTS));
        textNum1 = new JTextField(MyConstants.TEXT_FIELD_WIDTH);
        horizontalLayoutLabelText.add(textNum1);
        horizontalLayoutLabelText.add(Box.createHorizontalStrut(MyConstants.DISTANCE_BETWEEN_COMPONENTS));
        labelNum2 = new JLabel(MyConstants.VIEW_LABEL_NUM_2);
        horizontalLayoutLabelText.add(labelNum2);
        horizontalLayoutLabelText.add(Box.createHorizontalStrut(MyConstants.DISTANCE_BETWEEN_COMPONENTS));
        textNum2 = new JTextField(MyConstants.TEXT_FIELD_WIDTH);
        horizontalLayoutLabelText.add(textNum2);

        //создаем вторую горизонтальную панель
        horizontalLayoutButtons = Box.createHorizontalBox();
        btnAdd = new JButton(MyConstants.VEIW_BUTTON_ADD);
        btnAdd.addActionListener(this);
        horizontalLayoutButtons.add(btnAdd);
        horizontalLayoutButtons.add(Box.createHorizontalStrut(MyConstants.DISTANCE_BETWEEN_COMPONENTS));
        btnSubstract = new JButton(MyConstants.VIEW_BUTTON_SUB);
        btnSubstract.addActionListener(this);
        horizontalLayoutButtons.add(btnSubstract);
        horizontalLayoutButtons.add(Box.createHorizontalStrut(MyConstants.DISTANCE_BETWEEN_COMPONENTS));
        btnMultiply = new JButton(MyConstants.VIEW_BUTTON_MULT);
        btnMultiply.addActionListener(this);
        horizontalLayoutButtons.add(btnMultiply);
        horizontalLayoutButtons.add(Box.createHorizontalStrut(MyConstants.DISTANCE_BETWEEN_COMPONENTS));
        btnDivide = new JButton(MyConstants.VIEW_BUTTON_DIV);
        btnDivide.addActionListener(this);
        horizontalLayoutButtons.add(btnDivide);

        //создаем третью горизонтальную панель
        horizontalLayoutResult = Box.createHorizontalBox();
        labelResult = new JLabel(MyConstants.VIEW_LABEL_RESULT);
        horizontalLayoutResult.add(labelResult);
        horizontalLayoutResult.add(Box.createHorizontalStrut(MyConstants.DISTANCE_BETWEEN_COMPONENTS));
        textResult = new JTextField(MyConstants.TEXT_FIELD_WIDTH);
        horizontalLayoutResult.add(textResult);
        textResult.setEditable(false);

        //добавляем компоненты к вертикальной панели
        verticalLayoutPanel = Box.createVerticalBox();
        verticalLayoutPanel.setBorder(new EmptyBorder(MyConstants.BORDER_EMPTY, MyConstants.BORDER_EMPTY,
                MyConstants.BORDER_EMPTY, MyConstants.BORDER_EMPTY));
        verticalLayoutPanel.add(horizontalLayoutLabelText);
        verticalLayoutPanel.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_VERTICAL));
        verticalLayoutPanel.add(horizontalLayoutButtons);
        verticalLayoutPanel.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_VERTICAL));
        verticalLayoutPanel.add(horizontalLayoutResult);

        setContentPane(verticalLayoutPanel);
        pack();
        setLocationRelativeTo(null); //окно по центру экрана(устанавливать после pack())
        setResizable(false); //размер окна не изменяеться
        setVisible(true); //показать окно
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //проверяем нажата ли была кнопка
        if (!(e.getSource() instanceof JButton)) {
            return; //если кнопка не нажата то выходим из метода
        }

        //иначе если нажата, делаем нисходящее приведение и из нажатого объекта превращаем ее в кнопку
        JButton btn = (JButton) e.getSource();

        String button = e.getActionCommand();

        //далее парсим введеные строки из полей, превращая их в числа
        final double a = Double.parseDouble(textNum1.getText());
        final double b = Double.parseDouble(textNum2.getText());

        //определяем нажатую кнопку, производим вычисление и результат записываем в textResult

        if (button.equals(MyConstants.VEIW_BUTTON_ADD)){
            textResult.setText(String.valueOf(CalcOperations.add(a, b)));
        }
        else if (button.equals(MyConstants.VIEW_BUTTON_SUB)){
            textResult.setText(String.valueOf(CalcOperations.substract(a, b)));
        }
        else if (button.equals(MyConstants.VIEW_BUTTON_MULT)){
            textResult.setText(String.valueOf(CalcOperations.multiply(a, b)));
        }
        else if (button.equals(MyConstants.VIEW_BUTTON_DIV)){
            textResult.setText(String.valueOf(CalcOperations.divide(a, b)));
        }
    }
/*
    @Override
    public void focusGained(FocusEvent e) {
        if (field.getText().trim().equals(MyConstants.INPUT_NUMBER)){ //проверка, если текст в поле "введите число"
            //тогда делаем текстовое поле пусто
            field.setText("");
            //указываем что текст нашего введенного текста будет черным
            field.setForeground(Color.BLACK);
        }
    }

    //метод когда фокус ушел из него
    @Override
    public void focusLost(FocusEvent e) {
        if (field.getText().trim().equals("")){ //проверяем если не было введено чисел
            //тогда в текстовом поле показываем "введите число"
            field.setText(MyConstants.INPUT_NUMBER);
            //и указываем цвет надписи
            field.setForeground(Color.GRAY);
            //метод trim() удалает пробелы в начале и в конце строки
        }
    }*/
}
