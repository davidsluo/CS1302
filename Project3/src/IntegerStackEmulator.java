import Exceptions.EmptyStackException;
import Exceptions.FullStackException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by David on 10/30/2016.
 */
public class IntegerStackEmulator extends JFrame implements ActionListener {

//    private enum Buttons {
//        ONE(new JButton("1")),
//        TWO(new JButton("2")),
//        THREE(new JButton("3")),
//        FOUR(new JButton("4")),
//        FIVE(new JButton("5")),
//        SIX(new JButton("6")),
//        SEVEN(new JButton("7")),
//        EIGHT(new JButton("8")),
//        NINE(new JButton("9")),
//        PUSH(new JButton("Push")),
//        ZERO(new JButton("0")),
//        POP(new JButton("Pop")),
//        CLEAR(new JButton("Clear")),
//        SET_SIZE(new JButton("Set Size"));
//
//        private JButton button;
//
//        Buttons(JButton button) {
//            this.button = button;
//        }
//
//        public JButton getButton() {
//            return button;
//        }
//    }

    private Stack<Integer> stack;

    private JTable stackTable;
    private DefaultTableModel tableModel;

    private JScrollPane rightPanel;
    private JPanel leftPanel;

    private JTextField ioField;

    private JPanel buttonPanel;
    private JButton[] buttons;
    private JButton pushButton;
    private JButton popButton;
    private JButton clear;

    private JPanel sizePanel;
    private JTextField sizeField;
    private JButton setMaxSize;

    public IntegerStackEmulator() {
        this.setLayout(new GridLayout(1, 2));
        stack = new Stack<>();


        stackTable = new JTable();
        tableModel = new DefaultTableModel();

        tableModel.setColumnIdentifiers(new String[]{"Stack"});
        tableModel.setRowCount(stack.maxSize());

        stackTable.setModel(tableModel);
        stackTable.setEnabled(false);

        rightPanel = new JScrollPane(stackTable);

        this.add(rightPanel);


        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        ioField = new JTextField();
        ioField.setEnabled(false);
        ioField.setDisabledTextColor(Color.black);
        ioField.setFont(new Font("Arial", Font.PLAIN, 32));
        leftPanel.add(ioField);

        buttonPanel = new JPanel(new GridLayout(4, 3));
        pushButton = new JButton("Push");
        popButton = new JButton("Pop");
        buttons = new JButton[]{
                new JButton("1"),
                new JButton("2"),
                new JButton("3"),
                new JButton("4"),
                new JButton("5"),
                new JButton("6"),
                new JButton("7"),
                new JButton("8"),
                new JButton("9"),
                pushButton,
                new JButton("0"),
                popButton
        };
        for (JButton b : buttons) {
            buttonPanel.add(b);
            b.addActionListener(this);
        }
        leftPanel.add(buttonPanel);

        clear = new JButton("Clear");
        clear.addActionListener(this);
        leftPanel.add(clear);

        sizePanel = new JPanel();

        sizeField = new JTextField(8);
        sizeField.setText(String.valueOf(stack.size()));

        sizePanel.add(sizeField);

        setMaxSize = new JButton("Set Size");
        setMaxSize.addActionListener(this);

        sizePanel.add(setMaxSize);

        leftPanel.add(sizePanel);


        this.add(leftPanel);

        this.pack();
        this.setMinimumSize(new Dimension(600, 400));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            if (e.getSource() != pushButton
                    && e.getSource() != popButton
                    && e.getSource() != clear
                    && e.getSource() != setMaxSize) {
                ioField.setText(
                        ioField.getText() + ((JButton) e.getSource()).getText()
                );
            } else if (e.getSource() == popButton) {
                try {
                    int popped = stack.pop();
                    tableModel.setValueAt("", stack.size(), 0);
                    ioField.setText(String.valueOf(popped));
                } catch (EmptyStackException e1) {
                    ioField.setText("");
                }
            } else if (e.getSource() == pushButton) {
                try {
                    int input = Integer.parseInt(ioField.getText());
                    tableModel.setValueAt(input, stack.size(), 0);
                    stack.push(input);
//                    ioField.setText("");
                } catch (NumberFormatException | FullStackException | ArrayIndexOutOfBoundsException ignored) {
                }
            } else if (e.getSource() == clear) {
                ioField.setText("");
            } else if (e.getSource() == setMaxSize) {

            }
        }
    }


    public static void main(String[] args) {
        IntegerStackEmulator emulator = new IntegerStackEmulator();
    }

}
