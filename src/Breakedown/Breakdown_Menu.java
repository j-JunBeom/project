package Breakedown;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Database.MakeConnection;

public class Breakdown_Menu extends JFrame{
	
	JPanel panel;
	String title[] = {"coffeename", "count", "sum"};
	DefaultTableModel model = new DefaultTableModel(title, 0);
	JTable table = new JTable(model);
	JScrollPane jsp = new JScrollPane(table);
	String arr[]= {"메뉴", "판매건수", "총액"};
	
	public Breakdown_Menu() {
		super("메뉴별 판매건수");
		panel = new JPanel();
		// TODO Auto-generated constructor stub
		model.addRow(arr);
		String str = null;
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		
		// 전체 열에 지정
		// 각 셀렌더러를 생성한 dtcr에 set
		for(int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		
		Connection conn = MakeConnection.getConnection();

		String sql = "select coffeename, count(*) total, sum(price) totalprice from coffee group by coffeename ";
		PreparedStatement pstmt = null; // interface
		ResultSet rs = null;
		// 4. 문장 객체
				try {
					pstmt = conn.prepareStatement(sql);
				// 5. 실행
					rs = pstmt.executeQuery();
				// 6. 레코드별 로직 처리
					while(rs.next()) {
						String coffeename = rs.getString(1);
						arr[1-1]=coffeename+"";
						String total = rs.getString(2);
						arr[2-1]=total+"";
						int totalprice = rs.getInt(3);
						arr[3-1]=totalprice+"";
						model.addRow(arr);
					}			
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				panel.add(table);
				this.add(panel);
				setBounds(100, 100, 500, 500);
				setVisible(true);
	}
	public static void main(String[] args) {
		new Breakdown_Menu();
	}
}