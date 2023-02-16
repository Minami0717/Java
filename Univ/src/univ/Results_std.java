package univ;

import java.awt.Color;
import java.awt.Font;
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

public class Results_std extends JFrame {

	JPanel titlePanel, inputPanel, searchPanel, btnPanel;
	JLabel titleLabel, sCodeLabel, sNameLabel, yearLabel, gradeLabel, termLabel;
	JTextField sCodeField, sNameField, searchField;
	JComboBox yBox, gBox, tBox, sBox;
	JButton searchBtn, exitBtn;
	TitledBorder iBorder, tBorder;
	DefaultTableModel dtm;
	JTable table;
	JScrollPane jsp;
	PreparedStatement pstmt;
	ResultSet rs,rs1;
	boolean isEmpty = false;
	Font font;
	Image logo;
	UnivMenu univMenu;
	
	Results_std(UnivMenu univMenu){
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
		
		sCodeLabel = new JLabel("학생코드");
		sCodeLabel.setBounds(25,30,50,20);
		inputPanel.add(sCodeLabel);
		
		sCodeField = new JTextField();
		sCodeField.setText(univMenu.usercode);
		sCodeField.setBounds(90,30,100,25);
		sCodeField.setEditable(false);
		inputPanel.add(sCodeField);
		
		sNameLabel = new JLabel("학생이름");
		sNameLabel.setBounds(210,30,50,20);
		inputPanel.add(sNameLabel);
		
		sNameField = new JTextField();
		sNameField.setBounds(270,30,100,25);
		sNameField.setText(univMenu.username);
		sNameField.setEditable(false);
		inputPanel.add(sNameField);
		
		yearLabel = new JLabel("개설년도");
		yearLabel.setBounds(390,30,50,20);
		inputPanel.add(yearLabel);
		
		String[] y = {"2020","2021","2022","2023","2024"};
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
		
		sBox = new JComboBox();
		addSub();
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
		String[] colname = {"교과목명","출석","레포트","중간","기말","가산점","합계","학점"};
		dtm = new DefaultTableModel(rowdata,colname) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
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
		btnPanel.add(exitBtn);
		
		getListAll();
		
		sBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchField.setText(getSubCode(sBox.getSelectedItem().toString()));
			}
		});
		
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sBox.getSelectedIndex() == 0) {
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
				getSubData();
				searchField.setText("");
				searchField.requestFocus();
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
		
		setSize(600,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void addSub() {
		sBox.addItem("검색할 교과목을 선택하세요");
		String quary = "select subj_code from results where std_code = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, sCodeField.getText());
			//pstmt = connector.conn.prepareStatement(quary);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String subCode = rs.getString(1);
				sBox.addItem(getSubName(subCode));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getListAll() {
		dtm.setRowCount(0);
		String quary = "select subj_code, attended, report, middle, final, added, sum, grade_value "
				+ "from results where std_code = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, sCodeField.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String subj_code = rs.getString(1);
				String attended = rs.getString(2);
				String report = rs.getString(3);
				String middle = rs.getString(4);
				String finals = rs.getString(5);
				String added = rs.getString(6);
				String sum = rs.getString(7);
				String grade_value = rs.getString(8);
				String[] data = {getSubName(subj_code),attended,report,middle,finals,added,sum,grade_value};
				
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getSubName(String subCode) {
		String quary = "select subject from subject where code = ?";
		String subName = "";
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, subCode);
			rs1 = pstmt.executeQuery();
			while (rs1.next()) {
				subName = rs1.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subName;
	}
	
	public String getSubCode(String subName) {
		String subCode = "";
		String quary = "select code from subject where subject = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, subName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				subCode = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subCode;
	}
	
	public void getSubData() {
		String quary = "select year, grade, term from subject where code = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, searchField.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				yBox.setSelectedItem(rs.getString(1));
				gBox.setSelectedItem(rs.getString(2));
				tBox.setSelectedItem(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void search() {
		dtm.setRowCount(0);
		String quary = "select subj_code, attended, report, middle, final, added, sum, grade_value "
				+ "from results, subject where subj_code = code and std_code = ? "
				+ "and (subj_code = ? or subject = ?)";
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, sCodeField.getText());
			pstmt.setString(2, searchField.getText());
			pstmt.setString(3, searchField.getText());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					String subj_code = rs.getString(1);
					String attended = rs.getString(2);
					String report = rs.getString(3);
					String middle = rs.getString(4);
					String finals = rs.getString(5);
					String added = rs.getString(6);
					String sum = rs.getString(7);
					String grade_value = rs.getString(8);
					String[] data = {getSubName(subj_code),attended,report,middle,finals,added,sum,grade_value};
					
					dtm.addRow(data);
				} while (rs.next());
			}
			else {
				JOptionPane.showMessageDialog(null, "조회 결과가 없습니다.");
				return;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args){
//		new Results_std();
//	}
}
