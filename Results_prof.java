package univ;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Results_prof extends JFrame {

	JPanel titlePanel, inputPanel, searchPanel, btnPanel;
	JLabel titleLabel, pCodeLabel, pNameLabel, yearLabel, gradeLabel, termLabel;
	JTextField pCodeField, pNameField, searchField;
	JComboBox yBox, gBox, tBox, sBox;
	JButton searchBtn, saveBtn, exitBtn;
	TitledBorder iBorder, tBorder;
	DefaultTableModel dtm;
	JTable table;
	JScrollPane jsp;
	PreparedStatement pstmt;
	ResultSet rs,rs1;
	int selectRow = -1;
	int dCode;
	boolean isEmpty = false;
	Font font;
	Image logo;
	UnivMenu univMenu;
	
	Results_prof(UnivMenu univMenu){
		this.univMenu = univMenu;
		
		setLayout(null);
		setTitle("성적관리");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		logo = tk.getImage("C:\\Users\\kcd\\Desktop\\자바\\이미지/주소록.png");
		setIconImage(logo);
		
		titlePanel = new JPanel();
		titlePanel.setBounds(0,0,600,50);
		titlePanel.setBackground(Color.black);
		add(titlePanel);
		
		titleLabel = new JLabel("성 적 관 리");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		titlePanel.add(titleLabel);
		
		inputPanel = new JPanel();
		iBorder = new TitledBorder("입력");
		inputPanel.setBorder(iBorder);
		inputPanel.setBounds(5,55,575,200);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		pCodeLabel = new JLabel("교수코드");
		pCodeLabel.setBounds(25,30,50,20);
		inputPanel.add(pCodeLabel);
		
		pCodeField = new JTextField();
		pCodeField.setBounds(90,30,100,25);
		pCodeField.setText(univMenu.usercode);
		pCodeField.setEditable(false);
		inputPanel.add(pCodeField);
		
		pNameLabel = new JLabel("교수이름");
		pNameLabel.setBounds(210,30,50,20);
		inputPanel.add(pNameLabel);
		
		pNameField = new JTextField();
		pNameField.setBounds(270,30,100,25);
		pNameField.setText(univMenu.username);
		pNameField.setEditable(false);
		inputPanel.add(pNameField);
		
		yearLabel = new JLabel("개설년도");
		yearLabel.setBounds(390,30,50,20);
		inputPanel.add(yearLabel);
		
		String[] y = {"2020","2021","2022"};
		yBox = new JComboBox(y);
		yBox.setBounds(450,30,100,25);
		inputPanel.add(yBox);
		
		gradeLabel = new JLabel("개설학년");
		gradeLabel.setBounds(25,70,50,20);
		inputPanel.add(gradeLabel);
		
		String[] g = {"1학년","2학년","3학년","4학년"};
		gBox = new JComboBox(g);
		gBox.setBounds(90,70,100,25);
		inputPanel.add(gBox);
		
		termLabel = new JLabel("개설학기");
		termLabel.setBounds(210,70,50,20);
		inputPanel.add(termLabel);
		
		String[] t = {"1학기","2학기","3여름학기","4겨울학기"};
		tBox = new JComboBox(t);
		tBox.setBounds(270,70,100,25);
		inputPanel.add(tBox);
		
		searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBounds(0,260,600,50);
		searchPanel.setBackground(Color.cyan);
		add(searchPanel);
		
		String[] s = {"검색할 교과목을 선택하세요","code"};
		sBox = new JComboBox(s);
		sBox.setBounds(20,12,200,25);
		searchPanel.add(sBox);
		
		searchField = new JTextField();
		searchField.setBounds(235,12,150,25);
		searchPanel.add(searchField);
		
//		File file = new File("C:\\Users\\kcd\\Desktop\\자바\\이미지/search2.gif");
//		BufferedImage image = ImageIO.read(file);
//		ImageIcon icon = new ImageIcon(this.getClass().getResource("search2.gif"));
//		Image img = icon.getImage();
//		Image cImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//		ImageIcon cImageIcon = new ImageIcon(cImg);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\kcd\\Desktop\\자바\\이미지/icon2.png");
		Image img = icon.getImage();
		Image cImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon cImageIcon = new ImageIcon(cImg);
		
		ImageIcon icon2 = new ImageIcon("C:\\Users\\kcd\\Desktop\\자바\\이미지/검색.png");
		Image img2 = icon2.getImage();
		Image cImg2 = img2.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon cImageIcon2 = new ImageIcon(cImg2);
		
		searchBtn = new JButton("조회",cImageIcon2);
		searchBtn.setBounds(480,12,85,25);
		searchBtn.setBackground(Color.DARK_GRAY);
		searchBtn.setForeground(Color.pink);
		searchPanel.add(searchBtn);

		String[][] rowdata = {};
		String[] colname = {"학번","이름","출석","레포트","중간","기말","가산점","합계","학점"};
		dtm = new DefaultTableModel(rowdata,colname);
		table = new JTable(dtm);
		jsp = new JScrollPane(table);
		tBorder = new TitledBorder("테이블");
		jsp.setBorder(tBorder);
		jsp.setBounds(5,315,575,280);
		table.setRowHeight(20);
		add(jsp);
		
		btnPanel = new JPanel();
		btnPanel.setBounds(5,600,575,50);
		btnPanel.setLayout(null);
		add(btnPanel);
		
		font = new Font("굴림", Font.BOLD, 20);
		
		saveBtn = new JButton("저장");
		saveBtn.setFont(font);
		saveBtn.setBackground(Color.red);
		saveBtn.setForeground(Color.LIGHT_GRAY);
		saveBtn.setBounds(280,10,130,40);
		
		exitBtn = new JButton("종료");
		exitBtn.setFont(font);
		exitBtn.setBackground(Color.green);
		exitBtn.setForeground(Color.magenta);
		exitBtn.setBounds(430,10,130,40);
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				univMenu.show();
			}
		});
		
		btnPanel.add(saveBtn);
		btnPanel.add(exitBtn);
		
		getListAll();
		
//		sBox.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				switch (sBox.getSelectedItem().toString()) {
//				case "학과코드":
//					sQuary = "select * from department where deptNum = ?";
//					break;
//				case "학과명":
//					sQuary = "select * from department where deptName = ?";
//					break;
//				case "전공명":
//					sQuary = "select * from department where majorName = ?";
//					break;
//				default:
//					break;
//				}
//			}
//		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectRow = table.getSelectedRow();
			}
		});
		
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectRow == -1) {
					JOptionPane.showMessageDialog(null, "저장할 행을 선택하세요.");
					return;
				}
				int attended = 0, report = 0, middle = 0, finals = 0, added = 0;
				try {
					attended = Integer.parseInt(table.getValueAt(selectRow, 2).toString());
					report = Integer.parseInt(table.getValueAt(selectRow, 3).toString());
					middle = Integer.parseInt(table.getValueAt(selectRow, 4).toString());
					finals = Integer.parseInt(table.getValueAt(selectRow, 5).toString());
					added = Integer.parseInt(table.getValueAt(selectRow, 6).toString());
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "숫자만 입력하세요.");
					return;
				}
				
				String stdCode = table.getValueAt(selectRow, 0).toString();
				int sum = attended + report + middle + finals + added;
				String grade = "";
				
				if (sum >= 90)
					grade = "A";
				else if (sum >= 80)
					grade = "B";
				else if (sum >= 70)
					grade = "C";
				else if (sum >= 60)
					grade = "D";
				else
					grade = "E";
				
				if (attended > 20) {
					JOptionPane.showMessageDialog(null, "출석 점수는 20점을 초과할 수 없습니다.");
					table.setValueAt(20, selectRow, 2);
					return;
				}
				if (report > 20) {
					JOptionPane.showMessageDialog(null, "레포트 점수는 20점을 초과할 수 없습니다.");
					table.setValueAt(20, selectRow, 3);
					return;
				}
				if (middle > 30) {
					JOptionPane.showMessageDialog(null, "중간 점수는 30점을 초과할 수 없습니다.");
					table.setValueAt(30, selectRow, 4);
					return;
				}
				if (finals > 30) {
					JOptionPane.showMessageDialog(null, "기말 점수는 30점을 초과할 수 없습니다.");
					table.setValueAt(30, selectRow, 5);
					return;
				}
				if (sum > 100) {
					JOptionPane.showMessageDialog(null, "합계는 100점을 초과할 수 없습니다.");
					table.setValueAt(100, selectRow, 7);
					return;
				}

				int result = update(attended, report, middle, finals, added, sum, grade, stdCode);
				if (result != 0) {
					JOptionPane.showMessageDialog(null, "저장했습니다.");
					getListAll();
					selectRow = -1;
				}
			}
		});
		
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sBox.getSelectedItem().toString().equals("검색할 교과목을 선택하세요")) {
					JOptionPane.showMessageDialog(null, "교과목을 선택하세요.");
					sBox.requestFocus();
					return;
				}
				
				if (searchField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "조회할 정보를 입력하세요.");
					searchField.requestFocus();
					return;
				}
				
				search();
				//reset();
				selectRow = -1;
				//searchField.setText("");
				
//				if (dtm.getRowCount() == 0) {
//					JOptionPane.showMessageDialog(null, "조회 결과가 없습니다.");
//					searchField.requestFocus();
//				}
			}
		});
		
		searchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				searchBtn.setIcon(cImageIcon);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				searchBtn.setIcon(cImageIcon2);
			}
		});
		
		//setSize(600,700);
		setBounds(1300,500,600,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void getListAll() {
		dtm.setRowCount(0);
		String quary = "select std_code, name, attended, report, middle, final, added, sum, grade_value "
				+ "from results, student where results.prof_code = ? and std_code = sNum";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, pCodeField.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String std_code = rs.getString(1);
				String name = rs.getString(2);
				String attended = rs.getString(3);
				String report = rs.getString(4);
				String middle = rs.getString(5);
				String finals = rs.getString(6);
				String added = rs.getString(7);
				String sum = rs.getString(8);
				String grade_value = rs.getString(9);
				String[] data = {std_code,name,attended,report,middle,finals,added,sum,grade_value};
				
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getProfName(String profCode) {
		String quary = "select name from professor where pCode = ?";
		String profName = "";
		try {
			//pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, profCode);
			rs1 = pstmt.executeQuery();
			while (rs1.next()) {
				profName = rs1.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return profName;
	}
	
//	public int insert(String dCode, String dName, String mName) {
//		int result = 0;
//		String quary = "insert into department values(?,?,?)";
//		
//		try {
//			pstmt = univMenu.connector.conn.prepareStatement(quary);
//			pstmt.setString(1, dCode);
//			pstmt.setString(2, dName);
//			pstmt.setString(3, mName);
//			
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return result;
//	}
	
	public int update(int attended, int report, int middle, int finals, int added, int sum,
			String grade, String stdCode) {
		
		int result = 0;
		String quary = "update results set attended = ?, report = ?, middle = ?, final = ?, "
				+ "added = ?, sum = ?, grade_value = ? where std_code = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setInt(1, attended);
			pstmt.setInt(2, report);
			pstmt.setInt(3, middle);
			pstmt.setInt(4, finals);
			pstmt.setInt(5, added);
			pstmt.setInt(6, sum);
			pstmt.setString(7, grade);
			pstmt.setString(8, stdCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
//	public int delete(String dCode) {
//		int result = 0;
//		String quary = "delete from department where deptNum = ?";
//		
//		try {
//			pstmt = univMenu.connector.conn.prepareStatement(quary);
//			pstmt.setString(1, dCode);
//			
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return result;
//	}
	
	public void search() {
		dtm.setRowCount(0);
		String quary = "select std_code, attended, report, middle, final, added,"
				+ "sum, grade_value from results where subj_code = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, searchField.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String std_code = rs.getString(1);
				String attended = rs.getString(2);
				String report = rs.getString(3);
				String middle = rs.getString(4);
				String fainal = rs.getString(5);
				String added = rs.getString(6);
				String sum = rs.getString(7);
				String grade_value = rs.getString(8);
				
				String[] data = {std_code,attended,report,middle,fainal,added,sum,grade_value};
				
				dtm.addRow(data);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public void reset() {
//		dCodeField.setText("");
//		dNameField.setText("");
//		mNameField.setText("");
//		dCodeField.requestFocus();
//	}
	
//	public void check() {
//		if (dCodeField.getText().isEmpty()) {
//			JOptionPane.showMessageDialog(null, "학과코드를 입력하세요.");
//			dCodeField.requestFocus();
//			isEmpty = true;
//			return;
//		}
//		else if (dNameField.getText().isEmpty()) {
//			JOptionPane.showMessageDialog(null, "학과명 입력하세요.");
//			dNameField.requestFocus();
//			isEmpty = true;
//			return;
//		}
//		
//		else if (mNameField.getText().isEmpty()) {
//			JOptionPane.showMessageDialog(null, "전공명을 입력하세요.");
//			mNameField.requestFocus();
//			isEmpty = true;
//			return;
//		}
//		
//		isEmpty = false;
//	}
	
//	public static void main(String[] args){
//		new Results_prof();
//	}
}
