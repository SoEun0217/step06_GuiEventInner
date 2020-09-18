package ex0814.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JFrameInnerEventExam extends JFrame implements ActionListener {
	JButton btn1 = new JButton("첫번째");
	JButton btn2 = new JButton("두번째");
	JTextField text = new JTextField(30);

	public JFrameInnerEventExam() {
		super("JFrameExam 입니다.");

		// Container의 Layout을 변경하기
		super.setLayout(new FlowLayout());

		// Container 위에 Component를 추가하기
		super.add(btn1, BorderLayout.NORTH);
		super.add(btn2, BorderLayout.WEST);
		super.add(text);

		// 옵션
		// 창의 위치와 크기 설정
		super.setSize(500, 400);
		// super.setLocation(100,200);
		super.setLocationRelativeTo(null);// 꼭 setSize()하고 나서 해야 정가운데에 놓임

		// 창 보여줘
		super.setVisible(true);// 보이기

		// x를 클릭했을 때 창을 완전히 닫기
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 이벤트 등록 - 이벤트주체.addXxxListener(구현객체);
		btn1.addActionListener(this);// 나자신이 구현했기때문에 this
		btn2.addActionListener(this);
		this.addMouseListener(new MEventExam());
		text.addKeyListener(new TextKeyEventExam());

	}//생성자

	public static void main(String[] args) {
		new JFrameInnerEventExam();
	}

	int i;

	@Override
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();// 버튼의 글씨

		Object eventObj = e.getSource();// 이벤트를 발생시킨 주체
		if (eventObj == btn1) {
			// text박스위에 "안녕"출력
			text.setText(label + "버튼 안녕" + i++);
		} else {
			System.out.println(label + "버튼이 눌러져 종료됩니다.");
			System.exit(0);
		}
	}

	/**
	 * 
	 * 마우스를 클릭했을 때 호출되는 메소드 정의
	 */

	class MEventExam extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			// 마우스 좌표 구하기
			int x = e.getX();
			int y = e.getY();

			// text.set이라면 클래스가 분리되있으므로 text을 찾을 수 없음

			text.setText("x = " + x + " y = " + y);

			// JFrame의 title에 글씨 올리기
			//Outer 클래스의 객체를 접근... : Outer클래스이름.this.메소드이름
			JFrameInnerEventExam.this.setTitle("x = " + x + " y = " + y);
		}

	}
	
	/**
	 * text에 key가 눌러졌을 때 기능
	 * */
	class TextKeyEventExam extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			char ch=e.getKeyChar();
			int code=e.getKeyCode();
			
			btn1.setText("ch : "+ch);
			btn2.setText("code : "+code);
			
			
		}
		
	}

}// Outer클래스 끝
///////////////////////////////
