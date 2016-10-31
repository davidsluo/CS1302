import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by David on 10/30/2016.
 */
public class IntegerStackEmulator extends JFrame implements ActionListener {

    private Stack<Integer> stack;

    private JTable stackTable;
    private DefaultTableModel tableModel;

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

        stackTable.setModel(tableModel);

        this.add(stackTable);


        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        ioField = new JTextField();
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


        sizePanel = new JPanel();

        sizeField = new JTextField(8);
        sizeField.setText(String.valueOf(stack.size()));

        sizePanel.add(sizeField);

        setMaxSize = new JButton("Set Size");
        setMaxSize.addActionListener(this);

        sizePanel.add(setMaxSize);

        leftPanel.add(sizePanel);

        this.add(leftPanel);

        this.setMinimumSize(new Dimension(600, 400));
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            if (e.getSource() == pushButton) {

            } else if (e.getSource() == popButton) {

            } else if (e.getSource() == clear) {

            } else {
                String append = ((JButton) e.getSource()).getText();
                String ioText = ioField.getText();


            }
        }
    }


    public static void main(String[] args) {
        IntegerStackEmulator emulator = new IntegerStackEmulator();
    }

}
