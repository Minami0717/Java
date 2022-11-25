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

public class Admin extends JFrame {

	JPanel titlePanel, inputPanel, btnPanel;
	JLabel titleLabel, idLabel, pwLabel, checkLabel, userLabel, powerLabel, dateLabel;
	JTextField idField, pwField, checkField, userField, powerField, dateField;
	JButton idBtn, pwBtn, inputBtn, editBtn, delBtn, exitBtn;
	TitledBorder iBorder, tBorder;
	DefaultTableModel dtm;
	JTable table;
	JScrollPane jsp;
	PreparedStatement pstmt;
	ResultSet rs;
	int selectRow = -1;
	int dCode;
	boolean isEmpty = false;
	boolean idCheck = false;
	boolean pwCheck = false;
	boolean inCheck = false;
	boolean edCheck = false;
	Font font;
	Image logo;
	UnivMenu univMenu;
	
	Admin(UnivMenu univMenu){
		this.univMenu = univMenu;
		
		setLayout(null);
		setTitle(univMenu.usercode);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		logo = tk.getImage("C:\\Users\\kcd\\Desktop\\자바\\이미지/주소록.png");
		setIconImage(logo);
		
		titlePanel = new JPanel();
		titlePanel.setBounds(0,0,600,50);
		titlePanel.setBackground(Color.black);
		add(titlePanel);
		
		titleLabel = new JLabel("사 용 자 관 리");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		titlePanel.add(titleLabel);
		
		inputPanel = new JPanel();
		iBorder = new TitledBorder("입력");
		inputPanel.setBorder(iBorder);
		inputPanel.setBounds(5,55,575,200);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		idLabel = new JLabel("아이디");
		idLabel.setBounds(35,30,50,20);
		inputPanel.add(idLabel);
		
		idField = new JTextField();
		idField.setBounds(100,30,100,25);
		inputPanel.add(idField);
		
		pwLabel = new JLabel("패스워드");
		pwLabel.setBounds(35,70,50,20);
		inputPanel.add(pwLabel);
		
		pwField = new JTextField();
		pwField.setBounds(100,70,100,25);
		inputPanel.add(pwField);
		
		checkLabel = new JLabel("패스워드확인");
		checkLabel.setBounds(220,70,80,20);
		inputPanel.add(checkLabel);
		
		checkField = new JTextField();
		checkField.setBounds(310,70,100,25);
		inputPanel.add(checkField);
		
		userLabel = new JLabel("사용자");
		userLabel.setBounds(35,110,50,20);
		inputPanel.add(userLabel);
		
		userField = new JTextField();
		userField.setBounds(100,110,100,25);
		inputPanel.add(userField);
		
		powerLabel = new JLabel("사용권한");
		powerLabel.setBounds(220,110,50,20);
		inputPanel.add(powerLabel);
		
		powerField = new JTextField();
		powerField.setBounds(310,110,100,25);
		inputPanel.add(powerField);
		
		dateLabel = new JLabel("등록날짜");
		dateLabel.setBounds(35,150,50,20);
		inputPanel.add(dateLabel);
		
		dateField = new JTextField();
		dateField.setBounds(100,150,100,25);
		inputPanel.add(dateField);
		
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
		
		idBtn = new JButton("ID 중복확인");
		idBtn.setBounds(220,30,100,25);
		idBtn.setBackground(Color.DARK_GRAY);
		idBtn.setForeground(Color.pink);
		inputPanel.add(idBtn);
		
		pwBtn = new JButton("PW 중복확인");
		pwBtn.setBounds(430,70,110,25);
		pwBtn.setBackground(Color.DARK_GRAY);
		pwBtn.setForeground(Color.pink);
		inputPanel.add(pwBtn);

		String[][] rowdata = {};
		String[] colname = {"아이디","패스워드","사용자","사용권한","등록날짜"};
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
		jsp.setBounds(5,290,575,280);
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
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectRow = table.getSelectedRow();
				
				idField.setText(table.getValueAt(selectRow, 0).toString());
				pwField.setText(table.getValueAt(selectRow, 1).toString());
				checkField.setText(table.getValueAt(selectRow, 1).toString());
				userField.setText(table.getValueAt(selectRow, 2).toString());
				powerField.setText(table.getValueAt(selectRow, 3).toString());
				dateField.setText(table.getValueAt(selectRow, 4).toString());
				
//				if(table.isRowSelected(selectRow))
//					table.clearSelection();
			}
		});
		
		inputBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!inputCheck())
					return;
				if (isSameId())
					return;
				if (isSameUser())
					return;
				
				int result = insert(idField.getText(), pwField.getText(), userField.getText(),
						powerField.getText(), dateField.getText());
				
				if (result != 0) {
					JOptionPane.showMessageDialog(null, idField.getText()+"의 정보가 입력되었습니다.");
					getListAll();
					reset();
				}
			}
		});
		
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!editCheck())
					return;
				if (!pwField.getText().equals(checkField.getText())) {
					JOptionPane.showMessageDialog(null, "PW 중복 확인이 필요합니다.");
					pwBtn.requestFocus();
					return;
				}
				
				String id = table.getValueAt(selectRow, 0).toString();
				
				int result = update(id, pwField.getText(), userField.getText(),
						powerField.getText(), dateField.getText());
				
				if (result != 0) {
					JOptionPane.showMessageDialog(null, id+"의 정보를 수정했습니다.");
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
				
				String id = table.getValueAt(selectRow, 0).toString();
				
				int i = JOptionPane.showConfirmDialog(null, id+"의 정보를 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				
				if (i == 0) {
					int result = delete(id);
					
					if (result != 0) {
						JOptionPane.showMessageDialog(null, id+"의 정보를 삭제했습니다.");
						getListAll();
						reset();
						selectRow = -1;
					}
				}
				else
					return;
			}
		});
		
		idBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (idField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
					idField.requestFocus();
					return;
				}
				
//				idCheck = true;
//				if (dtm.getRowCount() != 0) {
//					for (int i = 0; i < table.getRowCount(); i++) {
//						if (idField.getText().equals(table.getValueAt(i, 0)))
//							idCheck = false;
//					}
//				}
				
				if (isSameId())
					idCheck = false;
				else {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
					idCheck = true;
					pwField.requestFocus();
				}
			}
		});
		
		pwBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pwField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "패스워드를 입력하세요.");
					pwField.requestFocus();
					return;
				}
				else if (checkField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "패스워드확인을 입력하세요.");
					checkField.requestFocus();
					return;
				}
				
				if (pwField.getText().equals(checkField.getText())) {
					JOptionPane.showMessageDialog(null, "패스워드가 일치합니다.");
					userField.requestFocus();
					pwCheck = true;
				}
				else {
					JOptionPane.showMessageDialog(null, "패스워드가 다릅니다.");
					checkField.setText("");
					checkField.requestFocus();
					pwCheck = false;
				}
			}
		});
		
		userField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (userField.getText().length() == 3 && e.paramString().indexOf("Backspace") == -1)
					powerField.requestFocus();
			}
		});
		powerField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (powerField.getText().length() == 0 && e.paramString().indexOf("Backspace") == -1)
					dateField.requestFocus();
			}
		});
		
		setSize(600,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void getListAll() {
		dtm.setRowCount(0);
		String quary = "select * from admin";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String user = rs.getString(3);
				String power = rs.getString(4);
				String date = rs.getString(5);
				String[] data = {id,pw,user,power,date};
				
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int insert(String id, String pw, String user, String power, String date) {
		int result = 0;
		String quary = "insert into admin values(?,?,?,?,?)";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, user);
			pstmt.setString(4, power);
			pstmt.setString(5, date);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int update(String id, String pw, String user, String power, String date) {
		int result = 0;
		String quary = "update admin set pw = ?, user = ?, power = ?, date = ? where id = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, pw);
			pstmt.setString(2, user);
			pstmt.setString(3, power);
			pstmt.setString(4, date);
			pstmt.setString(5, id);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int delete(String id) {
		int result = 0;
		String quary = "delete from admin where id = ?";
		
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void reset() {
		idField.setText("");
		pwField.setText("");
		checkField.setText("");
		userField.setText("");
		powerField.setText("");
		dateField.setText("");
		idField.requestFocus();
		idCheck = false;
		pwCheck = false;
	}
	
	public boolean check() {
		if (idField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
			idField.requestFocus();
			isEmpty = true;
			return isEmpty;
		}
		else if (pwField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "패스워드를 입력하세요.");
			pwField.requestFocus();
			isEmpty = true;
			return isEmpty;
		}
		else if (checkField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "패스워드확인을 입력하세요.");
			checkField.requestFocus();
			isEmpty = true;
			return isEmpty;
		}
		else if (userField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "사용자를 입력하세요.");
			userField.requestFocus();
			isEmpty = true;
			return isEmpty;
		}
		else if (powerField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "사용권한을 입력하세요.");
			powerField.requestFocus();
			isEmpty = true;
			return isEmpty;
		}
		else if (dateField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "등록날짜를 입력하세요.");
			dateField.requestFocus();
			isEmpty = true;
			return isEmpty;
		}
		
		isEmpty = false;
		return isEmpty;
	}
	
	public boolean inputCheck() {
		if (check()) {
			inCheck = false;
			return inCheck;
		}
		
		String u = Character.toString(userField.getText().charAt(0));
		if (!u.equals(powerField.getText())) {
			JOptionPane.showMessageDialog(null, "사용자와 사용권한이 다릅니다.");
			powerField.setText(u);
			powerField.requestFocus();
			inCheck = false;
			return inCheck;
		}
		
		inCheck = true;
		return inCheck;
	}
	
	public boolean editCheck() {
		if (selectRow == -1) {
			JOptionPane.showMessageDialog(null, "수정할 행을 선택하세요.");
			edCheck = false;
			return edCheck;
		}
		if (check()) {
			edCheck = false;
			return edCheck;
		}
		if (!idField.getText().equals(table.getValueAt(selectRow, 0))) {
			JOptionPane.showMessageDialog(null, "아이디는 수정할 수 없습니다.");
			idField.setText(table.getValueAt(selectRow, 0).toString());
			edCheck = false;
			return edCheck;
		}
		
		String u = Character.toString(userField.getText().charAt(0));
		if (!u.equals(powerField.getText())) {
			JOptionPane.showMessageDialog(null, "사용자와 사용권한이 다릅니다.");
			System.out.println(u);
			powerField.setText(u);
			edCheck = false;
			return edCheck;
		}
		
		edCheck = true;
		return edCheck;
	}
	
	public boolean isSameId() {
		String quary = "select id from admin where id = ?";
		boolean sameData = false;
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, idField.getText());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.");
				idField.setText("");
				idField.requestFocus();
				sameData = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sameData;
	}
	
	public boolean isSameUser() {
		String quary = "select user from admin where user = ?";
		boolean sameData = false;
		try {
			pstmt = univMenu.connector.conn.prepareStatement(quary);
			pstmt.setString(1, userField.getText());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "이미 등록된 사용자입니다.");
				userField.setText("");
				userField.requestFocus();
				sameData = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sameData;
	}
	
//	public static void main(String[] args){
//		new Admin();
//	}
}
