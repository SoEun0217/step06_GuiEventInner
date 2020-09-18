package ex0814.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameExam extends JFrame {
	JButton btn1=new JButton("첫번째");
	JButton btn2=new JButton("두번째");
	public JFrameExam() {
		super("JFrameExam 입니다.");
		
		
		//Container의 Layout을 변경하기
		super.setLayout(new FlowLayout());
		
		
		//Container 위에 Component를 추가하기
		super.add(btn1,BorderLayout.NORTH);
		super.add(btn2,BorderLayout.WEST);
		
		//옵션
		//창의 위치와 크기 설정
		super.setSize(500,400);
		//super.setLocation(100,200);
		super.setLocationRelativeTo(null);//꼭 setSize()하고 나서 해야 정가운데에 놓임
		
		//창 보여줘	
		super.setVisible(true);//보이기
		
		
		//x를 클릭했을 때 창을 완전히 닫기
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	public static void main(String[] args) {
		new JFrameExam();
	}
}
