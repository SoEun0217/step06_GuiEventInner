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

public class JFrameAnonymousInnerEventExam extends JFrame {
	JButton btn1 = new JButton("첫번째");
	JButton btn2 = new JButton("두번째");
	JTextField text = new JTextField(30);

	public JFrameAnonymousInnerEventExam() {
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
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText("안녕!!");
			}
		});// 나자신이 구현했기때문에 this

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				text.setText("x" + x + "y" + y);
			}

		});
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char ch = e.getKeyChar();
				int code = e.getKeyCode();
				btn1.setText("ch : " + ch);
				btn2.setText("code : " + code);

			}
		});

	}// 생성자

	public static void main(String[] args) {
		new JFrameAnonymousInnerEventExam();
	}

}// Outer클래스 끝
///////////////////////////////
