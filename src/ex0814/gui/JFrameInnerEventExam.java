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
	JButton btn1 = new JButton("ù��°");
	JButton btn2 = new JButton("�ι�°");
	JTextField text = new JTextField(30);

	public JFrameInnerEventExam() {
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
		btn1.addActionListener(this);// ���ڽ��� �����߱⶧���� this
		btn2.addActionListener(this);
		this.addMouseListener(new MEventExam());
		text.addKeyListener(new TextKeyEventExam());

	}//������

	public static void main(String[] args) {
		new JFrameInnerEventExam();
	}

	int i;

	@Override
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();// ��ư�� �۾�

		Object eventObj = e.getSource();// �̺�Ʈ�� �߻���Ų ��ü
		if (eventObj == btn1) {
			// text�ڽ����� "�ȳ�"���
			text.setText(label + "��ư �ȳ�" + i++);
		} else {
			System.out.println(label + "��ư�� ������ ����˴ϴ�.");
			System.exit(0);
		}
	}

	/**
	 * 
	 * ���콺�� Ŭ������ �� ȣ��Ǵ� �޼ҵ� ����
	 */

	class MEventExam extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			// ���콺 ��ǥ ���ϱ�
			int x = e.getX();
			int y = e.getY();

			// text.set�̶�� Ŭ������ �и��������Ƿ� text�� ã�� �� ����

			text.setText("x = " + x + " y = " + y);

			// JFrame�� title�� �۾� �ø���
			//Outer Ŭ������ ��ü�� ����... : OuterŬ�����̸�.this.�޼ҵ��̸�
			JFrameInnerEventExam.this.setTitle("x = " + x + " y = " + y);
		}

	}
	
	/**
	 * text�� key�� �������� �� ���
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

}// OuterŬ���� ��
///////////////////////////////
