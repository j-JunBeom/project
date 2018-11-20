package Order;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Order_Menu extends JPanel implements ActionListener{

	// 버튼 Text 값 배열 저장
	final String[] jbt_Title = {"아메리카노", "카페 라떼", "카페 모카", "카푸치노", "에스프레소",
						  "디카페인 아메리카노", "디카페인 카페 라떼", "디카페인 카페 모카", "디카페인 카푸치노", "콜드 브루",
						  "자바 칩 프라푸치노", "화이트 초콜릿 모카 프라푸치노", "카라멜 프라푸치노", "모카 프라푸치노", "그린티 프라푸치노",
						  "아보카도 블렌디드", "그린티 바나나 블렌디드", "망고 바나나 블렌디드", "초콜릿 바나나 블렌디드", "딸기 피치 블렌디드"};
	// 버튼 배열 생성
	JButton[] jbt = new JButton[20];
	
	// 선택 메뉴 및 가격
	String menu_flag, menu, menua;
	int price, re_price, shot=2, re_shot;
	
		
	Order_Menu(){
		setOpaque(false);
		GridLayout grid = new GridLayout(5, 4);
		grid.setHgap(3);
		grid.setVgap(3);
		setLayout(grid);
		for(int i=0; i<jbt_Title.length; i++) {
			// 버튼 생성
			add(jbt[i] = new JButton(jbt_Title[i]));
			
			if(i<4) {
				jbt[i].setBackground(new Color(203, 238, 130));
				jbt[i].setFont(new Font("굴림", Font.BOLD, 13));
				jbt[i].setForeground(new Color(18, 50, 133));
			}else if(i<8) {
				jbt[i].setBackground(new Color(241, 244, 189));
				jbt[i].setFont(new Font("굴림", Font.BOLD, 13));
				jbt[i].setForeground(new Color(18, 50, 133));
			}else if(i<12) {
				jbt[i].setBackground(new Color(203, 238, 130));
				jbt[i].setFont(new Font("굴림", Font.BOLD, 13));
				jbt[i].setForeground(new Color(18, 50, 133));				
			}else if(i<16){
				jbt[i].setBackground(new Color(241, 244, 189));
				jbt[i].setFont(new Font("굴림", Font.BOLD, 13));
				jbt[i].setForeground(new Color(18, 50, 133));
			}else {
				jbt[i].setBackground(new Color(203, 238, 130));
				jbt[i].setFont(new Font("굴림", Font.BOLD, 13));
				jbt[i].setForeground(new Color(18, 50, 133));					
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}