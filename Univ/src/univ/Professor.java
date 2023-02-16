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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Professor extends JFrame {

	JPanel titlePanel, inputPanel, searchPanel, btnPanel;
	JLabel titleLabel, pCodeLabel, nameLabel, rNumLabel, genderLabel, adrLabel, pNumLabel, tNumLabel,
	hyphen1, hyphen2, hyphen3, degreeLabel, officeLabel, deptLabel, yearLabel;
	JTextField pCodeField, nameField, rFirstField, rSecondField, adrField, tNumField, degreeField,
	yearField, pFirstField, pSecondField, pThirdField, officeField, searchField;
	JComboBox dBox, sBox;
	JRadioButton male, female;
	ButtonGroup group;
	JButton searchBtn, searchAllBtn, inputBtn, editBtn, delBtn, exitBtn;
	TitledBorder iBorder, tBorder;
	DefaultTableModel dtm;
	JTable table;
	JScrollPane jsp;
	PreparedStatement pstmt;
	ResultSet rs,rs1;
	int selectRow = -1;
	int pCode;
	boolean isEmpty = false;
	boolean isSearch = false;
	Font font;
	Image logo;
	UnivMenu univMenu;
	//Connector connector;
	
	Professor(UnivMenu univMenu){
		//connector = new Connector();
		this.univMenu = univMenu;
		setLayout(null);
		setTitle("교수관리");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		logo = tk.getImage("C:\\Users\\kcd\\Desktop\\자바\\이미지/주소록.png");
		setIconImage(logo);
		
		titlePanel = new JPanel();
		titlePanel.setBounds(0,0,700,50);
		titlePanel.setBackground(Color.black);
		add(titlePanel);
		
		titleLabel = new JLabel("교 수 관 리");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		titlePanel.add(titleLabel);
		
		inputPanel = new JPanel();
		iBorder = new TitledBorder("입력");
		inputPanel.setBorder(iBorder);
		inputPanel.setBounds(5,55,675,200);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		pCodeLabel = new JLabel("교수코드");
		pCodeLabel.setBounds(20,20,50,20);
		inputPanel.add(pCodeLabel);
		
		pCodeField = new JTextField();
		pCodeField.setBounds(80,20,100,25);
		inputPanel.add(pCodeField);
		
		nameLabel = new JLabel("이름");
		nameLabel.setBounds(200,20,40,20);
		inputPanel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(240,20,100,25);
		inputPanel.add(nameField);
		
		rNumLabel = new JLabel("주민번호");
		rNumLabel.setBounds(350,20,50,20);
		inputPanel.add(rNumLabel);
		
		rFirstField = new JTextField();
		rFirstField.setBounds(410,20,100,25);
		inputPanel.add(rFirstField);
		
		hyphen1 = new JLabel("-");
		hyphen1.setBounds(517,20,10,20);
		inputPanel.add(hyphen1);
		
		rSecondField = new JTextField();
		rSecondField.setBounds(530,20,100,25);
		inputPanel.add(rSecondField);
		
		adrLabel = new JLabel("주 소");
		adrLabel.setBounds(20,55,30,20);
		inputPanel.add(adrLabel);
		
		adrField = new JTextField();
		adrField.setBounds(80,55,550,25);
		inputPanel.add(adrField);
		
		pNumLabel = new JLabel("휴대폰");
		pNumLabel.setBounds(20,90,40,20);
		inputPanel.add(pNumLabel);
		
		pFirstField = new JTextField();
		pFirstField.setBounds(80,90,100,25);
		inputPanel.add(pFirstField);
		
		hyphen1 = new JLabel("-");
		hyphen1.setBounds(188,90,5,20);
		inputPanel.add(hyphen1);
		
		pSecondField = new JTextField();
		pSecondField.setBounds(200,90,100,25);
		inputPanel.add(pSecondField);
		
		hyphen2 = new JLabel("-");
		hyphen2.setBounds(308,90,5,20);
		inputPanel.add(hyphen2);
		
		pThirdField = new JTextField();
		pThirdField.setBounds(320,90,100,25);
		inputPanel.add(pThirdField);
		
		tNumLabel = new JLabel("전화번호");
		tNumLabel.setBounds(430,90,50,20);
		inputPanel.add(tNumLabel);
		
		tNumField = new JTextField();
		tNumField.setBounds(490,90,140,25);
		inputPanel.add(tNumField);
		
		yearLabel = new JLabel("임용년도");
		yearLabel.setBounds(20,125,50,20);
		inputPanel.add(yearLabel);
		
		yearField = new JTextField();
		yearField.setBounds(80,125,100,25);
		inputPanel.add(yearField);
		
		degreeLabel = new JLabel("학위");
		degreeLabel.setBounds(250,125,30,20);
		inputPanel.add(degreeLabel);
		
		degreeField = new JTextField();
		degreeField.setBounds(290,125,130,25);
		inputPanel.add(degreeField);
		
		deptLabel = new JLabel("학과");
		deptLabel.setBounds(450,125,30,20);
		inputPanel.add(deptLabel);
		
		//String[] d = {"개설학과","컴퓨터공학","방사선","물리치료","사무자동화","간호1"};
		dBox = new JComboBox();
		dBox.addItem("개설학과");
		addDept();
		dBox.setBounds(490,125,140,25);
		inputPanel.add(dBox);
		
		officeLabel = new JLabel("연구실");
		officeLabel.setBounds(20,160,40,20);
		inputPanel.add(officeLabel);
		
		officeField = new JTextField();
		officeField.setBounds(80,160,140,25);
		inputPanel.add(officeField);
		
		genderLabel = new JLabel("성 별");
		genderLabel.setBounds(250,160,30,20);
		inputPanel.add(genderLabel);
		
		male = new JRadioButton("남자");
		male.setBounds(290,160,50,20);
		inputPanel.add(male);
		
		female = new JRadioButton("여자");
		female.setBounds(350,160,50,20);
		inputPanel.add(female);
		
		group = new ButtonGroup();
		group.add(male);
		group.add(female);
		
		searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBounds(0,260,700,50);
		searchPanel.setBackground(Color.cyan);
		add(searchPanel);
		
		String[] s = {"교수코드","교수명","학과명","성별","검색할 카테고리를 선택하세요"};
		sBox = new JComboBox(s);
		sBox.setSelectedIndex(4);
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
		String[] colname = {"교수코드","이름","주소","주민등록번호","휴대폰","전화","임용년도","학위","학과","연구실","성별"};
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
				if (sBox.getSelectedIndex() != 4)
					searchField.requestFocus();
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectRow = table.getSelectedRow();
				
				String[] pNum = table.getValueAt(selectRow, 4).toString().split("-");
				String[] rNum = table.getValueAt(selectRow, 3).toString().split("-");
				
				pCodeField.setText(table.getValueAt(selectRow, 0).toString());
				nameField.setText(table.getValueAt(selectRow, 1).toString());
				adrField.setText(table.getValueAt(selectRow, 2).toString());
				tNumField.setText(table.getValueAt(selectRow, 5).toString());
				yearField.setText(table.getValueAt(selectRow, 6).toString());
				degreeField.setText(table.getValueAt(selectRow, 7).toString());
				officeField.setText(table.getValueAt(selectRow, 9).toString());
				
				rFirstField.setText(rNum[0]);
				rSecondField.setText(rNum[1]);
				pFirstField.setText(pNum[0]);
				pSecondField.setText(pNum[1]);
				pThirdField.setText(pNum[2]);
				
				if (table.getValueAt(selectRow, 10).toString().equals("남자"))
					male.setSelected(true);
				else if (table.getValueAt(selectRow, 10).toString().equals("여자"))
					female.setSelected(true);
				
				dBox.setSelectedItem(table.getValueAt(selectRow, 8));
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
				
				String rNum = rFirstField.getText() + "-" + rSecondField.getText();
				String pNum = pFirstField.getText() + "-" + pSecondField.getText() + "-" + pThirdField.getText();
				String dept = dBox.getSelectedItem().toString();
				String gender = "";
				String tel = tNumField.getText();
				
				if (tNumField.getText().length() == 8)
					tel = "(053)" + tNumField.getText();
				
				if (male.isSelected())
					gender = "남자";
				else if (female.isSelected())
					gender = "여자";
				
				int result = insert(pCodeField.getText(), nameField.getText(), adrField.getText(),
						rNum, pNum, tel, yearField.getText(), degreeField.getText(),
						getDeptNum(dept), officeField.getText(), gender);
				
				if (result != 0) {
					JOptionPane.showMessageDialog(null, pCodeField.getText()+"의 교수 정보가 입력되었습니다.");
					getListAll();
					reset();
				}
			}
		});
		
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				check();
				if (isEmpty == true)
					return;
				if (selectRow == -1) {
					JOptionPane.showMessageDialog(null, "수정할 행을 선택하세요.");
					return;
				}
				if (!pCodeField.getText().equals(table.getValueAt(selectRow, 0))) {
					JOptionPane.showMessageDialog(null, "교수코드는 수정할 수 없습니다.");
					pCodeField.setText(table.getValueAt(selectRow, 0).toString());
					pCodeField.requestFocus();
					return;
				}
				
				String pCode = table.getValueAt(selectRow, 0).toString();
				String rNum = rFirstField.getText() + "-" + rSecondField.getText();
				String pNum = pFirstField.getText() + "-" + pSecondField.getText() + "-" + pThirdField.getText();
				String dept = dBox.getSelectedItem().toString();
				String gender = "";
				
				if (male.isSelected())
					gender = "남자";
				else if (female.isSelected())
					gender = "여자";
				
				int result = update(pCode, nameField.getText(), adrField.getText(),
						rNum, pNum, tNumField.getText(), yearField.getText(), degreeField.getText(),
						getDeptNum(dept), officeField.getText(), gender);
				
				if (result != 0) {
					JOptionPane.showMessageDialog(null, pCode+"의 교수 정보를 수정했습니다.");
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
				
				String pCode = table.getValueAt(selectRow, 0).toString();
				
				int i = JOptionPane.showConfirmDialog(null, pCode+"의 교수 정보를 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				
				if (i == 0) {
					int result = delete(pCode);
					
					if (result != 0) {
						JOptionPane.showMessageDialog(null, pCode+"의 교수 정보를 삭제했습니다.");
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
				if (sBox.getSelectedIndex() == 4) {
					JOptionPane.showMessageDialog(null, "카테고리를 선택하세요.");
					sBox.requestFocus();
					return;
				}
				
				if (searchField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "조회할 정보를 입력하세요.");
					searchField.requestFocus();
					return;
				}
				
				String[] field = {"pCode","name","deptNum","gender"};
				String s = field[sBox.getSelectedIndex()];
				
				search(s);
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
		
		pCodeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (pCodeField.getText().length() == 3 && e.paramString().indexOf("Backspace") == -1)
					nameField.requestFocus();
			}
		});
		
		rFirstField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (rFirstField.getText().length() == 5)
					rSecondField.requestFocus();
			}
		});
		
		rSecondField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (rSecondField.getText().length() == 6)
					adrField.requestFocus();
			}
		});
		
		pFirstField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (pFirstField.getText().length() == 2)
					pSecondField.requestFocus();
			}
		});
		
		pSecondField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (pSecondField.getText().length() == 3)
					pThirdField.requestFocus();
			}
		});
		
		pThirdField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (pThirdField.getText().length() == 3)
					tNumField.requestFocus();
			}
		});
		
		tNumField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (tNumField.getText().length() == 7)
					yearField.requestFocus();
			}
		});
		
		yearField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (yearField.getText().length() == 3)
					degreeField.requestFocus();
			}
		});
		
		setSize(700,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void getListAll() {
		dtm.setRowCount(0);
		String quary = "select * from professor";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			//pstmt = connector.conn.prepareStatement(quary);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String pCode = rs.getString(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				String rNum = rs.getString(4);
				String phone = rs.getString(5);
				String tel = rs.getString(6);
				String year = rs.getString(7);
				String degree = rs.getString(8);
				String deptNum = rs.getString(9);
				String office = rs.getString(10);
				String gender = rs.getString(11);
				
				String[] data = {pCode,name,addr,rNum,phone,tel,year,degree,getDeptName(deptNum),office,gender};
				
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
	
	public String getDeptNum(String deptName) {
		String quary = "select deptNum from department where deptName = ?";
		String dNum = "";
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, deptName);
			//pstmt = connector.conn.prepareStatement(quary);
			rs1 = pstmt.executeQuery();
			while (rs1.next()) {
				dNum = rs1.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dNum;
	}
	
	public String getDeptName(String deptNum) {
		String quary = "select deptName from department where deptNum = ?";
		String dName = "";
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, deptNum);
			//pstmt = connector.conn.prepareStatement(quary);
			rs1 = pstmt.executeQuery();
			while (rs1.next()) {
				dName = rs1.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dName;
	}
	
	public String searchDept(String deptNum) {
		String quary = "select deptNum from professor where deptNum = ?";
		String dNum = null;
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, deptNum);
			//pstmt = connector.conn.prepareStatement(quary);
			rs1 = pstmt.executeQuery();
			while (rs1.next()) {
				dNum = rs1.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dNum;
	}
	
	public int insert(String pCode, String name, String addr, String rNum, String phone, String tel,
			 String year, String degree, String dept, String office, String gender) {
		int result = 0;
		String quary = "insert into professor values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, pCode);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			pstmt.setString(4, rNum);
			pstmt.setString(5, phone);
			pstmt.setString(6, tel);
			pstmt.setString(7, year);
			pstmt.setString(8, degree);
			pstmt.setString(9, dept);
			pstmt.setString(10, office);
			pstmt.setString(11, gender);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int update(String pCode, String name, String addr, String rNum, String phone, String tel,
			 String year, String degree, String deptNum, String office, String gender) {
		int result = 0;
		String quary = "update professor set name = ?, addr = ?, rNum = ?, phone = ?, tel = ?, year = ?,"
				+ "degree = ?, deptNum = ?, office = ?, gender = ? where pCode = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);	
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setString(3, rNum);
			pstmt.setString(4, phone);
			pstmt.setString(5, tel);
			pstmt.setString(6, year);
			pstmt.setString(7, degree);
			pstmt.setString(8, deptNum);
			pstmt.setString(9, office);
			pstmt.setString(10, gender);
			pstmt.setString(11, pCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int delete(String pCode) {
		int result = 0;
		String quary = "delete from professor where pCode = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, pCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void search(String category) {
		dtm.setRowCount(0);
		String dCode = "";
		String quary = "";
		try {
			if (category.equals("deptNum")) {
				quary = "select * from department where deptNum = ? or deptName = ?";
				pstmt = univMenu.connector.conn.prepareStatement(quary);
				pstmt.setString(1, searchField.getText());
				pstmt.setString(2, searchField.getText());
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					dCode = rs.getString(1);
				}
				quary = "select * from professor where " + category + " = '" + dCode + "'";
			}
			else
				quary = "select * from professor where " + category + " = '" + searchField.getText() + "'";
				
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					String pCode = rs.getString(1);
					String name = rs.getString(2);
					String addr = rs.getString(3);
					String rNum = rs.getString(4);
					String phone = rs.getString(5);
					String tel = rs.getString(6);
					String year = rs.getString(7);
					String degree = rs.getString(8);
					String deptNum = rs.getString(9);
					String office = rs.getString(10);
					String gender = rs.getString(11);
					String[] data = {pCode,name,addr,rNum,phone,tel,year,degree,getDeptName(deptNum),office,gender};
					
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
		pCodeField.setText("");
		nameField.setText("");
		rFirstField.setText("");
		rSecondField.setText("");
		adrField.setText("");
		pFirstField.setText("");
		pSecondField.setText("");
		pThirdField.setText("");
		tNumField.setText("");
		yearField.setText("");
		degreeField.setText("");
		officeField.setText("");
		dBox.setSelectedIndex(0);
		pCodeField.requestFocus();
	}
	
	public void check() {
		if (pCodeField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "교수코드를 입력하세요.");
			pCodeField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (nameField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
			nameField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (rFirstField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "주민번호 앞자리를 입력하세요.");
			rFirstField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (rSecondField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "주민번호 뒷자리를 입력하세요.");
			rSecondField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (adrField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "주소를 입력하세요.");
			adrField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (pFirstField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "휴대폰 앞자리를 입력하세요.");
			pFirstField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (pSecondField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "휴대폰 중간자리를 입력하세요.");
			pSecondField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (pThirdField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "휴대폰 뒷자리를 입력하세요.");
			pThirdField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (tNumField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "전화번호를 입력하세요.");
			tNumField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (yearField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "임용년도를 입력하세요.");
			yearField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (degreeField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "학위를 입력하세요.");
			degreeField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (dBox.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "학과를 선택하세요.");
			dBox.requestFocus();
			isEmpty = true;
			return;
		}
		else if (officeField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "연구실을 입력하세요.");
			officeField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (!male.isSelected() && !female.isSelected()) {
			JOptionPane.showMessageDialog(null, "성별을 선택하세요.");
			isEmpty = true;
			return;
		}
		
		isEmpty = false;
	}
	
	public boolean isSameData() {
		String quary = "select pCode from professor where pCode = ?";
		boolean sameData = false;
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, pCodeField.getText());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "같은 교수코드가 있습니다.");
				pCodeField.setText("");
				pCodeField.requestFocus();
				sameData = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sameData;
	}
	
//	public static void main(String[] args){
//		new Professor();
//	}
}
