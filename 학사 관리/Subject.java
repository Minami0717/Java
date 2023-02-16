package univ;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

public class Subject extends JFrame {

	JPanel titlePanel, inputPanel, searchPanel, btnPanel;
	JLabel titleLabel, sCodeLabel, sNameLabel, yearLabel, deptLabel, gradeLabel, termLabel,
	hourLabel, profLabel, creditLabel;
	JTextField sCodeField, sNameField, hourField, creditField, searchField;
	JComboBox yBox, dBox, gBox, tBox, pBox, sBox;
	JButton searchBtn, searchAllBtn, inputBtn, editBtn, delBtn, exitBtn;
	TitledBorder iBorder, tBorder;
	DefaultTableModel dtm;
	JTable table;
	JScrollPane jsp;
	PreparedStatement pstmt;
	ResultSet rs,rs1;
	int selectRow = -1;
	boolean isEmpty = false;
	Font font;
	Image logo;
	UnivMenu univMenu;
	
	Subject(UnivMenu univMenu){
		this.univMenu = univMenu;
		
		setLayout(null);
		setTitle("교과목 관리");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		logo = tk.getImage("C:\\Users\\kcd\\Desktop\\자바\\이미지/주소록.png");
		setIconImage(logo);
		
		titlePanel = new JPanel();
		titlePanel.setBounds(0,0,700,50);
		titlePanel.setBackground(Color.black);
		add(titlePanel);
		
		titleLabel = new JLabel("교과목 관 리");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		titlePanel.add(titleLabel);
		
		inputPanel = new JPanel();
		iBorder = new TitledBorder("입력");
		inputPanel.setBorder(iBorder);
		inputPanel.setBounds(5,55,675,200);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		sCodeLabel = new JLabel("교과목코드");
		sCodeLabel.setBounds(20,20,70,20);
		inputPanel.add(sCodeLabel);
		
		sCodeField = new JTextField();
		sCodeField.setBounds(100,20,100,25);
		inputPanel.add(sCodeField);
		
		sNameLabel = new JLabel("개설강좌명");
		sNameLabel.setBounds(220,20,70,20);
		inputPanel.add(sNameLabel);
		
		sNameField = new JTextField();
		sNameField.setBounds(300,20,100,25);
		inputPanel.add(sNameField);
		
		yearLabel = new JLabel("개설년도");
		yearLabel.setBounds(420,20,50,20);
		inputPanel.add(yearLabel);
		
		String[] y = {"2021","2022","2023","2024"};
		yBox = new JComboBox(y);
		yBox.setBounds(490,20,100,25);
		inputPanel.add(yBox);
		
		deptLabel = new JLabel("개설학과");
		deptLabel.setBounds(20,60,50,20);
		inputPanel.add(deptLabel);
		
		//String[] d = {"개설학과","컴퓨터공학","방사선","물리치료","사무자동화","간호1"};
		dBox = new JComboBox();
		dBox.addItem("개설학과");
		addDept();
		dBox.setBounds(100,60,100,25);
		inputPanel.add(dBox);
		
		deptLabel = new JLabel("개설학년");
		deptLabel.setBounds(220,60,50,20);
		inputPanel.add(deptLabel);
		
		String[] g = {"1학년","2학년","3학년","4학년"};
		gBox = new JComboBox(g);
		gBox.setBounds(300,60,100,25);
		inputPanel.add(gBox);
		
		deptLabel = new JLabel("개설학기");
		deptLabel.setBounds(420,60,50,20);
		inputPanel.add(deptLabel);
		
		String[] t = {"1학기","2학기","3여름학기","4겨울학기"};
		tBox = new JComboBox(t);
		tBox.setBounds(490,60,100,25);
		inputPanel.add(tBox);
		
		hourLabel = new JLabel("수업시수");
		hourLabel.setBounds(20,100,50,20);
		inputPanel.add(hourLabel);
		
		hourField = new JTextField();
		hourField.setBounds(100,100,100,25);
		inputPanel.add(hourField);
		
		profLabel = new JLabel("담당교수");
		profLabel.setBounds(220,100,50,20);
		inputPanel.add(profLabel);
		
		//String[] p = {"담당교수","김하나","김두리","정교수"};
		pBox = new JComboBox();
		pBox.addItem("담당교수");
		addProf();
		pBox.setBounds(300,100,100,25);
		inputPanel.add(pBox);
		
		creditLabel = new JLabel("개설학점");
		creditLabel.setBounds(420,100,50,20);
		inputPanel.add(creditLabel);
		
		creditField = new JTextField();
		creditField.setBounds(490,100,100,25);
		inputPanel.add(creditField);
		
		searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBounds(0,260,700,50);
		searchPanel.setBackground(Color.cyan);
		add(searchPanel);
		
		String[] s = {"검색할 카테고리를 선택하세요","code","subject","dept_code","prof_code","year"};
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
		searchBtn.setBounds(450,12,85,25);
		searchBtn.setBackground(Color.DARK_GRAY);
		searchBtn.setForeground(Color.pink);
		searchPanel.add(searchBtn);
		
		searchAllBtn = new JButton("전체조회");
		searchAllBtn.setBounds(550,12,85,25);
		searchAllBtn.setBackground(Color.DARK_GRAY);
		searchAllBtn.setForeground(Color.pink);
		searchPanel.add(searchAllBtn);

		String[][] rowdata = {};
		String[] colname = {"교과코드","교과명","개설학과","개설년도","개설학년","개설학기","수업시수","담당교수","학점"};
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
		jsp.setBounds(5,315,675,250);
		table.setRowHeight(20);
		add(jsp);
		
		btnPanel = new JPanel();
		btnPanel.setBounds(5,600,675,50);
		btnPanel.setLayout(new GridLayout(0,4,5,5));
		add(btnPanel);
		
		font = new Font("굴림", Font.BOLD, 20);
		
		inputBtn = new JButton("등록");
		inputBtn.setFont(font);
		inputBtn.setBackground(Color.orange);
		inputBtn.setForeground(Color.blue);
		
		editBtn = new JButton("수정");
		editBtn.setFont(font);
		editBtn.setBackground(Color.gray);
		editBtn.setForeground(Color.yellow);
		
		delBtn = new JButton("삭제");
		delBtn.setFont(font);
		delBtn.setBackground(Color.red);
		delBtn.setForeground(Color.LIGHT_GRAY);
		
		exitBtn = new JButton("종료");
		exitBtn.setFont(font);
		exitBtn.setBackground(Color.green);
		exitBtn.setForeground(Color.magenta);
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				univMenu.show();
			}
		});

		btnPanel.add(inputBtn);
		btnPanel.add(editBtn);
		btnPanel.add(delBtn);
		btnPanel.add(exitBtn);
		
		getListAll();
		
		sBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sBox.getSelectedIndex() != 0)
					searchField.requestFocus();
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectRow = table.getSelectedRow();
				
				sCodeField.setText(table.getValueAt(selectRow, 0).toString());
				sNameField.setText(table.getValueAt(selectRow, 1).toString());
				hourField.setText(table.getValueAt(selectRow, 6).toString());
				creditField.setText(table.getValueAt(selectRow, 8).toString());
				
				yBox.setSelectedItem(table.getValueAt(selectRow, 3));
				dBox.setSelectedItem(table.getValueAt(selectRow, 2));
				gBox.setSelectedItem(table.getValueAt(selectRow, 4));
				tBox.setSelectedItem(table.getValueAt(selectRow, 5));
				pBox.setSelectedItem(table.getValueAt(selectRow, 7));
				
//				if(table.isRowSelected(selectRow))
//					table.clearSelection();
			}
		});
		
		inputBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				check();
				if (isEmpty || isSameData())
					return;
				
				String y = yBox.getSelectedItem().toString();
				String d = dBox.getSelectedItem().toString();
				String g = gBox.getSelectedItem().toString();
				String t = tBox.getSelectedItem().toString();
				String p = pBox.getSelectedItem().toString();
				
				int result = insert(sCodeField.getText(), sNameField.getText(), getDeptNum(d), y, g, t,
						hourField.getText(), getProfCode(p), creditField.getText());
				
				if (result != 0) {
					JOptionPane.showMessageDialog(null, sCodeField.getText()+"의 정보가 입력되었습니다.");
					getListAll();
					reset();
				}
			}
		});
		
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectRow == -1) {
					JOptionPane.showMessageDialog(null, "수정할 행을 선택하세요.");
					return;
				}
				if (!sCodeField.getText().equals(table.getValueAt(selectRow, 0))) {
					JOptionPane.showMessageDialog(null, "교과목코드는 수정할 수 없습니다.");
					sCodeField.setText(table.getValueAt(selectRow, 0).toString());
					sCodeField.requestFocus();
					return;
				}
				
				String sCode = table.getValueAt(selectRow, 0).toString();
				String y = yBox.getSelectedItem().toString();
				String d = dBox.getSelectedItem().toString();
				String g = gBox.getSelectedItem().toString();
				String t = tBox.getSelectedItem().toString();
				String p = pBox.getSelectedItem().toString();
				
				int result = update(sCode, sNameField.getText(), getDeptNum(d), y, g, t,
						hourField.getText(), getProfCode(p), creditField.getText());
				
				if (result != 0) {
					JOptionPane.showMessageDialog(null, sCode+"의 정보를 수정했습니다.");
					getListAll();
					reset();
					selectRow = -1;
				}
			}
		});
		
		delBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectRow == -1) {
					JOptionPane.showMessageDialog(null, "삭제할 행을 선택하세요.");
					return;
				}
				
				String sCode = table.getValueAt(selectRow, 0).toString();
				
				int i = JOptionPane.showConfirmDialog(null, sCode+"의 정보를 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				
				if (i == 0) {
					int result = delete(sCode);
					
					if (result != 0) {
						JOptionPane.showMessageDialog(null, sCode+"의 정보를 삭제했습니다.");
						getListAll();
						reset();
						selectRow = -1;
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
					JOptionPane.showMessageDialog(null, "카테고리를 선택하세요.");
					sBox.requestFocus();
					return;
				}
				
				if (searchField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "조회할 정보를 입력하세요.");
					searchField.requestFocus();
					return;
				}
				
				search();
				reset();
				selectRow = -1;
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
		
		searchAllBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getListAll();
				reset();
				selectRow = -1;
			}
		});
		
		sCodeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (sCodeField.getText().length() == 2 && e.paramString().indexOf("Backspace") == -1)
					sNameField.requestFocus();
			}
		});
		hourField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				pBox.requestFocus();
			}
		});
		
		setSize(700,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void getListAll() {
		dtm.setRowCount(0);
		String quary = "select * from subject";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String subjectNum = rs.getString(1);
				String subjectName = rs.getString(2);
				String deptCode = rs.getString(3);
				String year = rs.getString(4);
				String grade = rs.getString(5);
				String term = rs.getString(6);
				String hour = rs.getString(7);
				String profCode = rs.getString(8);
				String credit = rs.getString(9);
				String[] data = {subjectNum,subjectName,getDeptName(deptCode),year,grade,term,hour,getProfName(profCode),credit};
				
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addDept() {
		String quary = "select deptName from department";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			//pstmt = connector.conn.prepareStatement(quary);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				dBox.addItem(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addProf() {
		String quary = "select name from professor";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			//pstmt = connector.conn.prepareStatement(quary);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				pBox.addItem(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getDeptNum(String deptName) {
		String quary = "select deptNum from department where deptName = ?";
		String deptNum = "";
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, deptName);
			//pstmt = connector.conn.prepareStatement(quary);
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
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, deptNum);
			//pstmt = connector.conn.prepareStatement(quary);
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
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, profName);
			//pstmt = connector.conn.prepareStatement(quary);
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
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, profCode);
			//pstmt = connector.conn.prepareStatement(quary);
			rs1 = pstmt.executeQuery();
			while (rs1.next()) {
				profName = rs1.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return profName;
	}
	
	public int insert(String sCode, String sName, String dName,String year,String grade,String term,
			String hour,String profName,String credit) {
		int result = 0;
		String quary = "insert into subject values(?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, sCode);
			pstmt.setString(2, sName);
			pstmt.setString(3, dName);
			pstmt.setString(4, year);
			pstmt.setString(5, grade);
			pstmt.setString(6, term);
			pstmt.setString(7, hour);
			pstmt.setString(8, profName);
			pstmt.setString(9, credit);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int update(String sCode, String sName, String dName,String year,String grade,String term,
			String hour,String profName,String credit) {
		int result = 0;
		String quary = "update subject set subject = ?, dept_code = ?, year = ?, grade = ?,"
				+ "term = ?, hour = ?, prof_code = ?, credit = ? where code = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, sName);
			pstmt.setString(2, dName);
			pstmt.setString(3, year);
			pstmt.setString(4, grade);
			pstmt.setString(5, term);
			pstmt.setString(6, hour);
			pstmt.setString(7, profName);
			pstmt.setString(8, credit);			
			pstmt.setString(9, sCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int delete(String sCode) {
		int result = 0;
		String quary = "delete from subject where code = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, sCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void search() {
		dtm.setRowCount(0);
		String quary = "select * from subject where " + sBox.getSelectedItem().toString() + " = '" + searchField.getText() + "'";
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					String subjectNum = rs.getString(1);
					String subjectName = rs.getString(2);
					String deptCode = rs.getString(3);
					String year = rs.getString(4);
					String grade = rs.getString(5);
					String term = rs.getString(6);
					String hour = rs.getString(7);
					String profCode = rs.getString(8);
					String credit = rs.getString(9);
					String[] data = {subjectNum,subjectName,getDeptName(deptCode),year,grade,term,hour,getProfName(profCode),credit};
					
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
	
	public void reset() {
		sCodeField.setText("");
		sNameField.setText("");
		hourField.setText("");
		creditField.setText("");
		dBox.setSelectedIndex(0);
		pBox.setSelectedIndex(0);
		sCodeField.requestFocus();
	}
	
	public void check() {
		if (sCodeField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "교과목코드를 입력하세요.");
			sCodeField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (sNameField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "개설강좌명 입력하세요.");
			sNameField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (dBox.getSelectedItem().equals("개설학과")) {
			JOptionPane.showMessageDialog(null, "개설학과를 선택하세요.");
			dBox.requestFocus();
			isEmpty = true;
			return;
		}
		else if (hourField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "수업시수를 입력하세요.");
			hourField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (pBox.getSelectedItem().equals("담당교수")) {
			JOptionPane.showMessageDialog(null, "담당교수를 선택하세요.");
			pBox.requestFocus();
			isEmpty = true;
			return;
		}
		else if (creditField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "개설학점을 입력하세요.");
			creditField.requestFocus();
			isEmpty = true;
			return;
		}
		
		isEmpty = false;
	}
	
	public boolean isSameData() {
		String quary = "select code from subject where code = ?";
		boolean sameData = false;
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, sCodeField.getText());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "같은 교과코드가 있습니다.");
				sCodeField.setText("");
				sCodeField.requestFocus();
				sameData = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sameData;
	}
	
//	public static void main(String[] args){
//		new Subject();
//	}
}
