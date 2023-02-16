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

public class Student extends JFrame {

	JPanel titlePanel, inputPanel, searchPanel, btnPanel;
	JLabel titleLabel, pCodeLabel, nameLabel, rNumLabel, genderLabel, adrLabel, pNumLabel, tNumLabel,
	hyphen1, hyphen2, hyphen3, degreeLabel, officeLabel, deptLabel, yearLabel, professorLabel;
	JTextField pCodeField, nameField, rFirstField, rSecondField, adrField, tNumField, degreeField,
	iYearField, pFirstField, pSecondField, pThirdField, gYearField, searchField;
	JComboBox dBox, pBox, sBox;
	JRadioButton male, female;
	ButtonGroup group;
	JButton searchBtn, searchAllBtn, inputBtn, editBtn, delBtn, exitBtn;
	TitledBorder iBorder, tBorder;
	DefaultTableModel dtm;
	JTable table;
	JScrollPane jsp;
	Connector connector;
	PreparedStatement pstmt;
	ResultSet rs;
	String[] colname = {"학번","이름","주소","주민등록번호","휴대폰","전화번호","입학년도","졸업고교","고교졸업년도","학과","지도교수","성별"};
	String sQuary = "select * from professor where professorNum = ?";
	int selectRow = -1;
	int pCode;
	boolean isEmpty = false;
	Font font;
	Image logo;
	
	Student() throws IOException {
		connector = new Connector();
		setLayout(null);
		setTitle("학생관리");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		logo = tk.getImage("C:\\Users\\kcd\\Desktop\\자바\\이미지/주소록.png");
		setIconImage(logo);
		
		titlePanel = new JPanel();
		titlePanel.setBounds(0,0,700,50);
		titlePanel.setBackground(Color.black);
		add(titlePanel);
		
		titleLabel = new JLabel("학 생 관 리");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		titlePanel.add(titleLabel);
		
		inputPanel = new JPanel();
		iBorder = new TitledBorder("입력");
		inputPanel.setBorder(iBorder);
		inputPanel.setBounds(5,55,675,200);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		pCodeLabel = new JLabel("학 번");
		pCodeLabel.setBounds(20,20,50,20);
		inputPanel.add(pCodeLabel);
		
		pCodeField = new JTextField();
		pCodeField.setBounds(80,20,100,25);
		inputPanel.add(pCodeField);
		
		nameLabel = new JLabel("이 름");
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
		
		yearLabel = new JLabel("입학년도");
		yearLabel.setBounds(20,125,50,20);
		inputPanel.add(yearLabel);
		
		iYearField = new JTextField();
		iYearField.setBounds(80,125,100,25);
		inputPanel.add(iYearField);
		
		degreeLabel = new JLabel("졸업고교");
		degreeLabel.setBounds(230,125,50,20);
		inputPanel.add(degreeLabel);
		
		degreeField = new JTextField();
		degreeField.setBounds(290,125,130,25);
		inputPanel.add(degreeField);
		
		deptLabel = new JLabel("고교졸업년도");
		deptLabel.setBounds(430,125,80,20);
		inputPanel.add(deptLabel);
		
		gYearField = new JTextField();
		gYearField.setBounds(520,125,110,25);
		inputPanel.add(gYearField);
		
		officeLabel = new JLabel("학 과");
		officeLabel.setBounds(20,160,40,20);
		inputPanel.add(officeLabel);
		
		String[] d = {"개설학과","컴퓨터공학","방사선","물리치료","사무자동화","간호1"};
		dBox = new JComboBox(d);
		dBox.setBounds(80,160,110,25);
		inputPanel.add(dBox);
		
		professorLabel = new JLabel("지도교수");
		professorLabel.setBounds(230,160,50,20);
		inputPanel.add(professorLabel);
		
		String[] p = {"담당교수","김하나","김두리","정교수"};
		pBox = new JComboBox(p);
		pBox.setBounds(290,160,130,25);
		inputPanel.add(pBox);
		
		genderLabel = new JLabel("성 별");
		genderLabel.setBounds(430,160,30,20);
		inputPanel.add(genderLabel);
		
		male = new JRadioButton("남자");
		male.setBounds(470,160,50,20);
		inputPanel.add(male);
		
		female = new JRadioButton("여자");
		female.setBounds(530,160,50,20);
		inputPanel.add(female);
		
		group = new ButtonGroup();
		group.add(male);
		group.add(female);
		
		searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBounds(0,260,700,50);
		searchPanel.setBackground(Color.cyan);
		add(searchPanel);
		
		String[] s = {"검색할 카테고리를 선택하세요","교수코드","교수명","학과명","성별"};
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
				switch (sBox.getSelectedItem().toString()) {
				case "교수코드":
					sQuary = "select * from professor where professorNum = ?";
					break;
				case "교수명":
					sQuary = "select * from professor where professorName = ?";
					break;
				case "학과명":
					sQuary = "select * from professor where deptName = ?";
					break;
				case "성별":
					sQuary = "select * from professor where gender = ?";
					break;
				default:
					break;
				}
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
				//yearField.setText(table.getValueAt(selectRow, 6).toString());
				degreeField.setText(table.getValueAt(selectRow, 7).toString());
				//officeField.setText(table.getValueAt(selectRow, 9).toString());
				
				rFirstField.setText(rNum[0]);
				rSecondField.setText(rNum[1]);
				pFirstField.setText(pNum[0]);
				pSecondField.setText(pNum[1]);
				pThirdField.setText(pNum[2]);
				
				if (table.getValueAt(selectRow, 10).toString().equals("남자"))
					male.setSelected(true);
				else if (table.getValueAt(selectRow, 10).toString().equals("여자"))
					female.setSelected(true);
				
//				if(table.isRowSelected(selectRow))
//					table.clearSelection();
			}
		});
		
		inputBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//check();
				if (isEmpty == true)
					return;
				if (dtm.getRowCount() != 0) {
					for (int i = 0; i < table.getRowCount(); i++) {
						if (pCodeField.getText().equals(table.getValueAt(i, 0))) {
							JOptionPane.showMessageDialog(null, "같은 교수코드가 있습니다.");
							return;
						}
					}
				}
				
//				int result = insert(pCodeField.getText(), dNameField.getText(), mNameField.getText());
//				
//				if (result != 0) {
//					JOptionPane.showMessageDialog(null, dCodeField.getText()+"의 학과 정보가 입력되었습니다.");
//					getListAll();
//					reset();
//				}
			}
		});
		
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectRow == -1) {
					JOptionPane.showMessageDialog(null, "수정할 행을 선택하세요.");
					return;
				}
				
				if (dtm.getRowCount() != 0) {
					for (int i = 0; i < table.getRowCount(); i++) {
						if (i != selectRow && pCodeField.getText().equals(table.getValueAt(i, 0))) {
							JOptionPane.showMessageDialog(null, "같은 교수코드가 있습니다.");
							return;
						}
					}
				}
				
				String dCode = table.getValueAt(selectRow, 0).toString();
				
//				int result = update(dNameField.getText(), mNameField.getText(), dCodeField.getText());
//				
//				if (result != 0) {
//					JOptionPane.showMessageDialog(null, dCode+"의 정보를 수정했습니다.");
//					getListAll();
//					reset();
//					selectRow = -1;
//				}
			}
		});
		
		delBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectRow == -1) {
					JOptionPane.showMessageDialog(null, "삭제할 행을 선택하세요.");
					return;
				}
				
				String dCode = table.getValueAt(selectRow, 0).toString();
				
				int i = JOptionPane.showConfirmDialog(null, dCode+"의 정보를 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				
				if (i == 0) {
					int result = delete(dCode);
					
					if (result != 0) {
						JOptionPane.showMessageDialog(null, dCode+"의 정보를 삭제했습니다.");
						getListAll();
						//reset();
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
				if (sBox.getSelectedItem().toString().equals("검색할 카테고리를 선택하세요")) {
					JOptionPane.showMessageDialog(null, "카테고리를 선택하세요.");
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
				searchField.setText("");
				
				if (dtm.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "조회 결과가 없습니다.");
					searchField.requestFocus();
				}
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
		
		setSize(700,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void getListAll() {
		dtm.setRowCount(0);
		String quary = "select * from student";
		
		try {
			pstmt = connector.conn.prepareStatement(quary);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String sNum = rs.getString(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				String rNum = rs.getString(4);
				String phone = rs.getString(5);
				String tel = rs.getString(6);
				String sYear = rs.getString(7);
				String school = rs.getString(8);
				String eYear = rs.getString(9);
				String dept = rs.getString(10);
				String prof = rs.getString(11);
				String gender = rs.getString(12);
				String[] data = {sNum,name,addr,rNum,phone,tel,sYear,school,eYear,dept,prof,gender};
				
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insert(String dCode, String dName, String mName) {
		int result = 0;
		String quary = "insert into department values(?,?,?)";
		
		try {
			pstmt = connector.conn.prepareStatement(quary);
			pstmt.setString(1, dCode);
			pstmt.setString(2, dName);
			pstmt.setString(3, mName);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int update(String dName, String mName, String dCode) {
		int result = 0;
		String quary = "update department set deptName = ?, majorName = ? where deptNum = ?";
		
		try {
			pstmt = connector.conn.prepareStatement(quary);
			pstmt.setString(1, dName);
			pstmt.setString(2, mName);
			pstmt.setString(3, dCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int delete(String dCode) {
		int result = 0;
		String quary = "delete from department where deptNum = ?";
		
		try {
			pstmt = connector.conn.prepareStatement(quary);
			pstmt.setString(1, dCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void search() {
		dtm.setRowCount(0);
		
		try {
			pstmt = connector.conn.prepareStatement(sQuary);
			pstmt.setString(1, searchField.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String dCode = rs.getString(1);
				String dName = rs.getString(2);
				String mName = rs.getString(3);
				
				String[] data = {dCode,dName,mName};
				
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
//	
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
	
	public static void main(String[] args) throws IOException {
		new Student();
	}
}
