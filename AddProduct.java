import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddProduct extends JFrame {
    private Container c;
    private JLabel byNum, carNameLabel, modelLabel, yearLabel;
    private JTextField carNameTextField, modelTextField, yearTextField;
    private JButton addButton, back;

    public AddProduct() {
        initComponents();
        setVisible(true);
    }

    public void initComponents() {
        setBounds(100, 30, 500, 400);
        setTitle("Add Product");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLUE);

        byNum = new JLabel("Add Product");
        byNum.setBounds(100, 30, 300, 30);
        byNum.setForeground(Color.WHITE);
        byNum.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        c.add(byNum);

        carNameLabel = new JLabel("Car Name:");
        carNameLabel.setBounds(50, 80, 100, 20);
        carNameLabel.setForeground(Color.WHITE);
        c.add(carNameLabel);

        carNameTextField = new JTextField();
        carNameTextField.setBounds(150, 80, 200, 20);
        c.add(carNameTextField);

        modelLabel = new JLabel("Model:");
        modelLabel.setBounds(50, 110, 100, 20);
        modelLabel.setForeground(Color.WHITE);
        c.add(modelLabel);

        modelTextField = new JTextField();
        modelTextField.setBounds(150, 110, 200, 20);
        c.add(modelTextField);

        yearLabel = new JLabel("Year:");
        yearLabel.setBounds(50, 140, 100, 20);
        yearLabel.setForeground(Color.WHITE);
        c.add(yearLabel);

        yearTextField = new JTextField();
        yearTextField.setBounds(150, 140, 200, 20);
        c.add(yearTextField);

        addButton = new JButton("Add");
        addButton.setBackground(Color.GREEN);
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        addButton.setForeground(Color.BLACK);
        addButton.setBorderPainted(false);
        addButton.setBounds(200, 200, 100, 30);

        back = new JButton("Back");
        back.setBackground(Color.RED);
        back.setFont(new Font("Segoe UI", Font.BOLD, 15));
        back.setForeground(Color.BLACK);
        back.setBorderPainted(false);
        back.setBounds(400, 330, 70, 30);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String carName = carNameTextField.getText();
                String model = modelTextField.getText();
                String year = yearTextField.getText();

                // Save data to a text file
                saveDataToFile(carName, model, year);

                // Create a Data object and add it to the list
                Data obj = new Data(carName, model, year);
                Data.cdata.add(obj);

                // Clear text fields after saving information
                carNameTextField.setText("");
                modelTextField.setText("");
                yearTextField.setText("");
            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Management().setVisible(true);
            }
        });

        c.add(addButton);
        c.add(back);
    }

    private void saveDataToFile(String carName, String model, String year) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\New Final\\Auto Sales\\AddProductData.txt", true))) {
            // Append data to the file
            writer.write("Car Name: " + carName + " Model: " + model + " Year: " + year + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
            // Handle exception as needed (e.g., show an error message)
        }
    }

    public static void main(String[] args) {
        new AddProduct();
    }
}
