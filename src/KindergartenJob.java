import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

// создание диалогового окна для установки значений
public class KindergartenJob extends JDialog {

    JTextField fieldName = new JTextField();
    JTextField fieldNow = new JTextField();
    JTextField fieldMax = new JTextField();
    JTextField fieldMon = new JTextField();

    // создание кнопки "Применить"
    JButton buttonApply = new JButton("Применить");

    JButton buttonCancel = new JButton("Отмена");

    // Метод "Добавить"
    public KindergartenJob(){
        initialize();
        setComponentSize(buttonApply,100,30);
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = fieldName.getText();
                    int now = Integer.parseInt(fieldNow.getText());
                    int max = Integer.parseInt(fieldMax.getText());
                    int money = Integer.parseInt(fieldMon.getText());

                    Collections.addAll(
                            Main.kindergartens,
                            new Kindergarten(name, now, max, money));

                    Main.table.revalidate();
                    Main.table.repaint();

                    setVisible(false);
                }
                catch (Exception e1){
                }
            }
        });
    }

    //Метод "Редактировать"
    public  KindergartenJob(Kindergarten kindergarten){
        initialize();

        fieldName.setText(kindergarten.getName());
        fieldNow.setText(String.valueOf(kindergarten.getmanNow()));
        fieldMax.setText(String.valueOf(kindergarten.getMax()));
        fieldMon.setText(String.valueOf(kindergarten.getMoney()));

        setComponentSize(buttonApply, 100, 30);
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    kindergarten.setName(fieldName.getText());
                    kindergarten.setManNow(Integer.parseInt(fieldNow.getText()));
                    kindergarten.setMax(Integer.parseInt(fieldMax.getText()));
                    kindergarten.setMoney(Integer.parseInt(fieldMon.getText()));

                    Main.table.revalidate();
                    Main.table.repaint();

                    setVisible(false);
                }
                catch (Exception e1){

                }
            }
        });
    }

    private void initialize(){

        setSize(new Dimension(300,400));

        setComponentSize(fieldName,220,30);
        setComponentSize(fieldNow,220,30);
        setComponentSize(fieldMax,220,30);
        setComponentSize(fieldMon,220,30);
        setLayout(new FlowLayout());

        setComponentSize(buttonCancel,100,30);
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        add(new JLabel("Название сада"));
        add(fieldName);
        add(new JLabel("Текущее кол-во детей"));
        add(fieldNow);
        add(new JLabel("Максимальное кол-во детей"));
        add(fieldMax);
        add(new JLabel("Ежемесячный платеж"));
        add(fieldMon);

        add(buttonApply);
        add(buttonCancel);
        setVisible(true);
    }


    public static void setComponentSize(JComponent component, int w,int h){
        component.setMaximumSize(new Dimension(w,h));
        component.setMinimumSize(new Dimension(w,h));
        component.setPreferredSize(new Dimension(w,h));
        component.setSize(w,h);
    }
}
