import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Loop extends JFrame {
    // instance
    private Container c;
    private ImageIcon icon;
    private JButton back;

    public Loop() {
        iComponents();
    }

    public void iComponents() {
        // frame
        setBounds(100, 30, 850, 700);
        setTitle("loop");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // container
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLUE);

        // icon
        icon = new ImageIcon(getClass().getResource("Icon.png"));
        this.setIconImage(icon.getImage());

        // back button
        back = new JButton("load");
        back.setBackground(Color.RED);
        back.setFont(new Font("Segoe UI", Font.BOLD, 15));
        back.setForeground(Color.BLACK);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setBounds(750, 10, 100, 30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    File file = new File("D:\\Auto Sales\\AddProductData.txt");
                    Scanner scanner = new Scanner(file);
                    int i, j = 0;
                    while (scanner.hasNextLine())
					{
                        String line = scanner.nextLine();
                        String []parts = line.split(" , ");

                        // panel creation
                        String panelName = "Panel " + (j + 1);
                        JPanel panel = new JPanel();
                        panel.setBackground(Color.CYAN);
                        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        panel.setBounds(10, 50, 200 * (j + 1), 300 * (j + 1));
                        panel.add(new JLabel(panelName));

                        // Add each element of the parts array as a separate JLabel
                        for (String part : parts) {
                            panel.add(new JLabel(part));
                        }

                        c.add(panel);
                        j++;
                    }
                } 
				catch (FileNotFoundException ex) 
				{
					 ex.printStackTrace();
                    JOptionPane.showMessageDialog(Loop.this, "Error loading file", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        c.add(back);
    }

    // method for searching

    public static void main(String[] args) {
        Loop loop = new Loop();
        loop.setVisible(true);
    }
}
