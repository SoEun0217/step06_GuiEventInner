package ex0814.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameExam extends JFrame {
	JButton btn1=new JButton("ù��°");
	JButton btn2=new JButton("�ι�°");
	public JFrameExam() {
		super("JFrameExam �Դϴ�.");
		
		
		//Container�� Layout�� �����ϱ�
		super.setLayout(new FlowLayout());
		
		
		//Container ���� Component�� �߰��ϱ�
		super.add(btn1,BorderLayout.NORTH);
		super.add(btn2,BorderLayout.WEST);
		
		//�ɼ�
		//â�� ��ġ�� ũ�� ����
		super.setSize(500,400);
		//super.setLocation(100,200);
		super.setLocationRelativeTo(null);//�� setSize()�ϰ� ���� �ؾ� ������� ����
		
		//â ������	
		super.setVisible(true);//���̱�
		
		
		//x�� Ŭ������ �� â�� ������ �ݱ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	public static void main(String[] args) {
		new JFrameExam();
	}
}
