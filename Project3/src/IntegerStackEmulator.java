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
        this.setLayout(new GridBagLayout());
        stack = new Stack<>();

        Font textFont = new Font("Arial", Font.PLAIN, 32);

        // The Table ===================================================================================================
        stackTable = new JTable();
        tableModel = new DefaultTableModel();

        String header = String.format("Stack    Max Size:%d", stack.maxSize());

        tableModel.setColumnIdentifiers(new String[]{header});
        tableModel.setRowCount(stack.maxSize());

        stackTable.setModel(tableModel);
        stackTable.setEnabled(false);

        rightPanel = new JScrollPane(stackTable);

        {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridwidth = 1;
            constraints.gridheight = 4;
            constraints.weightx = 1;
            constraints.weighty = 1;
            constraints.fill = GridBagConstraints.BOTH;

            this.add(rightPanel, constraints);
        }

        // The Input/Output Field ======================================================================================
        ioField = new JTextField();
        ioField.setEnabled(false);
        ioField.setDisabledTextColor(Color.black);
        ioField.setFont(textFont);
        {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 1;
            constraints.gridy = 0;
            constraints.gridwidth = 2;
            constraints.gridheight = 1;
            constraints.weightx = 1;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.BOTH;

            this.add(ioField, constraints);
        }

        // Number Buttons + Push + Pop =================================================================================
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
            b.setFont(textFont);
            b.addActionListener(this);
            buttonPanel.add(b);
        }

        {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 1;
            constraints.gridy = 1;
            constraints.gridwidth = 2;
            constraints.gridheight = 1;
            constraints.weightx = 1;
            constraints.weighty = 1;
            constraints.fill = GridBagConstraints.BOTH;

            this.add(buttonPanel, constraints);
        }

        // Clear Button ================================================================================================
        clear = new JButton("Clear");
        clear.setFont(textFont);
        clear.addActionListener(this);
        {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 1;
            constraints.gridy = 2;
            constraints.gridwidth = 2;
            constraints.gridheight = 1;
            constraints.weightx = 1;
            constraints.weighty = .1;
            constraints.fill = GridBagConstraints.BOTH;

            this.add(clear, constraints);
        }

        // Size Field ==================================================================================================
        sizeField = new JTextField(8);
//        sizeField.setFont(textFont);
        sizeField.setText(String.valueOf(stack.maxSize()));
        {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 1;
            constraints.gridy = 3;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.weightx = 1;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.BOTH;

            this.add(sizeField, constraints);
        }

        setMaxSize = new JButton("Set Size");
        setMaxSize.addActionListener(this);
        {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 2;
            constraints.gridy = 3;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.weightx = 1;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.BOTH;

            this.add(setMaxSize, constraints);
        }

        // =============================================================================================================

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
