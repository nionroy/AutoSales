import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AdminLogin extends JFrame
{
	//instance
	private Container c;
	private ImageIcon icon;
	private JLabel hedaing, userNameL, passwordL;
	private JTextField userNameT;
	private JPasswordField passwordT;
	private JButton login, back;
	
	public AdminLogin()
	{
		iComponents();
	}
	public void iComponents()
	{
		//frame
		setBounds(100,30,500,400);
		setTitle("Admin Login");
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
		
		//label
		hedaing = new JLabel("Responsibility is in you hand.");
		hedaing.setBounds(80,20,650,30);
		hedaing.setForeground(Color.MAGENTA);		
		hedaing.setFont(new Font("Segoe UI", Font.BOLD, 25));
		c.add(hedaing);
		userNameL = new JLabel("AdminUser Name");
		userNameL.setBounds(100,100,200,20);
		userNameL.setForeground(Color.WHITE);		
		userNameL.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		c.add(userNameL);
		passwordL = new JLabel("Password");
		passwordL.setBounds(100,180,650,20);
		passwordL.setForeground(Color.WHITE);		
		passwordL.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		c.add(passwordL);
		
		//textField
		userNameT = new JTextField();
		userNameT.setBounds(100,130,200,25);
		c.add(userNameT);
		
		//passField
		passwordT = new JPasswordField();
		passwordT.setBounds(100,210,200,25);
		c.add(passwordT);
		
		//buttons
		login = new JButton("Sign In");
		login.setBackground(Color.GREEN);
		login.setFont(new Font("Segoe UI", Font.BOLD, 15));
		login.setForeground(Color.BLACK);
		login.setBorderPainted(false);	
		login.setBounds(150,250,90,30);
		login.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e)
			{
				//login logic
				String name = userNameT.getText();
			    String pass = passwordT.getText();
				
				if(name.equals("Admin") && pass.equals("1234"))
				{
				    JOptionPane.showMessageDialog(null, "Admin Sign in Successful");
				    setVisible(false);
				    Management management = new Management();
		            management.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Wrong password or username");
				}
			}
			
		});
		c.add(login);
		back = new JButton("Back");
		back.setBackground(Color.RED );
		back.setFont(new Font("Segoe UI", Font.BOLD, 15));
		back.setForeground(Color.BLACK);
		back.setBorderPainted(false);	
		back.setBounds(400,330,70,30);
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
		AdminLogin adminLogin = new AdminLogin();
		adminLogin.setVisible(true);
	}
}