package _20221024;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;

public class NotePad extends JFrame implements ActionListener {
	NotePad np;
	JMenuBar menuBar;
	JMenu file, edit, form, helpMenu, etc1, etc2, fontMenu, sizeMenu, styleMenu;
	JMenuItem createNew, createWindow, open, save, saveNew, print, exit,
			actionCancel, reAction, cut, copy, paste, delete, find, selectAll, date,
			font, help, info, search, translation, textSize, textStyle, textFont, textColor1, textColor2,
			jmCopy, jmCut, jmPaste;
	JPopupMenu popupMenu;
	JFileChooser chooser;
	JTextPane textArea;
	String path;
	FileDialog dialog;
	JColorChooser colorChooser;
	SimpleAttributeSet saset;
	UndoManager undoManager;
	JCheckBoxMenuItem font1, font2, font3, size1, size2, size3, plain, bold, italic;
	ButtonGroup fontGroup, sizeGroup, styleGroup;
	Dimension dimen, dimen1;
	int xpos, ypos;
	
	NotePad() {
		setWindows();
		pop();
		event();
	}
	
	void setWindows() {
		setTitle("제목 없음 - 메모장");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		dimen = tk.getScreenSize();
		dimen1 = getSize();
		
		xpos = (int) ((dimen.getWidth() / 2)-150 - (dimen1.getWidth() / 2)-150);
		ypos = (int) ((dimen.getHeight() / 2)-150 - (dimen1.getHeight() / 2)-150);
		setLocation(xpos, ypos);
		
		Image logo = tk.getImage("C:\\Users\\kcd\\Desktop\\자바\\이미지/icon1.png");
		setIconImage(logo);
		
		saset = new SimpleAttributeSet();
		
		menuBar = new JMenuBar();
		
		file = new JMenu("파일(F)");
		edit = new JMenu("편집(E)");
		form = new JMenu("서식(O)");
		helpMenu = new JMenu("도움말(H)");
		etc1 = new JMenu("기타1");
		etc2 = new JMenu("기타2");
		
		fontMenu = new JMenu("글꼴(F)");
		sizeMenu = new JMenu("글자크기");
		styleMenu = new JMenu("모양");
		
		file.setMnemonic('F');
		edit.setMnemonic('E');
		form.setMnemonic('O');
		helpMenu.setMnemonic('H');
		
		createNew = new JMenuItem("새로만들기(N)");
		createWindow = new JMenuItem("새 창(W)");
		open = new JMenuItem("열기(O)");
		save = new JMenuItem("저장(S)");
		saveNew = new JMenuItem("다른 이름으로 저장(A)");
		print = new JMenuItem("인쇄(P)");
		exit = new JMenuItem("끝내기(X)");
		
		actionCancel = new JMenuItem("실행 취소");
		reAction = new JMenuItem("다시 실행");
		cut = new JMenuItem("잘라내기(X)");
		copy = new JMenuItem("복사(C)");
		paste = new JMenuItem("붙여넣기(V)");
		delete = new JMenuItem("삭제");
		find = new JMenuItem("찾기");
		selectAll = new JMenuItem("모두선택(A)");
		date = new JMenuItem("시간/날짜(D)");
		
		font = new JMenuItem("글꼴(F)");
		help = new JMenuItem("도움말(H)");
		info = new JMenuItem("메모장 정보(A)");
		search = new JMenuItem("인터넷 검색");
		translation = new JMenuItem("한영 번역");
		
		textSize = new JMenuItem("글자크기");
		textStyle = new JMenuItem("글자속성");
		textFont = new JMenuItem("글꼴");
		textColor1 = new JMenuItem("글자색상");
		textColor2 = new JMenuItem("색상");
		
		fontGroup = new ButtonGroup();
		font1 = new JCheckBoxMenuItem("굴림체");
		font2 = new JCheckBoxMenuItem("궁서체");
		font3 = new JCheckBoxMenuItem("돋움체");
		fontGroup.add(font1);
		fontGroup.add(font2);
		fontGroup.add(font3);
		
		sizeGroup = new ButtonGroup();
		size1 = new JCheckBoxMenuItem("15");
		size2 = new JCheckBoxMenuItem("20");
		size3 = new JCheckBoxMenuItem("100");
		sizeGroup.add(size1);
		sizeGroup.add(size2);
		sizeGroup.add(size3);
		
		styleGroup = new ButtonGroup();
		plain = new JCheckBoxMenuItem("보통");
		bold = new JCheckBoxMenuItem("굵게");
		italic = new JCheckBoxMenuItem("기울이기");
		styleGroup.add(plain);
		styleGroup.add(bold);
		styleGroup.add(italic);
		
		createNew.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		saveNew.addActionListener(this);
		print.addActionListener(this);
		exit.addActionListener(this);
		find.addActionListener(this);
		font.addActionListener(this);
		help.addActionListener(this);
		info.addActionListener(this);
		textColor2.addActionListener(this);
		
		createNew.setAccelerator(KeyStroke.getKeyStroke('N', ActionEvent.CTRL_MASK));
		createWindow.setAccelerator(KeyStroke.getKeyStroke('W', ActionEvent.CTRL_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke('S', ActionEvent.CTRL_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke('O', ActionEvent.CTRL_MASK));
		saveNew.setAccelerator(KeyStroke.getKeyStroke('A', ActionEvent.CTRL_MASK));
		print.setAccelerator(KeyStroke.getKeyStroke('P', ActionEvent.CTRL_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke('X', ActionEvent.CTRL_MASK));
		
		actionCancel.setAccelerator(KeyStroke.getKeyStroke('Z', ActionEvent.CTRL_MASK));
		reAction.setAccelerator(KeyStroke.getKeyStroke('Y', ActionEvent.CTRL_MASK));
		cut.setAccelerator(KeyStroke.getKeyStroke('X', ActionEvent.CTRL_MASK));
		copy.setAccelerator(KeyStroke.getKeyStroke('C', ActionEvent.CTRL_MASK));
		paste.setAccelerator(KeyStroke.getKeyStroke('V', ActionEvent.CTRL_MASK));
		delete.setAccelerator(KeyStroke.getKeyStroke('D', ActionEvent.CTRL_MASK));
		find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.CTRL_MASK));
		selectAll.setAccelerator(KeyStroke.getKeyStroke('A', ActionEvent.CTRL_MASK));
		//date.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5));
		
		font.setAccelerator(KeyStroke.getKeyStroke('F', ActionEvent.CTRL_MASK));
		help.setAccelerator(KeyStroke.getKeyStroke('H', ActionEvent.CTRL_MASK));
		info.setAccelerator(KeyStroke.getKeyStroke('I', ActionEvent.CTRL_MASK));
		
		file.add(createNew);
		file.add(createWindow);
		file.add(open);
		file.add(save);
		file.add(saveNew);
		file.addSeparator();
		file.add(print);
		file.addSeparator();
		file.add(exit);
		
		edit.add(actionCancel);
		edit.add(reAction);
		edit.addSeparator();
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(delete);
		edit.addSeparator();
		edit.add(find);
		edit.add(selectAll);
		edit.add(date);

		form.add(font);
		helpMenu.add(search);
		helpMenu.add(translation);
		helpMenu.addSeparator();
		helpMenu.add(help);
		helpMenu.add(info);
		
		etc1.add(textSize);
		etc1.add(textStyle);
		etc1.add(textFont);
		etc1.add(textColor1);

		etc2.add(fontMenu);
		etc2.add(sizeMenu);
		etc2.add(textColor2);
		etc2.add(styleMenu);
		
		fontMenu.add(font1);
		fontMenu.add(font2);
		fontMenu.add(font3);
		sizeMenu.add(size1);
		sizeMenu.add(size2);
		sizeMenu.add(size3);
		styleMenu.add(plain);
		styleMenu.add(bold);
		styleMenu.add(italic);
		
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(form);
		menuBar.add(helpMenu);
		menuBar.add(etc1);
		menuBar.add(etc2);
		
		setJMenuBar(menuBar);
		
		textArea = new JTextPane();
		textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		add(textArea);
		
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	void pop() {
		popupMenu = new JPopupMenu();
		jmCopy = new JMenuItem("복사(C)");
		jmCut = new JMenuItem("잘라내기(X)");
		jmPaste = new JMenuItem("붙여넣기(V)");
		
		jmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		jmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		jmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		
		popupMenu.add(jmCopy);
		popupMenu.addSeparator();
		popupMenu.add(jmCut);
		popupMenu.addSeparator();
		popupMenu.add(jmPaste);
		
		textArea.add(popupMenu);
		
		jmCopy.addActionListener(this);
		jmCut.addActionListener(this);
		jmPaste.addActionListener(this);
		
		textArea.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == 3)
					popupMenu.show(textArea, e.getX(), e.getY());
			}
		});
		
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setTitle("*제목 없음 - 메모장");
			}
		});
	}
	
	void event() {
		undoManager = new UndoManager();
		
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				undoManager.addEdit(e.getEdit());
			}
		});
		
		actionCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					undoManager.undo();
				} catch (CannotRedoException e2) {
					// TODO: handle exception
				}
			}
		});
		
		reAction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					undoManager.redo();
				} catch (CannotRedoException e2) {
					// TODO: handle exception
				}
			}
		});
		
		createWindow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NotePad();
			}
		});
		
		cut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.cut();
			}
		});
		
		copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.copy();
			}
		});
		
		paste.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.paste();
			}
		});
		
		selectAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.selectAll();
			}
		});
		
		date.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String date = currentTime();
//				Date date = new Date();
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분 ss초");
				JOptionPane.showMessageDialog(null, date, "현재시간", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.replaceSelection("");
			}
		});
		
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String url = "http://search.naver.com/search.naver?where=nexearch&query=";			
				try {
					Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + url);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		translation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textArea.getSelectedText() == null) { // 선택된 내용이 없다면
					JOptionPane.showConfirmDialog(null, "검색할 단어에 블록을 설정해 주세요", "alert", JOptionPane.DEFAULT_OPTION);
				}
				else {
						String word = textArea.getSelectedText();
						String url = "http://translate.google.co.kr/#ko/en/" + word;
						// String url = "https://dic.daum.net/#en/ko/"+ word ;// 영한 번역
						try {
							Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
		
		info.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().open(new File("C://Windows/system32/notepad.exe"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//Desktop.getDesktop().open(new File("C://Windows/system32/mspaint.exe"));	// 그림판
			}
		});
		
		help.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String url = "https://support.office.com/ko-kr/article/%EB%A9%94%EB%AA%A8%EC%9E%A5-%EB%8F%84%EA%B5%AC-c136c884-871b-4481-8ace-7c206271d50a";
				try {
					Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + url);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		font1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StyleConstants.setFontFamily(saset, font1.getText());
				textArea.setCharacterAttributes(saset, true);
			}
		});
		
		font2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StyleConstants.setFontFamily(saset, font2.getText());
				textArea.setCharacterAttributes(saset, true);
			}
		});
		
		font3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StyleConstants.setFontFamily(saset, font3.getText());
				textArea.setCharacterAttributes(saset, true);
			}
		});
		
		size1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StyleConstants.setFontSize(saset, Integer.parseInt(size1.getText()));
				textArea.setCharacterAttributes(saset, true);
			}
		});
		
		size2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StyleConstants.setFontSize(saset, Integer.parseInt(size2.getText()));
				textArea.setCharacterAttributes(saset, true);
			}
		});
		
		size3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StyleConstants.setFontSize(saset, Integer.parseInt(size3.getText()));
				textArea.setCharacterAttributes(saset, true);
			}
		});
		
		plain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StyleConstants.setBold(saset, false);
				StyleConstants.setItalic(saset, false);
				textArea.setCharacterAttributes(saset, true);
			}
		});
		
		bold.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StyleConstants.setBold(saset, true);
				textArea.setCharacterAttributes(saset, true);
			}
		});
		
		italic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StyleConstants.setItalic(saset, true);
				textArea.setCharacterAttributes(saset, true);
			}
		});
		
		textSize.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(null, "글자크기 입력하세요.");
				if (input != null) {
					int size = Integer.parseInt(input);
					StyleConstants.setFontSize(saset, size);
					textArea.setCharacterAttributes(saset, true);
				}
			}
		});
		
		textStyle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] styles = {"보통","굵게","기울이기"};
				Object input = JOptionPane.showInputDialog(null, "글자속성 선택하세요.", "글자속성",
						JOptionPane.QUESTION_MESSAGE, null, styles, styles[0]);
				String str = (String) input;
				if (input != null) {
					if (str.equals(styles[0])) {
						StyleConstants.setBold(saset, false);
						StyleConstants.setItalic(saset, false);
					}
					else if (str.equals(styles[1]))
						StyleConstants.setBold(saset, true);
					else if (str.equals(styles[2]))
						StyleConstants.setItalic(saset, true);
					
					textArea.setCharacterAttributes(saset, true);
				}
			}
		});
		
		textFont.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] fonts = {"굴림","궁서체","돋움체"};
				Object input = JOptionPane.showInputDialog(null, "글꼴 선택하세요.", "글꼴",
						JOptionPane.QUESTION_MESSAGE, null, fonts, fonts[0]);
				String str = (String) input;
				
				if (input != null) {
					StyleConstants.setFontFamily(saset, str);
					textArea.setCharacterAttributes(saset, true);
				}
			}
		});
		
		textColor1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] colors = {"blue","yellow","red"};
				Object input = JOptionPane.showInputDialog(null, "글자색상 선택하세요.", "글자색상",
						JOptionPane.QUESTION_MESSAGE, null, colors, colors[0]);
				String str = (String) input;
				
				if (input != null) {
					if (str.equals(colors[0]))
						StyleConstants.setForeground(saset, Color.blue);
					else if (str.equals(colors[1]))
						StyleConstants.setForeground(saset, Color.yellow);
					else if (str.equals(colors[2]))
						StyleConstants.setForeground(saset, Color.red);
					
					textArea.setCharacterAttributes(saset, true);
				}
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] options = {"저장(S)", "저장안함(N)", "취소"};
		Object o = e.getSource();
		
		if (o == createNew) {
			String s = textArea.getText();
			path = null;
			
			if (getTitle().charAt(0) == '*') {
				int i = JOptionPane.showOptionDialog(null, "새로 작성하신 내용을 저장하시겠습니까?", "저장", JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				
				if (i == 0) {
					dialog = new FileDialog(this, "다른 이름으로 저장", FileDialog.SAVE);
					dialog.setFile("*.txt");
					dialog.setVisible(true);
					path = dialog.getDirectory() + dialog.getFile();
					
					try {
						FileWriter w = new FileWriter(path);
						w.write(s);
						w.close();
						
						textArea.setText(null);
						setTitle("제목 없음 - 메모장");
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "파일을 저장하지 못했습니다.");
					}
				}
				else if (i == 1) {
					textArea.setText(null);
					setTitle("제목 없음 - 메모장");
				}
				else if (i == 2) {
					setTitle("*제목 없음 - 메모장");
				}
			}
			else {
				textArea.setText(null);
				setTitle("제목 없음 - 메모장");
			}
		}
		
		if (o == open) {
			String s = textArea.getText();
			path = null;
			
			if (getTitle().charAt(0) == '*') {
				int i = JOptionPane.showOptionDialog(null, "새로 작성하신 내용을 저장하시겠습니까?", "저장", JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				
				if (i == 0) {
					dialog = new FileDialog(this, "다른 이름으로 저장", FileDialog.SAVE);
					dialog.setFile("*.txt");
					dialog.setVisible(true);
					
					path = dialog.getDirectory() + dialog.getFile();
					
					try {
						FileWriter w = new FileWriter(path);
						w.write(s);
						w.close();
						
						textArea.setText(null);
						setTitle("제목 없음 - 메모장");
						
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "파일을 저장하지 못했습니다.");
					}
				}
				else if (i == 1) {
					dialog = new FileDialog(this, "열기", FileDialog.LOAD);
					dialog.setFile("*.txt");
					dialog.setVisible(true);
					
					path = dialog.getDirectory() + dialog.getFile();
					String string = "";
					
					try {
						FileReader r = new FileReader(path);
						int k;
						
						while (true) {
							k = r.read();
							if (k == -1)
								break;
							
							string += (char) k;
						}
						
						if (path.equals("nullnull"))
							setTitle("제목 없음 - 메모장");
						else
							this.setTitle(path);
						r.close();
						
					} catch (Exception e2) {
						
					}
					textArea.setText(string);
				}
			}
			else {
				dialog = new FileDialog(this, "열기", FileDialog.LOAD);
				dialog.setFile("*.txt");
				dialog.setVisible(true);
				
				path = dialog.getDirectory() + dialog.getFile();
				String string = "";
				
				try {
					FileReader r = new FileReader(path);
					int k;
					
					while (true) {
						k = r.read();
						if (k == -1)
							break;
						
						string += (char) k;
					}
					if (path.equals("nullnull"))
						setTitle("제목 없음 - 메모장");
					else
						this.setTitle(path);
					
					r.close();
					
				} catch (Exception e2) {
					
				}
				textArea.setText(string);
			}
		}
		
		if (o == save) {
			if (path == null) {
				dialog = new FileDialog(this, "저장", FileDialog.SAVE);
				dialog.setFile("*.txt");
				dialog.setVisible(true);
				
				if (dialog.getFile() != null) {
					path = dialog.getDirectory() + dialog.getFile();
					
					try {
						FileWriter w = new FileWriter(path);
						String s = textArea.getText();
						w.write(s);
						w.close();
						
						setTitle(path);
						
					} catch (Exception e2) {
						
					}
				}
			}
			else {
				try {
					FileWriter w = new FileWriter(path);
					String s = textArea.getText();
					w.write(s);
					w.close();
					
					setTitle(path);
					
				} catch (Exception e2) {
					
				}
			}
		}
		
		if (o == saveNew) {
			dialog = new FileDialog(this, "다른 이름으로 저장", FileDialog.SAVE);
			dialog.setFile("*.txt");
			dialog.setVisible(true);
			
			path = dialog.getDirectory() + dialog.getFile();
			
			try {
				FileWriter w = new FileWriter(path);
				String s = textArea.getText();
				w.write(s);
				w.close();
				
				if (path.equals("nullnull"))
					setTitle("제목 없음 - 메모장");
				else
					this.setTitle(path);
				
			} catch (Exception e2) {
				
			}
		}
		
//		if (o == print) {
//			
//		}
		
		if (o == exit) {
			String s = textArea.getText();
			path = null;
			
			if (s.length() != 0) {
				int i = JOptionPane.showOptionDialog(null, "새로 작성하신 내용을 저장하시겠습니까?", "저장", JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				
				if (i == 0) {
					dialog = new FileDialog(this, "다른 이름으로 저장", FileDialog.SAVE);
					dialog.setFile("*.txt");
					dialog.setVisible(true);
					
					path = dialog.getDirectory() + dialog.getFile();
					
					try {
						FileWriter w = new FileWriter(path);
						w.write(s);
						w.close();
						
						textArea.setText(null);
						setTitle("제목 없음 - 메모장");
						
					} catch (Exception e2) {
						
					}
				}
				else if (i == 1) {
					 dispose();
				}
			}
			else {
				dispose();
			}
		}
		
		if (o == find) {
			new FindDialog(this);
		}
		
		if (o == textColor2) {
			colorChooser = new JColorChooser();
			Color selectedColor = colorChooser.showDialog(this, "색상을 고르세요", Color.black);
			
			if (selectedColor != null) {
				StyleConstants.setForeground(saset, selectedColor);
				textArea.setCharacterAttributes(saset, true);
			}
		}
		
		if (o == font) {
			new FontDialog(this);
		}
	}
	
	String currentTime() {
		Calendar time_day = Calendar.getInstance();
		String time_string = "";
		int dayOfWeek = time_day.get(Calendar.DAY_OF_WEEK);
		String week = "";
		switch (dayOfWeek) {
		case Calendar.SUNDAY:
			week = "일요일";
			break;
		case Calendar.MONDAY:
			week = "월요일";
			break;
		case Calendar.TUESDAY:
			week = "화요일";
			break;
		case Calendar.WEDNESDAY:
			week = "수요일";
			break;
		case Calendar.THURSDAY:
			week = "목요일";
			break;
		case Calendar.FRIDAY:
			week = "금요일";
			break;
		case Calendar.SATURDAY:
			week = "토요일";
		}
		time_string = week + " ";
		if (time_day.get(Calendar.AM_PM) == 1)
			time_string += "오후 ";
		else
			time_string += "오전 ";
		if (time_day.get(Calendar.HOUR) == 0)
			time_string += "12:";
		else
			time_string += time_day.get(Calendar.HOUR) + ":";
		if (time_day.get(Calendar.MINUTE) < 10)
			time_string += "0";
		time_string += time_day.get(Calendar.MINUTE) + " ";
		time_string += time_day.get(Calendar.YEAR) + "-" + (time_day.get(Calendar.MONTH)+1) + "-" + time_day.get(Calendar.DAY_OF_MONTH);
		return time_string;
	}

	public static void main(String[] args) {
		new NotePad();
	}
}