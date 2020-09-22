import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static ArrayList<Kindergarten> kindergartens = new ArrayList<>();
    public static TableModelTest tableModelTest = new TableModelTest(kindergartens);
    public static JTable table = new JTable(tableModelTest);

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1000, 600));

        JDialog error = new JDialog();
        error.setSize(150,80);
        error.add(new JLabel("Выберите элемент!"),BorderLayout.CENTER);

        Collections.addAll(
                kindergartens,
                new Kindergarten("Лесная полянка", 420, 550, 2000),
                new Kindergarten("Солнышко", 340, 400,1700),
                new Kindergarten("АБВГДейка", 224, 260,1300),
                new Kindergarten("Золотой ключик", 259, 350,1400)
        );

        JScrollPane pane = new JScrollPane(table);

        JButton buttonRemove= new JButton("Удалить");
        buttonRemove.setSize(new Dimension(60,30));
        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tableModelTest.delete(table.getSelectedRow());
                    table.revalidate();
                    table.repaint();
                } catch (IndexOutOfBoundsException e1){
                    error.setVisible(true);
                }
            }
        });

        JButton buttonAdd = new JButton("Добавить");
        buttonAdd.setSize(new Dimension(60,30));
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KindergartenJob kindergartenJob = new KindergartenJob();
            }
        });

        JButton buttonEdit = new JButton("Редактировать");
        buttonEdit.setSize(new Dimension(60,30));
        buttonEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    KindergartenJob kindergartenJob = new KindergartenJob(kindergartens.get(table.getSelectedRow()));
                }
                catch (IndexOutOfBoundsException e2){
                    error.setVisible(true);
                }

            }
        });

        JPanel panelButtons = new JPanel();
        panelButtons.setSize(100,100);
        panelButtons.add(buttonRemove,BorderLayout.SOUTH);
        panelButtons.add(buttonAdd,BorderLayout.SOUTH);
        panelButtons.add(buttonEdit,BorderLayout.SOUTH);

        frame.add(pane);
        frame.add(panelButtons,BorderLayout.SOUTH);
        frame.setVisible(true);

    }

}
