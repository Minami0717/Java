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

public class Login extends JFrame implements ActionListener {

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
	String userid, userpw, usercode, userpower;
	
	
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
		checkBtn.addActionListener(this);
		checkPanel.add(checkBtn);
		
		setSize(600,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == checkBtn) {
			if (idField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
				idField.requestFocus();
				return;
			}
			else if (pwField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "패스워드를 입력하세요.");
				pwField.requestFocus();
				return;
			}
			
			String quary = "select * from admin where id=? and pw=?";
			
			try {
				pstmt = connector.conn.prepareStatement(quary);
				pstmt.setString(1, idField.getText());
				pstmt.setString(2, pwField.getText());
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					userid = rs.getString(1);
					userpw = rs.getString(2);
					usercode = rs.getString(3);
				}
				
				if (userid == null) {
					JOptionPane.showMessageDialog(this, "아이디나 패스워드가 틀렸습니다.");
					idField.requestFocus();
					return;
				}
				
				getPower();
				getUserName();
				
				String username = nameField.getText();
				JOptionPane.showMessageDialog(this, username+"님 반갑습니다.");
				idField.setText("");
				pwField.setText("");
				nameField.setText("");
				userid = null;
				
				dispose();
				new UnivMenu(usercode, username, userpower, connector, this);
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void getUserName() {
		String quary = "";
		if (userpower.equals("p"))
			quary = "select name from professor where pCode = ?";
		else if (userpower.equals("s"))
			quary = "select name from student where sNum = ?";
		else {
			nameField.setText("관리자");
			return;
		}
		
		try {
			pstmt = connector.conn.prepareStatement(quary);
			pstmt.setString(1, usercode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				nameField.setText(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getPower() {
		String quary = "select power from admin where user = ?";
		try {
			pstmt = connector.conn.prepareStatement(quary);
			pstmt.setString(1, usercode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userpower = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Login();
	}
}
