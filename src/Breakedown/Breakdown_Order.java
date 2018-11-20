package Breakedown;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Database.MakeConnection;

public class Breakdown_Order extends JFrame{
	
	JPanel panel = new JPanel();
	String title[] = {"menuno", "coffeename", "coffeesize", "shot", "coffeetemp", "price"};
	DefaultTableModel model = new DefaultTableModel(title, 0);
	JTable table = new JTable(model);
	JScrollPane jsp = new JScrollPane(table);
	String arr[]= {"주문번호", "메뉴", "사이즈", "샷", "온도", "가격"};
	
	public Breakdown_Order() {
		super("총 판매내역");
		// TODO Auto-generated constructor stub
		model.addRow(arr); // 테이블에 행 추가
		String str = null;
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		
		// 전체 열에 지정
		// 각 셀렌더러를 생성한 dtcr에 set
		for(int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		
		Connection conn = MakeConnection.getConnection();

		String sql = "select * from coffee order by menuno";
		
		PreparedStatement pstmt = null; // interface
		ResultSet rs = null;
		// 4. 문장 객체
		try {
			pstmt = conn.prepareStatement(sql);
		// 5. 실행
			rs = pstmt.executeQuery();
		// 6. 레코드별 로직 처리
			while(rs.next()) {
				str = rs.getString(1); // getString(컬럼 번호)
				arr[0]=str;
				String coffeename = rs.getString(2);
				arr[2-1]=coffeename+"";
				String coffeesize = rs.getString(3);
				arr[3-1]=coffeesize+"";
				int shot = rs.getInt(4);
				arr[4-1]=shot+"";
				String coffeetemp = rs.getString(5);
				arr[5-1]=coffeetemp+"";
				int price = rs.getInt(6);
				arr[6-1]=price+"";
				
				model.addRow(arr);

			}			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel.add(table);
		this.add(panel);
		setBounds(100, 100, 700, 500);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Breakdown_Order();
		
	}
}