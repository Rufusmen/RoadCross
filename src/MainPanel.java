import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class MainPanel extends JPanel {
    private JToolBar toolBar;
    private JButton up = new JButton("up");
    private JButton down = new JButton("down");
    private JButton right = new JButton("right");
    private JButton left = new JButton("left");
    private Board board = new Board();

    public MainPanel() {
        setPreferredSize(new Dimension(600,650));
        toolBar = new JToolBar();
        toolBar.add(up);
        toolBar.add(down);
        toolBar.add(right);
        toolBar.add(left);
        add(toolBar, BorderLayout.NORTH);
        add(board,BorderLayout.CENTER);
        up.addActionListener(e->board.add_car(1));
        down.addActionListener(e->board.add_car(2));
        right.addActionListener(e->board.add_car(3));
        left.addActionListener(e->board.add_car(4));
    }


}
