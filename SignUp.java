import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.io.*;

public class SignUp extends JFrame
{
	private Container c;
	private ImageIcon icon;
	private JButton signUp, back;
	private JRadioButton male, female;
	private ButtonGroup radioButtonGroup;
	private JLabel titleL, nameL, numberL, emailL, ageL, genderL, passL;
	private JTextField nameT, numberT, emailT, passT;
	private JComboBox date, month, year;
	private String [] dateList = {"Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
	private String [] monthList = {"Month","January","February","March","April","May","June","July","August","September","October","November","December"};
	private String [] yearList = {"Year","2005","2004","2003","2002","2001","2000","1999","1998","1997","1996","1995","1994","1993","1992","1991","1990","1989","1988","1987","1986","1985","1984","1983","1982","1981","1980"};
	
	public SignUp()
	{
		Components();
	}
	public void Components()
	{
		//frame
		setBounds(100,30,850,700);
		setTitle("SignUp");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//container
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.BLUE);
		
		//icon
		icon = new ImageIcon(getClass().getResource("Icon.png"));
		this.setIconImage(icon.getImage());
		
		//Label
		titleL = new JLabel("Follow the instructions below to compelete sign up");
		titleL.setBounds(100,20,650,30);
		titleL.setForeground(Color.MAGENTA);		
		titleL.setFont(new Font("Segoe UI", Font.BOLD, 25));
		c.add(titleL);
		nameL = new JLabel("Enter Name");
		nameL.setBounds(150,100,300,25);
		nameL.setForeground(Color.WHITE);		
		nameL.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		c.add(nameL);
		numberL = new JLabel("Mobile Number");
		numberL.setBounds(150,150,300,25);
		numberL.setForeground(Color.WHITE);		
		numberL.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		c.add(numberL);
		emailL = new JLabel("Email Address");
		emailL.setBounds(150,200,300,25);
		emailL.setForeground(Color.WHITE);		
		emailL.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		c.add(emailL);
		ageL = new JLabel("Date of Birth");
		ageL.setBounds(150,250,300,25);
		ageL.setForeground(Color.WHITE);		
		ageL.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		c.add(ageL);
		genderL = new JLabel("Gender");
		genderL.setBounds(150,300,300,25);
		genderL.setForeground(Color.WHITE);		
		genderL.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		c.add(genderL);
		passL = new JLabel("Set Password");
		passL.setBounds(150,350,300,25);
		passL.setForeground(Color.WHITE);		
		passL.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		c.add(passL);
		
		//textField
		nameT = new JTextField();
		nameT.setBounds(350,100,300,25);
		c.add(nameT);
		numberT = new JTextField();
		numberT.setBounds(350,150,300,25);
		c.add(numberT);
		emailT = new JTextField();
		emailT.setBounds(350,200,300,25);
		c.add(emailT);
		passT = new JTextField();
		passT.setBounds(350,350,300,25);
		c.add(passT);
		
		//combobox
		date = new JComboBox(dateList);
		date.setBounds(350,250,70,25);
		c.add(date);
		month = new JComboBox(monthList);
		month.setBounds(420,250,90,25);
		c.add(month);
		year = new JComboBox(yearList);
		year.setBounds(510,250,70,25);
		c.add(year);
		
		//button group for radio button
		radioButtonGroup = new ButtonGroup();
		
		//radioButton
		male =new JRadioButton("Male");
		male.setBounds(350,300,75,25);
		male.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		male.setBorderPainted(false);		
        male.setContentAreaFilled(false);
		c.add(male);
		female =new JRadioButton("Female");
		female.setBounds(450,300,90,25);
		female.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		female.setBorderPainted(false);		
        female.setContentAreaFilled(false);
		c.add(female);
		radioButtonGroup.add(male);
		radioButtonGroup.add(female);
		
		//signup
		signUp = new JButton("Sign Up");
        signUp.setBackground(Color.GREEN);
        signUp.setFont(new Font("Segoe UI", Font.BOLD, 18));
        signUp.setForeground(Color.BLACK);
        signUp.setBorderPainted(false);
        signUp.setBounds(435, 410, 110, 30);
        signUp.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
			{
                // Check if all fields are filled
                if (nameT.getText().trim().isEmpty() ||
                        numberT.getText().trim().isEmpty() ||
                        emailT.getText().trim().isEmpty() ||
                        passT.getText().trim().isEmpty() ||
                        date.getSelectedItem().equals("Date") ||
                        month.getSelectedItem().equals("Month") ||
                        year.getSelectedItem().equals("Year") ||
                        (!male.isSelected() && !female.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Please fill in all the fields and select a valid date and gender.");
                    return; // Do not proceed further if any field is empty or date/gender is not selected
                }

                // create & write
                try {
                    // create
                    File newFile = new File("E:\\New Final\\Auto Sales\\RegData.txt");
                    newFile.createNewFile();

                    // write
                    FileWriter newWriteFile = new FileWriter("E:\\New Final\\Auto Sales\\RegData.txt", true);

                    String line1 = nameT.getText();
                    String line2 = numberT.getText();
                    String line3 = emailT.getText();
                    String line4 = passT.getText();
                    String line5 = date.getSelectedItem() + "-" + month.getSelectedItem() + "-" + year.getSelectedItem();
                    String line6 = male.isSelected() ? "Male" : "Female";

                    newWriteFile.write(line1 + " , " + line2 + " , " + line3 + " , " + line4 + " , " + line5 + " , " + line6 + "\n");

                    newWriteFile.close();
                } 
				catch (IOException ioe) 
				{
                    System.out.println("I/O Error!");
                }

                JOptionPane.showMessageDialog(null, "Sign up Successful");
                setVisible(false);
                Login login = new Login();
                login.setVisible(true);
            }
        });

		c.add(signUp);
		
		//backButton
		back = new JButton("Back");
		back.setBackground(Color.RED );
		back.setFont(new Font("Segoe UI", Font.BOLD, 15));
		back.setForeground(Color.BLACK);
		back.setBorderPainted(false);	
		back.setBounds(750,630,70,30);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				Login login = new Login();
				login.setVisible(true);
			}
			
		});
		c.add(back);
		
	}
	public static void main(String [] args)
	{
		SignUp signUp= new SignUp(); 
		signUp.setVisible(true);
	}
}
