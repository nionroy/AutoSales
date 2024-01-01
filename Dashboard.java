import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dashboard extends JFrame {
    private Container c;
    private JLabel welcome;
    private JButton back;

    public Dashboard() {
        initComponents();
        setVisible(true);
    }

    public void initComponents() {
        setBounds(100, 30, 850, 700);
        setTitle("Dashboard");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLUE);

        welcome = new JLabel("Welcome to SNNS Auto Sales.");
        welcome.setBounds(250, 20, 650, 30);
        welcome.setForeground(Color.MAGENTA);
        welcome.setFont(new Font("Segoe UI", Font.ITALIC, 25));
        c.add(welcome);

        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new FlowLayout());
        panelContainer.setBounds(50, 70, 750, 500);
        c.add(panelContainer);

        for (int i = 0; i < Data.cdata.size(); i++) {
            Data data = Data.cdata.get(i);
            JPanel panel = createPanel(data.getName(), data.getModel(), data.getYear());
            panelContainer.add(panel);
        }

        // Back button
        back = new JButton("Sign Out");
        back.setBackground(Color.RED);
        back.setFont(new Font("Segoe UI", Font.BOLD, 15));
        back.setForeground(Color.BLACK);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setBounds(750, 10, 100, 30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddProduct();
            }
        });
        c.add(back);
    }

    JPanel createPanel(String name, String model, String year) {
        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(null);
        panelContainer.setPreferredSize(new Dimension(750, 150));


        panelContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        JButton buyButton = new JButton("Buy");
        buyButton.setBounds(650, 40, 60, 25);
        panelContainer.add(buyButton);

        JLabel nameLabel = new JLabel("Name:-");
        nameLabel.setBounds(40, 30, 60, 25);
        panelContainer.add(nameLabel);

        JLabel nameValueLabel = new JLabel(name);
        nameValueLabel.setBounds(105, 30, 60, 25);
        panelContainer.add(nameValueLabel);

        JLabel modelLabel = new JLabel("Model:-");
        modelLabel.setBounds(40, 60, 60, 25);
        panelContainer.add(modelLabel);

        JLabel modelValueLabel = new JLabel(model);
        modelValueLabel.setBounds(105, 60, 90, 25);
        panelContainer.add(modelValueLabel);

        JLabel yearLabel = new JLabel("Year:-");
        yearLabel.setBounds(40, 90, 60, 25);
        panelContainer.add(yearLabel);

        JLabel yearValueLabel = new JLabel(year);
        yearValueLabel.setBounds(105, 90, 60, 25);
        panelContainer.add(yearValueLabel);

        return panelContainer;
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}