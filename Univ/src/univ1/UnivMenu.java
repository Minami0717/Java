package univ;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class UnivMenu extends JFrame {

	JMenuBar menuBar;
	JMenu std, prof, dept, sub, attend, result, user;
	JMenuItem sItem, pItem, dItem, subItem, aItem, rItem, uItem;
	
	UnivMenu() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		std = new JMenu("학생관리");
		prof = new JMenu("교수관리");
		dept = new JMenu("학과관리");
		sub = new JMenu("교과목관리");
		attend = new JMenu("수강관리");
		result = new JMenu("성적관리");
		user = new JMenu("사용자등록");
		
		menuBar.add(std);
		menuBar.add(prof);
		menuBar.add(dept);
		menuBar.add(sub);
		menuBar.add(attend);
		menuBar.add(result);
		menuBar.add(user);
		
		sItem = new JMenuItem("등록");
		pItem = new JMenuItem("등록");
		dItem = new JMenuItem("등록");
		subItem = new JMenuItem("등록");
		aItem = new JMenuItem("등록");
		rItem = new JMenuItem("조회");
		uItem = new JMenuItem("사용자등록");

		std.add(sItem);
		prof.add(pItem);
		dept.add(dItem);
		sub.add(subItem);
		attend.add(aItem);
		result.add(rItem);
		user.add(uItem);
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new UnivMenu();
	}
}
