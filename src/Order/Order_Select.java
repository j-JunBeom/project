package Order;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Order_Select extends JPanel implements ActionListener{
	
	JPanel jbt, text;
	JButton jbt1, jbt2, jbt3, jbt4;
	static JLabel text1, text2, text3;
	String temp=null, tempa, size=null, sizea;
	
	
	Order_Select() {
		setLayout(new GridLayout(2,1));
		jbt = new JPanel();
		text = new JPanel();
		
		// 폰트 지정
		Font f = new Font("고딕", Font.BOLD, 20);
		// 라벨
		text1 = new JLabel("커피/가격");
		text1.setFont(f);
		text2 = new JLabel("/온도");
		text2.setFont(f);
		text3 = new JLabel("/사이즈");
		text3.setFont(f);
		
		text.add(text1); text.add(text2); text.add(text3);
		
		// 버튼
		jbt1 = new JButton("주문");
		jbt2 = new JButton("선택 취소");
		jbt3 = new JButton("총 판매내역");
		jbt4 = new JButton("메뉴별 판매건수");
		
		jbt.add(jbt1); jbt.add(jbt2); jbt.add(jbt3); jbt.add(jbt4);
		
		add(text);
		add(jbt);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}