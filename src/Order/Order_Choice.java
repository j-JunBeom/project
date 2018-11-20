package Order;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Order_Choice extends JPanel{
	
	JPanel hcpanel1, hcpanel2, sizepanel1, sizepanel2;
	JLabel jlb1, jlb2;
	JRadioButton hot, cold, tall, grande, venti;
	ButtonGroup hc, size;
	String retemp, resize, beforesize;
		
	Order_Choice(){
		setLayout(new GridLayout(4,1));
		hcpanel1 = new JPanel();
		hcpanel2 = new JPanel();
		sizepanel1 = new JPanel();
		sizepanel2 = new JPanel();
		
		// 폰트 지정
		Font f = new Font("고딕", Font.BOLD, 20);
		jlb1 = new JLabel("HOT / COLD");
		jlb1.setFont(f);
		
		jlb2 = new JLabel("사이즈");
		jlb2.setFont(f);
		
		hot = new JRadioButton("HOT");
		cold = new JRadioButton("COLD");
		tall = new JRadioButton("TALL");
		grande = new JRadioButton("GRANDE");
		venti = new JRadioButton("VENTI");
		
		// 온도 버튼 그룹
		hc = new ButtonGroup();
		hc.add(hot); hc.add(cold);
		
		
		// 사이즈 버튼 그룹
		size = new ButtonGroup();
		size.add(tall); size.add(grande); size.add(venti);
		
		// 온도 패널
		hcpanel1.add(jlb1);
		hcpanel2.add(hot);
		hcpanel2.add(cold);
		
		// 사이즈 패널
		sizepanel1.add(jlb2);
		sizepanel2.add(tall); sizepanel2.add(grande); sizepanel2.add(venti);
		
		// 패널 위치 구분
		this.add(hcpanel1);
		this.add(hcpanel2);
		this.add(sizepanel1);
		this.add(sizepanel2);
	
	}
}