package lvl1_lesson8_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {

    private int number;
    private JRadioButton[] radioButtons;
    private int result;

    public MyWindow() {
        result=0;
        setTitle(Quiz.title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        setLayout(new GridLayout(3+Quiz.answers.length, 1));
        JLabel  labelTask = new JLabel(Quiz.task);
        add(labelTask);


        number = 0;
        JLabel  labelQuestion = new JLabel(Quiz.questions[number] );
        add(labelQuestion);

        ButtonGroup group = new ButtonGroup();
        radioButtons = new JRadioButton[Quiz.answers.length];
        for(int i=0;i<radioButtons.length;i++)
        {
            radioButtons[i]=new JRadioButton(Quiz.answers[i],false);
            group.add(radioButtons[i]);
            add(radioButtons[i]);
        }

        JButton buttonNext = new JButton("Следующий вопрос");
        add(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(number<5){
                    System.out.println(number);
                    int answer =-1;
                    for(int i=0;i<radioButtons.length;i++)
                        if(radioButtons[i].isSelected()) {answer =i;break;}
                    if(answer!=-1) {
                        if (Quiz.check(answer,number)) result++;
                        group.clearSelection();
                        if(number<4){
                            labelQuestion.setText(Quiz.questions[number+1]);
                            add(labelQuestion, 1);}
                        if(number==3) buttonNext.setText("Узнать результаты");
                        if(number==4){
                            getContentPane().removeAll();
                            getContentPane().repaint();
                            setLayout(new BorderLayout());
                            JLabel  labelResult = new JLabel("                                         Ваш результат: "+ result+" из "+ Quiz.rightAnswers.length );
                            add(labelResult, BorderLayout.CENTER);
                            validate();
                        }
                        number++;
                    }
                }
            }
        });


        setVisible(true);
    }
}