import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;


public class DeleteProduct extends JFrame
{
	//instance
	private Container c;
	private ImageIcon icon;
	private JButton search, back;
	
	
	public DeleteProduct()
	{
		iComponents();
	}
	public void iComponents()
	{
		//frame
		setBounds(100,30,500,400);
		setTitle("Delete Product");
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
				Management management = new Management();
				management.setVisible(true);
			}
			
		});
		c.add(back);
		
	}
	//method for searching
	
	
	
	public static void main(String [] args)
	{
		DeleteProduct deleteProduct = new DeleteProduct();
		deleteProduct.setVisible(true);
	}
}
