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

public class Attended extends JFrame {

	JPanel titlePanel, inputPanel, searchPanel, btnPanel;
	JLabel titleLabel, sCodeLabel, nameLabel, deptLabel;
	JTextField sCodeField, nameField, deptField, search1Field, search2Field;
	JComboBox sBox;
	JButton searchBtn, searchAllBtn, delBtn, exitBtn;
	TitledBorder iBorder, sBorder, aBorder;
	DefaultTableModel sDtm, aDtm;
	JTable sTable, aTable;
	JScrollPane sJsp, aJsp;
	PreparedStatement pstmt;
	ResultSet rs,rs1;
	String sQuary;
	int sTableRow = -1;
	int aTableRow = -1;
	boolean isEmpty = false;
	Font font;
	Image logo;
	UnivMenu univMenu;
	String stdName, stdDept;
	
	Attended(UnivMenu univMenu) {
		this.univMenu = univMenu;
		setLayout(null);
		getStdData();
		setTitle("수강신청 사용자: " + univMenu.usercode + " " + stdName);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		logo = tk.getImage("C:\\Users\\kcd\\Desktop\\자바\\이미지/주소록.png");
		setIconImage(logo);
		
		titlePanel = new JPanel();
		titlePanel.setBounds(0,0,600,50);
		titlePanel.setBackground(Color.black);
		add(titlePanel);
		
		titleLabel = new JLabel("수 강 신 청");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		titlePanel.add(titleLabel);
		
		inputPanel = new JPanel();
		iBorder = new TitledBorder("입력");
		inputPanel.setBorder(iBorder);
		inputPanel.setBounds(5,55,575,100);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		sCodeLabel = new JLabel("학생코드");
		sCodeLabel.setBounds(35,30,50,20);
		inputPanel.add(sCodeLabel);
		
		sCodeField = new JTextField();
		sCodeField.setText(univMenu.usercode);
		sCodeField.setEditable(false);
		sCodeField.setBounds(100,30,100,25);
		inputPanel.add(sCodeField);
		
		nameLabel = new JLabel("이름");
		nameLabel.setBounds(220,30,40,20);
		inputPanel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setText(stdName);
		nameField.setEditable(false);
		nameField.setBounds(275,30,100,25);
		inputPanel.add(nameField);
		
		deptLabel = new JLabel("학과");
		deptLabel.setBounds(400,30,40,20);
		inputPanel.add(deptLabel);
		
		deptField = new JTextField();
		deptField.setText(getDeptName(stdDept));
		deptField.setEditable(false);
		deptField.setBounds(450,30,100,25);
		inputPanel.add(deptField);
		
		searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBounds(0,160,600,50);
		searchPanel.setBackground(Color.cyan);
		add(searchPanel);
		
		//String[] s = {"개설학과를 선택하세요","컴퓨터공학","방사선","물리치료","사무자동화","간호1"};
		sBox = new JComboBox();
		addDept();
		sBox.setBounds(20,12,160,25);
		searchPanel.add(sBox);
		
		search1Field = new JTextField();
		search1Field.setBounds(190,12,90,25);
		searchPanel.add(search1Field);
		
		search2Field = new JTextField();
		search2Field.setBounds(290,12,90,25);
		searchPanel.add(search2Field);
		
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
		searchBtn.setBounds(395,12,85,25);
		searchBtn.setBackground(Color.DARK_GRAY);
		searchBtn.setForeground(Color.pink);
		searchPanel.add(searchBtn);
		
		searchAllBtn = new JButton("전체조회");
		searchAllBtn.setBounds(490,12,85,25);
		searchAllBtn.setBackground(Color.DARK_GRAY);
		searchAllBtn.setForeground(Color.pink);
		searchPanel.add(searchAllBtn);

		String[][] rowdata = {};
		String[] colname = {"교과목코드","교과목명","개설학과","수업시수","담당교수","학점"};
		sDtm = new DefaultTableModel(rowdata,colname) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		sTable = new JTable(sDtm);
		sJsp = new JScrollPane(sTable);
		sBorder = new TitledBorder("교과목 테이블");
		sJsp.setBorder(sBorder);
		sJsp.setBounds(5,215,575,170);
		sTable.setRowHeight(20);
		add(sJsp);
		
		aDtm = new DefaultTableModel(rowdata,colname) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		aTable = new JTable(aDtm);
		aJsp = new JScrollPane(aTable);
		aBorder = new TitledBorder("수강신청 테이블");
		aJsp.setBorder(aBorder);
		aJsp.setBounds(5,400,575,170);
		aTable.setRowHeight(20);
		add(aJsp);
		
		btnPanel = new JPanel();
		btnPanel.setBounds(5,600,575,100);
		btnPanel.setLayout(null);
		add(btnPanel);
		
		font = new Font("굴림", Font.BOLD, 20);
		
		delBtn = new JButton("삭제");
		delBtn.setFont(font);
		delBtn.setBackground(Color.red);
		delBtn.setForeground(Color.LIGHT_GRAY);
		delBtn.setBounds(300,10,130,40);
		
		exitBtn = new JButton("종료");
		exitBtn.setFont(font);
		exitBtn.setBackground(Color.green);
		exitBtn.setForeground(Color.magenta);
		exitBtn.setBounds(440,10,130,40);
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				univMenu.show();
			}
		});

		btnPanel.add(delBtn);
		btnPanel.add(exitBtn);
		
		getListSub();
		getListAtd(univMenu.usercode);
		
		sBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				if (sBox.getSelectedIndex() != 0)
//					searchSub(getDeptNum(sBox.getSelectedItem().toString()));
				search1Field.setText(getDeptNum(sBox.getSelectedItem().toString()));
				search2Field.setText(sBox.getSelectedItem().toString());
			}
		});
		
		sTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sTableRow = sTable.getSelectedRow();
				
				String subCode = sTable.getValueAt(sTableRow, 0).toString();
				String subName = sTable.getValueAt(sTableRow, 1).toString();
				String deptName = sTable.getValueAt(sTableRow, 2).toString();
				String hour = sTable.getValueAt(sTableRow, 3).toString();
				String profName = sTable.getValueAt(sTableRow, 4).toString();
				String credit = sTable.getValueAt(sTableRow, 5).toString();
				
//				for (int i = 0; i < aTable.getRowCount(); i++) {
//					if (subCode.equals(aTable.getValueAt(i, 0))) {
//						JOptionPane.showMessageDialog(null, "이미 신청한 교과목입니다.");
//						return;
//					}
//				}

				int i = JOptionPane.showConfirmDialog(null, subName+" 수강을 신청하시겠습니까?", "수강신청", JOptionPane.YES_NO_OPTION);
				if (i == 0) {
					if (isAttended()) {
						JOptionPane.showMessageDialog(null, "이미 신청한 교과목입니다.");
						return;
					}
					else {
						int result = attend(univMenu.usercode, getProfCode(profName), subCode, getYear(subCode));
						
						if (result != 0) {
							JOptionPane.showMessageDialog(null, "수강신청이 완료되었습니다.");
							addResult(getProfCode(profName), univMenu.usercode, subCode, getYear(subCode), getGrade(subCode), getTerm(subCode));
							getListAtd(univMenu.usercode);
							getListSub();
						}
					}
				}
			}
		});
		
		aTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aTableRow = aTable.getSelectedRow();
			}
		});
		
		delBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (aTableRow == -1) {
					JOptionPane.showMessageDialog(null, "삭제할 행을 선택하세요.");
					return;
				}
				
				String subName = aTable.getValueAt(aTableRow, 1).toString();
				String subCode = aTable.getValueAt(aTableRow, 0).toString();

				int i = JOptionPane.showConfirmDialog(null, subName+" 수강을 취소하시겠습니까?", "취소", JOptionPane.YES_NO_OPTION);
				
				if (i == 0) {
					int result = delete(subCode);
					
					if (result != 0) {
						JOptionPane.showMessageDialog(null, subName+" 수강을 취소했습니다.");
						delResult(subCode);
						getListSub();
						getListAtd(univMenu.usercode);
						aTableRow = -1;
					}
				}
				else
					return;
			}
		});
		
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sBox.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "개설학과를 선택하세요.");
					return;
				}
				
				searchSub(search1Field.getText());

//				if (searchField.getText().isEmpty()) {
//					JOptionPane.showMessageDialog(null, "조회할 정보를 입력하세요.");
//					searchField.requestFocus();
//					return;
//				}
//				
//				search();
//				reset();
//				selectRow = -1;
//				searchField.setText("");
//				
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
		
		searchAllBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				getListAll();
//				reset();
//				selectRow = -1;
				getListSub();
			}
		});
		
		setSize(600,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public boolean isAttended() {
		boolean result = false;
		String quary = "select subj_code from attended where std_code = ? and subj_code = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, univMenu.usercode);
			pstmt.setString(2, sTable.getValueAt(sTableRow, 0).toString());
			rs = pstmt.executeQuery();
			if (rs.next())
				result = true;
			else
				result = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int attend(String std_code, String prof_code, String subj_code, String year) {
		int result = 0;
		String quary = "insert into attended(std_code,prof_code,subj_code,year) values(?,?,?,?)";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, std_code);
			pstmt.setString(2, prof_code);
			pstmt.setString(3, subj_code);
			pstmt.setString(4, year);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int addResult(String prof_code, String std_code, String subj_code, String year, String grade, String term) {
		int result = 0;
		String quary = "insert into results(prof_code,std_code,subj_code,year,grade,term,middle,final,"
				+ "report,attended,added,sum) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, prof_code);
			pstmt.setString(2, std_code);
			pstmt.setString(3, subj_code);
			pstmt.setString(4, year);
			pstmt.setString(5, grade);
			pstmt.setString(6, term);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			pstmt.setInt(11, 0);
			pstmt.setInt(12, 0);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void searchSub(String deptCode) {
		sDtm.setRowCount(0);
		String quary = "select code, subject, dept_code, hour, prof_code, credit"
				+ " from subject where dept_code = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, deptCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String subjectNum = rs.getString(1);
				String subjectName = rs.getString(2);
				String dept_code = rs.getString(3);
				String hour = rs.getString(4);
				String prof_code = rs.getString(5);
				String credit = rs.getString(6);
				String[] data = {subjectNum,subjectName,getDeptName(dept_code),hour,getProfName(prof_code),credit};
				
				sDtm.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getListSub() {
		sDtm.setRowCount(0);
		String quary = "select code, subject, dept_code, hour, prof_code, credit from subject "
				+ "where code not in (select subj_code from attended where std_code = ?)";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, sCodeField.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String subjectNum = rs.getString(1);
				String subjectName = rs.getString(2);
				String dept_code = rs.getString(3);
				String hour = rs.getString(4);
				String prof_code = rs.getString(5);
				String credit = rs.getString(6);
				String[] data = {subjectNum,subjectName,getDeptName(dept_code),hour,getProfName(prof_code),credit};
				
				sDtm.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getListAtd(String stdCode) {
		aDtm.setRowCount(0);
		String quary = "select code, subject, dept_code, hour, subject.prof_code, credit"
				+ " from subject, attended where std_code = ? and subj_code = code";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, stdCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String subNum = rs.getString(1);
				String subName = rs.getString(2);
				String dept_code = rs.getString(3);
				String hour = rs.getString(4);
				String prof_code = rs.getString(5);
				String credit = rs.getString(6);
				String[] data = {subNum,subName,getDeptName(dept_code),hour,getProfName(prof_code),credit};
				
				aDtm.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addDept() {
		sBox.addItem("개설학과를 선택하세요");
		String quary = "select deptName from department";
		
		try {
			//pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				sBox.addItem(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getStdData() {
		String quary = "select name, dept_code from student where sNum = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, univMenu.usercode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stdName = rs.getString(1);
				stdDept = rs.getString(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getSubCode() {
		String subCode = "";
		String quary = "select subj_code from attended where std_code = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, sCodeField.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				subCode = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subCode;
	}
	
	public String getYear(String subCode) {
		String quary = "select year from subject where code = ?";
		String year = "";
		try {
			//pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, subCode);
			rs1 = pstmt.executeQuery();
			while (rs1.next()) {
				year = rs1.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return year;
	}
	
	public String getGrade(String subCode) {
		String quary = "select grade from subject where code = ?";
		String grade = "";
		try {
			//pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, subCode);
			rs1 = pstmt.executeQuery();
			while (rs1.next()) {
				grade = rs1.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grade;
	}
	
	public String getTerm(String subCode) {
		String quary = "select term from subject where code = ?";
		String term = "";
		try {
			//pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, subCode);
			rs1 = pstmt.executeQuery();
			while (rs1.next()) {
				term = rs1.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return term;
	}
	
	public String getDeptNum(String deptName) {
		String quary = "select deptNum from department where deptName = ?";
		String deptNum = "";
		try {
			//pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, deptName);
			rs1 = pstmt.executeQuery();
			while (rs1.next()) {
				deptNum = rs1.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deptNum;
	}
	
	public String getDeptName(String deptNum) {
		String quary = "select deptName from department where deptNum = ?";
		String deptName = "";
		try {
			//pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, deptNum);
			rs1 = pstmt.executeQuery();
			while (rs1.next()) {
				deptName = rs1.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deptName;
	}
	
	public String getProfCode(String profName) {
		String quary = "select pCode from professor where name = ?";
		String profCode = "";
		try {
			//pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, profName);
			rs1 = pstmt.executeQuery();
			while (rs1.next()) {
				profCode = rs1.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return profCode;
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
	
//	public int insert(String subCode, String subName, String dept, String hour, String prof, String credit) {
//		int result = 0;
//		String quary = "insert into attended(subCode,subName,dept,hour,prof,credit) values(?,?,?,?,?,?)";
//		
//		try {
//			pstmt = connector.conn.prepareStatement(quary);
//			pstmt.setString(1, subCode);
//			pstmt.setString(2, subName);
//			pstmt.setString(3, dept);
//			pstmt.setString(4, hour);
//			pstmt.setString(5, prof);
//			pstmt.setString(6, credit);
//			
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return result;
//	}
	
//	public int update(String dName, String mName, String dCode) {
//		int result = 0;
//		String quary = "update department set deptName = ?, majorName = ? where deptNum = ?";
//		
//		try {
//			pstmt = connector.conn.prepareStatement(quary);
//			pstmt.setString(1, dName);
//			pstmt.setString(2, mName);
//			pstmt.setString(3, dCode);
//			
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return result;
//	}
	
	public int delete(String subCode) {
		int result = 0;
		String quary = "delete from attended where std_code = ? and subj_code = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, univMenu.usercode);
			pstmt.setString(2, subCode);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int delResult(String subCode) {
		int result = 0;
		String quary = "delete from results where std_code = ? and subj_code = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, univMenu.usercode);
			pstmt.setString(2, subCode);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
//	public void search() {
//		dtm.setRowCount(0);
//		
//		try {
//			pstmt = connector.conn.prepareStatement(sQuary);
//			pstmt.setString(1, searchField.getText());
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				String dCode = rs.getString(1);
//				String dName = rs.getString(2);
//				String mName = rs.getString(3);
//				
//				String[] data = {dCode,dName,mName};
//				
//				dtm.addRow(data);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
//	public void reset() {
//		sCodeField.setText("");
//		nameField.setText("");
//		deptField.setText("");
//		sCodeField.requestFocus();
//	}
	
//	public void check() {
//		if (sCodeField.getText().isEmpty()) {
//			JOptionPane.showMessageDialog(null, "학과코드를 입력하세요.");
//			sCodeField.requestFocus();
//			isEmpty = true;
//			return;
//		}
//		else if (nameField.getText().isEmpty()) {
//			JOptionPane.showMessageDialog(null, "학과명 입력하세요.");
//			nameField.requestFocus();
//			isEmpty = true;
//			return;
//		}
//		
//		else if (deptField.getText().isEmpty()) {
//			JOptionPane.showMessageDialog(null, "전공명을 입력하세요.");
//			deptField.requestFocus();
//			isEmpty = true;
//			return;
//		}
//		
//		isEmpty = false;
//	}
	
//	public static void main(String[] args) {
//		new Attended();
//	}
}
