package Login;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Login_Home extends JFrame{
	
	private JButton memberregis;
	private JButton user;
	private JButton manager;
	private JButton exit;
	
	public Login_Home() {
		
		setBounds(500, 300, 300, 250);
		setTitle("Main");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 1)); // 그리드 4열 1행 버튼생성
		
		manager = new JButton("관리자 로그인");
		manager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
				dispose();
			}
		});
		
		
		exit = new JButton("종료");
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		add(manager);
		add(exit);
		
		setVisible(true);
	}
}