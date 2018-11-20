package Order;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Breakedown.Breakdown_Menu;
import Breakedown.Breakdown_Order;
import Database.MakeConnection;


public class Order_Main extends JFrame implements ActionListener{
	
	Order_Menu om = new Order_Menu();
	Order_Choice oc = new Order_Choice();
	Order_Select or = new Order_Select();
	
	public Order_Main() {
		JPanel mainp = new JPanel(); // 패널 생성
		setLayout(new BorderLayout()); // 레이아웃 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료 버튼 활성화
		
		add(om, BorderLayout.NORTH); // 주문 메뉴
		add(oc, BorderLayout.CENTER); // 추가 선택
		add(or, BorderLayout.EAST); // 내용 표시 및 주문
		
		
		// menu 버튼 활성화
		for(int i=0; i<om.jbt_Title.length; i++) {
			// 버튼 생성
			om.jbt[i].addActionListener(this);		
		}
		
		// choice 활성화
		oc.hot.addActionListener(this);
		oc.cold.addActionListener(this);
		oc.tall.addActionListener(this);
		oc.grande.addActionListener(this);
		oc.venti.addActionListener(this);
		
		// order 활성화
		or.jbt1.addActionListener(this);
		or.jbt2.addActionListener(this);
		or.jbt3.addActionListener(this);
		or.jbt4.addActionListener(this);
		
		//setSize(1000, 400);
		setVisible(true);
		this.pack();
	}
	public static void main(String[] args) {
		new Order_Main();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object obj = e.getSource();
		// menu start
		for(int i=0; i<om.jbt_Title.length; i++) {
			om.menu_flag = om.jbt_Title[i];
			if(obj==om.jbt[i]) {
				om.menu = om.menu_flag;
				if(om.menu=="아메리카노") {
					om.price = 4000;
				}else if(om.menu=="카페 라떼") {
					om.price = 4500;
				}else if(om.menu=="카페 모카") {
					om.price = 5000;
				}else if(om.menu=="카푸치노") {
					om.price = 5000;
				}else if(om.menu=="에스프레소") {
					om.price = 3000;
				}else if(om.menu=="디카페인 아메리카노") {
					om.price = 4000;
				}else if(om.menu=="디카페인 카페 라떼") {
					om.price = 4500;
				}else if(om.menu=="디카페인 카페 모카") {
					om.price = 5000;
				}else if(om.menu=="디카페인 카푸치노") {
					om.price = 5000;
				}else if(om.menu=="콜드 브루") {
					om.price = 5000;
				}else if(om.menu=="자바 칩 프라푸치노") {
					om.price = 6000;
				}else if(om.menu=="화이트 초콜릿 모카 프라푸치노") {
					om.price = 6500;
				}else if(om.menu=="카라멜 프라푸치노") {
					om.price = 6500;
				}else if(om.menu=="모카 프라푸치노") {
					om.price = 6500;
				}else if(om.menu=="그린티 프라푸치노") {
					om.price = 7000;
				}else if(om.menu=="아보카도 블렌디드") {
					om.price = 7000;
				}else if(om.menu=="그린티 바나나 블렌디드") {
					om.price = 7500;
				}else if(om.menu=="망고 바나나 블렌디드") {
					om.price = 7500;
				}else if(om.menu=="초콜릿 바나나 블렌디드") {
					om.price = 7000;
				}else if(om.menu=="딸기 피치 블렌디드") {
					om.price = 6500;
				}
					om.menua=om.menu;
					(or.text1).setText(om.menua+" / "+om.price);
			//	(or.text1).setText(om.menua+" / "+om.price);
			}
		} // menu end
		
		// temp start
		if(obj==oc.cold) {
			oc.retemp = oc.cold.getText();
		}else if(obj==oc.hot) {
			for(int i=11; i<om.jbt_Title.length; i++) {
				if(om.menua == om.jbt_Title[i]) {
					JOptionPane.showMessageDialog(null, "HOT주문이 불가합니다.","Message",JOptionPane.ERROR_MESSAGE);
					oc.retemp = oc.cold.getText();
					(or.text2).setText("/ "+oc.retemp);
					break;
				}else {
					oc.retemp = oc.hot.getText();
				}
			}
		} 
				
		(or.text2).setText("/ "+oc.retemp);
		// temp end
		
		// size start
		if(obj==oc.tall) {
			oc.resize = oc.tall.getText();
			om.re_shot = om.shot;
			(or.text1).setText(om.menua+" / "+om.price);
		}else if(obj==oc.grande) {
			oc.resize = oc.grande.getText();
			om.re_price = om.price+500;
			om.re_shot = om.shot +1;
			(or.text1).setText(om.menua+" / "+om.re_price);
		}else if(obj==oc.venti) {
			oc.resize = oc.venti.getText();
			om.re_price = om.price+1000;
			om.re_shot = om.shot+2;
			(or.text1).setText(om.menua+" / "+om.re_price);
		}
		(or.text3).setText("/ "+oc.resize);
		//size end
		
		// order jbt start
		if(obj==or.jbt1) {
			String coffeename = om.menua;
			String coffeesize = oc.resize;
			int shot = om.re_shot;
			String coffeetemp = oc.retemp;
			int price = om.re_price;
			
			JOptionPane.showMessageDialog(null, "주문이 완료되었습니다.","Message",JOptionPane.PLAIN_MESSAGE);
			
			Connection conn = MakeConnection.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("insert into coffee ");
			sb.append("values(coffee_seq.nextval, ");
			sb.append("?, ?, ?, ?, ?) ");
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sb.toString());
				
				pstmt.setString(1, coffeename); // coffeename
				pstmt.setString(2, coffeesize); // coffeesize
				pstmt.setInt(3, shot); // shot
				pstmt.setString(4, coffeetemp); // coffeetemp
				pstmt.setDouble(5, price); // price
				
				// 데이터를 넣는것이기 때문에 rs가 필요없음
				pstmt.executeUpdate();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(obj==or.jbt2) {
			(or.text1).setText("커피/가격");
			(or.text2).setText("/온도");
			(or.text3).setText("/사이즈");
		}else if(obj==or.jbt3) {
			new Breakdown_Order();
		}else if(obj==or.jbt4) {
			new Breakdown_Menu();
		}
	}
}