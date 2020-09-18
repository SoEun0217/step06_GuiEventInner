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
	JButton btn1 = new JButton("ù��°");
	JButton btn2 = new JButton("�ι�°");
	JTextField text = new JTextField(30);

	public JFrameAnonymousInnerEventExam() {
		super("JFrameExam �Դϴ�.");

		// Container�� Layout�� �����ϱ�
		super.setLayout(new FlowLayout());

		// Container ���� Component�� �߰��ϱ�
		super.add(btn1, BorderLayout.NORTH);
		super.add(btn2, BorderLayout.WEST);
		super.add(text);

		// �ɼ�
		// â�� ��ġ�� ũ�� ����
		super.setSize(500, 400);
		// super.setLocation(100,200);
		super.setLocationRelativeTo(null);// �� setSize()�ϰ� ���� �ؾ� ������� ����

		// â ������
		super.setVisible(true);// ���̱�

		// x�� Ŭ������ �� â�� ������ �ݱ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// �̺�Ʈ ��� - �̺�Ʈ��ü.addXxxListener(������ü);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText("�ȳ�!!");
			}
		});// ���ڽ��� �����߱⶧���� this

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

	}// ������

	public static void main(String[] args) {
		new JFrameAnonymousInnerEventExam();
	}

}// OuterŬ���� ��
///////////////////////////////
