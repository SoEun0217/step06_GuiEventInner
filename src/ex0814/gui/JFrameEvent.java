package ex0814.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JFrameEvent extends JFrame implements ActionListener{
	JButton btn1 = new JButton("ù��°");
	JButton btn2 = new JButton("�ι�°");
	JTextField text = new JTextField(30);

	public JFrameEvent() {
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
		this.addMouseListener(new MEventExam(text));

	}

	public static void main(String[] args) {
		new JFrameEvent();
	}

	int i;

	@Override
	public void actionPerformed(ActionEvent e) {
		String label=e.getActionCommand();//��ư�� �۾�
		
		
		Object eventObj = e.getSource();// �̺�Ʈ�� �߻���Ų ��ü
		if (eventObj == btn1) {
			// text�ڽ����� "�ȳ�"���
			text.setText(label+"��ư �ȳ�" +i++);
		} else {
			System.out.println(label+"��ư�� ������ ����˴ϴ�.");
			System.exit(0);
		}
	}

}

///////////////////////////////
/**
 * 
 * ���콺�� Ŭ������ �� ȣ��Ǵ� �޼ҵ� ����
 * */

class MEventExam extends MouseAdapter{
	JTextField text;
	MEventExam(JTextField text) {//�ٸ� ���� �ִ� text�� �������� �����ڷ� �޴� ����ۿ� ����.
		this.text=text;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	//���콺 ��ǥ ���ϱ�
		int x=e.getX();
		int y=e.getY();
		
		//text.set�̶�� Ŭ������ �и��������Ƿ� text�� ã�� �� ����
		
		text.setText("x = "+x+" y = "+y);
		
		//JFrame�� title�� �۾� �ø���
	}
	
}









