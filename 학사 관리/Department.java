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

public class Department extends JFrame {

	JPanel titlePanel, inputPanel, searchPanel, btnPanel;
	JLabel titleLabel, dCodeLabel, dNameLabel, mNameLabel;
	JTextField dCodeField, dNameField, mNameField, searchField;
	JComboBox sBox;
	JButton searchBtn, searchAllBtn, inputBtn, editBtn, delBtn, exitBtn;
	TitledBorder iBorder, tBorder;
	DefaultTableModel dtm;
	JTable table;
	JScrollPane jsp;
	PreparedStatement pstmt;
	ResultSet rs;
	int selectRow = -1;
	int dCode;
	boolean isEmpty = false;
	Font font;
	Image logo;
	UnivMenu univMenu;
	
	Department(UnivMenu univMenu) {
		this.univMenu = univMenu;
		
		setLayout(null);
		setTitle("학과관리");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		logo = tk.getImage("C:\\Users\\kcd\\Desktop\\자바\\이미지/주소록.png");
		setIconImage(logo);
		
		titlePanel = new JPanel();
		titlePanel.setBounds(0,0,600,50);
		titlePanel.setBackground(Color.black);
		add(titlePanel);
		
		titleLabel = new JLabel("학 과 관 리");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		titlePanel.add(titleLabel);
		
		inputPanel = new JPanel();
		iBorder = new TitledBorder("입력");
		inputPanel.setBorder(iBorder);
		inputPanel.setBounds(5,55,575,200);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		dCodeLabel = new JLabel("학과코드");
		dCodeLabel.setBounds(35,30,50,20);
		inputPanel.add(dCodeLabel);
		
		dCodeField = new JTextField();
		dCodeField.setBounds(100,30,100,25);
		inputPanel.add(dCodeField);
		
		dNameLabel = new JLabel("학과명");
		dNameLabel.setBounds(220,30,40,20);
		inputPanel.add(dNameLabel);
		
		dNameField = new JTextField();
		dNameField.setBounds(275,30,100,25);
		inputPanel.add(dNameField);
		
		mNameLabel = new JLabel("전공명");
		mNameLabel.setBounds(400,30,40,20);
		inputPanel.add(mNameLabel);
		
		mNameField = new JTextField();
		mNameField.setBounds(450,30,100,25);
		inputPanel.add(mNameField);
		
		searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBounds(0,260,600,50);
		searchPanel.setBackground(Color.cyan);
		add(searchPanel);
		
		String[] s = {"학과코드","학과명","전공명","검색할 카테고리를 선택하세요"};
		sBox = new JComboBox(s);
		sBox.setSelectedIndex(3);
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
		String[] colname = {"학과코드","학과명","전공명"};
		dtm = new DefaultTableModel(rowdata,colname) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(dtm);
		jsp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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
				if (sBox.getSelectedIndex() != 3)
					searchField.requestFocus();
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectRow = table.getSelectedRow();
				
				dCodeField.setText(table.getValueAt(selectRow, 0).toString());
				dNameField.setText(table.getValueAt(selectRow, 1).toString());
				mNameField.setText(table.getValueAt(selectRow, 2).toString());
				//dCodeField.setEditable(false);
				
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
				
				int result = insert(dCodeField.getText(), dNameField.getText(), mNameField.getText());
				
				if (result != 0) {
					JOptionPane.showMessageDialog(null, dCodeField.getText()+"의 학과 정보가 입력되었습니다.");
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
				if (!dCodeField.getText().equals(table.getValueAt(selectRow, 0))) {
					JOptionPane.showMessageDialog(null, "학과코드는 수정할 수 없습니다.");
					dCodeField.setText(table.getValueAt(selectRow, 0).toString());
					dCodeField.requestFocus();
					return;
				}
				
				String dCode = table.getValueAt(selectRow, 0).toString();
				
				int result = update(dNameField.getText(), mNameField.getText(), dCodeField.getText());
				
				if (result != 0) {
					JOptionPane.showMessageDialog(null, dCode+"의 정보를 수정했습니다.");
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
				
				String dCode = table.getValueAt(selectRow, 0).toString();
				
				int i = JOptionPane.showConfirmDialog(null, dCode+"의 정보를 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				
				if (i == 0) {
					int result = delete(dCode);
					
					if (result != 0) {
						JOptionPane.showMessageDialog(null, dCode+"의 정보를 삭제했습니다.");
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
				if (sBox.getSelectedIndex() == 3) {
					JOptionPane.showMessageDialog(null, "카테고리를 선택하세요.");
					sBox.requestFocus();
					return;
				}
				
				if (searchField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "조회할 정보를 입력하세요.");
					searchField.requestFocus();
					return;
				}
				
				String[] field = {"deptNum","deptName","majorName"};
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
		
		dCodeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (dCodeField.getText().length() == 3 && e.paramString().indexOf("Backspace") == -1)
					dNameField.requestFocus();
			}
		});
		
		setSize(600,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void getListAll() {
		dtm.setRowCount(0);
		String quary = "select * from department";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String deptNum = rs.getString(1);
				String deptName = rs.getString(2);
				String majorName = rs.getString(3);
				String[] data = {deptNum,deptName,majorName};
				
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
			pstmt = univMenu.connector.conn.prepareStatement(quary);
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
			pstmt = univMenu.connector.conn.prepareStatement(quary);
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
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, dCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void search(String s) {
		dtm.setRowCount(0);
		String quary = "select * from department where " + s + " = ?";
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, searchField.getText());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					String dCode = rs.getString(1);
					String dName = rs.getString(2);
					String mName = rs.getString(3);
					
					String[] data = {dCode,dName,mName};
					
					dtm.addRow(data);
				} while (rs.next());
			}
			else {
				JOptionPane.showMessageDialog(null, "조회 결과가 없습니다.");
				searchField.requestFocus();
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void reset() {
		dCodeField.setText("");
		dNameField.setText("");
		mNameField.setText("");
		dCodeField.requestFocus();
	}
	
	public void check() {
		if (dCodeField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "학과코드를 입력하세요.");
			dCodeField.requestFocus();
			isEmpty = true;
			return;
		}
		else if (dNameField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "학과명 입력하세요.");
			dNameField.requestFocus();
			isEmpty = true;
			return;
		}
		
		else if (mNameField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "전공명을 입력하세요.");
			mNameField.requestFocus();
			isEmpty = true;
			return;
		}
		
		isEmpty = false;
	}
	
	public boolean isSameData() {
		String quary = "select deptNum from department where deptNum = ?";
		boolean sameData = false;
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, dCodeField.getText());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "같은 학과코드가 있습니다.");
				dCodeField.setText("");
				dCodeField.requestFocus();
				sameData = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sameData;
	}
	
//	public static void main(String[] args){
//		new Department();
//	}
}
