package db_connect;

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
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
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

public class Address extends JFrame {
	JPanel titlePanel, inputPanel, searchPanel, btnPanel;
	JLabel titleLabel, nameLabel, ageLabel, genderLabel, adrLabel, pNumLabel, emailLabel, hyphen1, hyphen2, at;
	JTextField nameField, ageField, adrField, pFirstField, pSecondField, pThirdField, eFirstField, eSecondField, searchField;
	JRadioButton male, female;
	ButtonGroup group;
	JComboBox eBox, sBox;
	JButton searchBtn, searchAllBtn, inputBtn, editBtn, delBtn, exitBtn;
	TitledBorder iBorder, tBorder;
	DefaultTableModel dtm;
	JTable table;
	JScrollPane jsp;
	Connector connector;
	PreparedStatement pstmt;
	ResultSet rs;
	String[] colname = {"이름","나이","성별","주소","연락처","이메일","INDEX"};
	String sQuary = "select * from friend where name = ?";
	int selectRow = -1;
	int idx;
	boolean isEmpty = false;
	Font font;
	Image logo;
	
	Address() throws IOException {
		connector = new Connector();
		setLayout(null);
		setTitle("자바 주소록 관리 프로그램");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		logo = tk.getImage("C:\\Users\\kcd\\Desktop\\자바\\이미지/주소록.png");
		setIconImage(logo);
		
		titlePanel = new JPanel();
		titlePanel.setBounds(0,0,600,50);
		titlePanel.setBackground(Color.black);
		add(titlePanel);
		
		titleLabel = new JLabel("주소록관리 프로그램");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		titlePanel.add(titleLabel);
		
		inputPanel = new JPanel();
		iBorder = new TitledBorder("입력");
		inputPanel.setBorder(iBorder);
		inputPanel.setBounds(5,55,575,200);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		nameLabel = new JLabel("이 름");
		nameLabel.setBounds(35,30,30,20);
		inputPanel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(75,30,150,25);
		inputPanel.add(nameField);
		
		ageLabel = new JLabel("나 이");
		ageLabel.setBounds(240,30,30,20);
		inputPanel.add(ageLabel);
		
		ageField = new JTextField();
		ageField.setBounds(285,30,100,25);
		inputPanel.add(ageField);
		
		genderLabel = new JLabel("성 별");
		genderLabel.setBounds(410,30,30,20);
		inputPanel.add(genderLabel);
		
		male = new JRadioButton("남자");
		male.setBounds(450,30,50,20);
		inputPanel.add(male);
		
		female = new JRadioButton("여자");
		female.setBounds(500,30,50,20);
		inputPanel.add(female);
		
		group = new ButtonGroup();
		group.add(male);
		group.add(female);
		
		adrLabel = new JLabel("주 소");
		adrLabel.setBounds(35,70,30,20);
		inputPanel.add(adrLabel);
		
		adrField = new JTextField();
		adrField.setBounds(75,70,470,25);
		inputPanel.add(adrField);
		
		pNumLabel = new JLabel("연락처");
		pNumLabel.setBounds(30,110,40,20);
		inputPanel.add(pNumLabel);
		
		pFirstField = new JTextField();
		pFirstField.setBounds(75,110,140,25);
		inputPanel.add(pFirstField);
		
		hyphen1 = new JLabel("-");
		hyphen1.setBounds(225,110,5,20);
		inputPanel.add(hyphen1);
		
		pSecondField = new JTextField();
		pSecondField.setBounds(240,110,140,25);
		inputPanel.add(pSecondField);
		
		hyphen2 = new JLabel("-");
		hyphen2.setBounds(390,110,5,20);
		inputPanel.add(hyphen2);
		
		pThirdField = new JTextField();
		pThirdField.setBounds(405,110,140,25);
		inputPanel.add(pThirdField);
		
		emailLabel = new JLabel("이메일");
		emailLabel.setBounds(30,150,40,20);
		inputPanel.add(emailLabel);
		
		eFirstField = new JTextField();
		eFirstField.setBounds(75,150,140,25);
		inputPanel.add(eFirstField);
		
		at = new JLabel("@");
		at.setBounds(222,150,15,20);
		inputPanel.add(at);
		
		eSecondField = new JTextField();
		eSecondField.setBounds(240,150,160,25);
		inputPanel.add(eSecondField);
		
		String[] email = {"직접입력","naver.com","daum.net","gmail.com"};
		eBox = new JComboBox(email);
		eBox.setBounds(420,150,125,25);
		inputPanel.add(eBox);
		
		searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBounds(0,260,600,50);
		searchPanel.setBackground(Color.cyan);
		add(searchPanel);
		
		sBox = new JComboBox(colname);
		sBox.setBounds(30,12,190,25);
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
		jsp.setBounds(5,315,575,250);
		table.setRowHeight(20);
		add(jsp);
		
		btnPanel = new JPanel();
		btnPanel.setBounds(5,600,575,50);
		btnPanel.setLayout(new GridLayout(0,4,5,5));
		add(btnPanel);
		
		font = new Font("굴림", Font.BOLD, 20);
		
		inputBtn = new JButton("입력");
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
		
		eBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (eBox.getSelectedItem().toString().equals("직접입력")) {
					eSecondField.setText("");
				}
				else
					eSecondField.setText(eBox.getSelectedItem().toString());
			}
		});
		
		sBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (sBox.getSelectedItem().toString()) {
				case "이름":
					sQuary = "select * from friend where name = ?";
					break;
				case "나이":
					sQuary = "select * from friend where age = ?";
					break;
				case "성별":
					sQuary = "select * from friend where gender = ?";
					break;
				case "주소":
					sQuary = "select * from friend where addr = ?";
					break;
				case "연락처":
					sQuary = "select * from friend where phone = ?";
					break;
				case "이메일":
					sQuary = "select * from friend where email = ?";
					break;
				case "INDEX":
					sQuary = "select * from friend where idx = ?";
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
				String[] email = table.getValueAt(selectRow, 5).toString().split("@");
				idx = Integer.parseInt(table.getValueAt(selectRow, 6).toString());
				nameField.setText(table.getValueAt(selectRow, 0).toString());
				ageField.setText(table.getValueAt(selectRow, 1).toString());
				adrField.setText(table.getValueAt(selectRow, 3).toString());
				
				pFirstField.setText(pNum[0]);
				pSecondField.setText(pNum[1]);
				pThirdField.setText(pNum[2]);
				eFirstField.setText(email[0]);
				eSecondField.setText(email[1]);
				
				if (table.getValueAt(selectRow, 2).toString().equals("남자"))
					male.setSelected(true);
				else if (table.getValueAt(selectRow, 2).toString().equals("여자"))
					female.setSelected(true);
				
//				if(table.isRowSelected(selectRow))
//					table.clearSelection();
			}
		});
		
		inputBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				check();
				if (isEmpty == true)
					return;
				if (dtm.getRowCount() != 0) {
					for (int i = 0; i < table.getRowCount(); i++) {
						if (nameField.getText().equals(table.getValueAt(i, 0))) {
							JOptionPane.showMessageDialog(null, "같은 이름이 있습니다.");
							return;
						}
					}
				}
				
				String gender = "";
				String phone = pFirstField.getText()+"-"+pSecondField.getText()+"-"+pThirdField.getText();
				String email = eFirstField.getText()+"@"+eSecondField.getText();
				
				if (male.isSelected())
					gender = "남자";
				else if (female.isSelected())
					gender = "여자";
				
				int result = insert(nameField.getText(), ageField.getText(), gender, adrField.getText(), phone, email);
				
				if (result != 0) {
					JOptionPane.showMessageDialog(getParent(), nameField.getText()+"님의 정보가 입력되었습니다.");
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
				
				if (dtm.getRowCount() != 0) {
					for (int i = 0; i < table.getRowCount(); i++) {
						if (i != selectRow && nameField.getText().equals(table.getValueAt(i, 0))) {
							JOptionPane.showMessageDialog(null, "같은 이름이 있습니다.");
							return;
						}
					}
				}
				
				String name = table.getValueAt(selectRow, 0).toString();
				String gender = "";
				String phone = pFirstField.getText()+"-"+pSecondField.getText()+"-"+pThirdField.getText();
				String email = eFirstField.getText()+"@"+eSecondField.getText();
				
				if (male.isSelected())
					gender = "남자";
				else if (female.isSelected())
					gender = "여자";
				
				int result = update(nameField.getText(), ageField.getText(), gender, adrField.getText(), phone, email, idx);
				
				if (result != 0) {
					JOptionPane.showMessageDialog(getParent(), name+"님의 정보를 수정했습니다.");
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
				
				String name = table.getValueAt(selectRow, 0).toString();
				
				int i = JOptionPane.showConfirmDialog(getParent(), name+"님의 정보를 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				
				if (i == 0) {
					int result = delete(idx);
					
					if (result != 0) {
						JOptionPane.showMessageDialog(getParent(), name+"님의 정보를 삭제했습니다.");
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
				if (searchField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "조회할 정보를 입력하세요.");
					searchField.requestFocus();
					return;
				}
				
				search();
				reset();
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
		
		pFirstField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (pFirstField.getText().length() == 2) {
					pSecondField.requestFocus();
				}
			}
		});
		
		pSecondField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (pSecondField.getText().length() == 3) {
					pThirdField.requestFocus();
				}
			}
		});
		
		pThirdField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (pThirdField.getText().length() == 3) {
					eFirstField.requestFocus();
				}
			}
		});
		
		setSize(600,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void getListAll() {
		dtm.setRowCount(0);
		String quary = "select * from friend";
		
		try {
			pstmt = connector.conn.prepareStatement(quary);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				String age = rs.getString(2);
				String gender = rs.getString(3);
				String addr = rs.getString(4);
				String phone = rs.getString(5);
				String email = rs.getString(6);
				String idx = rs.getString(7);
				String[] data = {name,age,gender,addr,phone,email,idx};
				
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insert(String name, String age, String gender, String adr, String phone, String email) {
		int result = 0;
		String quary = "insert into friend values(?,?,?,?,?,?,?)";
		
		try {
			pstmt = connector.conn.prepareStatement(quary);
			pstmt.setString(1, name);
			pstmt.setString(2, age);
			pstmt.setString(3, gender);
			pstmt.setString(4, adr);
			pstmt.setString(5, phone);
			pstmt.setString(6, email);
			pstmt.setInt(7, 0);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int update(String name, String age, String gender, String adr, String phone, String email, int idx) {
		int result = 0;
		String quary = "update friend set name = ?, age = ?, gender = ?, addr = ?, phone = ?, email = ? where idx = ?";
		
		try {
			pstmt = connector.conn.prepareStatement(quary);
			pstmt.setString(1, name);
			pstmt.setString(2, age);
			pstmt.setString(3, gender);
			pstmt.setString(4, adr);
			pstmt.setString(5, phone);
			pstmt.setString(6, email);
			pstmt.setInt(7, idx);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int delete(int idx) {
		int result = 0;
		String quary = "delete from friend where idx = ?";
		
		try {
			pstmt = connector.conn.prepareStatement(quary);
			pstmt.setInt(1, idx);
			
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
				String name = rs.getString(1);
				String age = rs.getString(2);
				String gender = rs.getString(3);
				String addr = rs.getString(4);
				String phone = rs.getString(5);
				String email = rs.getString(6);
				String idx = rs.getString(7);
				
				String[] data = {name,age,gender,addr,phone,email,idx};
				
				dtm.addRow(data);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void reset() {
		nameField.setText("");
		ageField.setText("");
		adrField.setText("");
		pFirstField.setText("");
		pSecondField.setText("");
		pThirdField.setText("");
		eFirstField.setText("");
		eSecondField.setText("");
		nameField.requestFocus();
	}
	
	public void check() {
		if (nameField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
			nameField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (ageField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "나이를 입력하세요.");
			ageField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (!male.isSelected() && !female.isSelected()) {
			JOptionPane.showMessageDialog(null, "성별을 선택하세요.");
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
			JOptionPane.showMessageDialog(null, "연락처 앞자리를 입력하세요.");
			pFirstField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (pSecondField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "연락처 중간자리를 입력하세요.");
			pSecondField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (pThirdField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "연락처 뒷자리를 입력하세요.");
			pThirdField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (eFirstField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "이메일 앞자리를 입력하세요.");
			eFirstField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (eSecondField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "이메일 뒷자리를 입력하세요.");
			eSecondField.requestFocus();
			isEmpty = true;
			return;
		}
		isEmpty = false;
	}

	public static void main(String[] args) throws IOException {
		new Address();
	}
}
