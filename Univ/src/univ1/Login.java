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

public class Login extends JFrame {

	JPanel titlePanel, inputPanel, checkPanel;
	JLabel titleLabel, idLabel, pwLabel, nameLabel;
	JTextField idField, pwField, nameField;
	JButton checkBtn;
	TitledBorder iBorder;
	Connector connector;
	PreparedStatement pstmt;
	ResultSet rs;
	boolean isEmpty = false;
	Font font;
	Image logo;
	
	Login() throws IOException {
		connector = new Connector();
		setLayout(null);
		setTitle("로 그 인");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		logo = tk.getImage("C:\\Users\\kcd\\Desktop\\자바\\이미지/주소록.png");
		setIconImage(logo);
		
		titlePanel = new JPanel();
		titlePanel.setBounds(0,0,600,50);
		titlePanel.setBackground(Color.black);
		add(titlePanel);
		
		titleLabel = new JLabel("로그인");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		titlePanel.add(titleLabel);
		
		inputPanel = new JPanel();
		iBorder = new TitledBorder("입력");
		inputPanel.setBorder(iBorder);
		inputPanel.setBounds(5,55,575,100);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		idLabel = new JLabel("아이디");
		idLabel.setBounds(35,30,50,20);
		inputPanel.add(idLabel);
		
		idField = new JTextField();
		idField.setBounds(90,30,90,25);
		inputPanel.add(idField);
		
		pwLabel = new JLabel("패스워드");
		pwLabel.setBounds(200,30,50,20);
		inputPanel.add(pwLabel);
		
		pwField = new JTextField();
		pwField.setBounds(260,30,90,25);
		inputPanel.add(pwField);
		
		nameLabel = new JLabel("사용자이름");
		nameLabel.setBounds(380,30,70,20);
		inputPanel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(460,30,90,25);
		inputPanel.add(nameField);
		
		checkPanel = new JPanel();
		checkPanel.setLayout(null);
		checkPanel.setBounds(0,180,600,70);
		checkPanel.setBackground(Color.cyan);
		add(checkPanel);
		
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
		
		checkBtn = new JButton("확 인");
		checkBtn.setBounds(470,21,85,25);
		checkBtn.setBackground(Color.DARK_GRAY);
		checkBtn.setForeground(Color.pink);
		checkPanel.add(checkBtn);
		
		checkBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getListAll();
				reset();
				selectRow = -1;
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
			pstmt = connector.conn.prepareStatement(quary);
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
	
	public static void main(String[] args) throws IOException {
		new Login();
	}
}
