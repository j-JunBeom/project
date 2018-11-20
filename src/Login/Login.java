package Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Database.MakeConnection;
import Order.Order_Main;

public class Login extends JFrame implements ActionListener{
	
	JButton jbt1,jbt2, jbt3;
	JLabel jlb1, jlb2;
	JTextField jtf1;
	JPasswordField jpf;
	
	public Login() {
		super("로그인");
		
		setBounds(100,100,400,300);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jbt1 = new JButton("로그인");
		jbt1.setFont(new Font("serif", Font.BOLD, 15));
		jbt1.setForeground(Color.black);

		
		jbt2 = new JButton("종료");
		jbt2.setFont(new Font("serif", Font.BOLD, 15));
		jbt2.setForeground(Color.black);
		
		jbt1.setBounds(80, 200, 80, 40);
		jbt2.setBounds(180, 200, 80, 40);
		
		add(jbt1); add(jbt2);
		
		jlb1 = new JLabel("ID ");
		jlb1.setFont(new Font("serif", Font.BOLD, 18));
		jlb1.setForeground(Color.black);
		
		jlb2 = new JLabel("PW ");
		jlb2.setFont(new Font("serif", Font.BOLD, 18));
		jlb2.setForeground(Color.black);
		
		jlb1.setBounds(30,60,70,40);
		jlb2.setBounds(30,120,70,40);
		
		add(jlb1); add(jlb2);
		
		jtf1 = new JTextField(30);
		jpf = new JPasswordField(30);
		jpf.setEchoChar('*');
		
		jtf1.setBounds(100, 60, 150, 40);
		jpf.setBounds(100,130,150,40);
		
		add (jtf1); add(jpf);
		
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		if(obj==jbt1) {
			
			// ID,PW 읽어와서 데이터베이스에 접근 후 있는 사용자 인지 비교 
			String id = jtf1.getText();
			String pw = jpf.getText(); // deprecated 될 것이다///
			
			Connection conn = MakeConnection.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select * from member ");
			sb.append("where id = ? and pw = ? ");
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sb.toString());
				
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				
				rs = pstmt.executeQuery();// select 문
			
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "관리자님 환영합니다.","Message",JOptionPane.PLAIN_MESSAGE);
					
					dispose();
					
					new Order_Main();
				}
				else {
					JOptionPane.showMessageDialog(null, "ID 및  PW를 확인해 주시기 바랍니다.","Message",JOptionPane.ERROR_MESSAGE);
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null)pstmt.close();
						if(conn!=null)conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		}
		else if(obj == jbt2) {
			System.exit(0);
		}
	}
}