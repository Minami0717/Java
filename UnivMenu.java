package univ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class UnivMenu extends JFrame implements ActionListener {

	JMenuBar menuBar;
	JMenu std, prof, dept, sub, attend, result, user, logout;
	JMenuItem sItem, pItem, dItem, subItem, aItem, profItem, stdItem, uItem;
	Connector connector;
	String usercode, username, userpower;
	
	UnivMenu(String usercode, String username, String userpower, Connector connector, Login login) {
		this.connector = connector;
		this.usercode = usercode;
		this.username = username;
		
		setTitle("학사관리시스템: 사용자: "+usercode+" "+username);
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		logout = new JMenu("로그아웃");
		menuBar.add(logout);
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				login.show();
			}
		});
		
		std = new JMenu("학생관리");
		prof = new JMenu("교수관리");
		dept = new JMenu("학과관리");
		sub = new JMenu("교과목관리");
		attend = new JMenu("수강관리");
		result = new JMenu("성적관리");
		user = new JMenu("사용자등록");
		
		sItem = new JMenuItem("등록");
		pItem = new JMenuItem("등록");
		dItem = new JMenuItem("등록");
		subItem = new JMenuItem("등록");
		aItem = new JMenuItem("등록");
		profItem = new JMenuItem("등록");
		stdItem = new JMenuItem("조회");
		uItem = new JMenuItem("사용자등록");

		std.add(sItem);
		prof.add(pItem);
		dept.add(dItem);
		sub.add(subItem);
		attend.add(aItem);
		user.add(uItem);
		
		if (userpower.equals("p")) {
			menuBar.add(std);
			menuBar.add(sub);
			menuBar.add(result);
			//menuBar.add(user);
			result.add(profItem);
		}
		else if (userpower.equals("s")) {
			menuBar.add(attend);
			menuBar.add(result);
			//menuBar.add(user);
			result.add(stdItem);
		}
		else if (userpower.equals("a")) {
			menuBar.add(std);
			menuBar.add(prof);
			menuBar.add(dept);
			menuBar.add(sub);
			menuBar.add(user);
		}
		
		dItem.addActionListener(this);
		pItem.addActionListener(this);
		sItem.addActionListener(this);
		subItem.addActionListener(this);
		uItem.addActionListener(this);
		profItem.addActionListener(this);
		stdItem.addActionListener(this);
		aItem.addActionListener(this);
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dItem) {
			dispose();
			new Department(this);
		}
		if (e.getSource() == pItem) {
			dispose();
			new Professor(this);
		}
		if (e.getSource() == sItem) {
			dispose();
			new Student(this);
		}
		if (e.getSource() == subItem) {
			dispose();
			new Subject(this);
		}
		if (e.getSource() == uItem) {
			dispose();
			new Admin(this);
		}
		if (e.getSource() == profItem) {
			dispose();
			new Results_prof(this);
		}
		if (e.getSource() == stdItem) {
			dispose();
			new Results_std(this);
		}
		if (e.getSource() == aItem) {
			dispose();
			new Attended(this);
		}
	}
	
//	public static void main(String[] args) {
//		new UnivMenu();
//	}
}
