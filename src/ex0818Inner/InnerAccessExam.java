package ex0818Inner;

/**
 * InnerClass ���� - ���� ��ġ�� ���� 3���� ���� 
 * 1) �ν��Ͻ� ��� Ŭ���� 
 * 2) ����(static) ��� Ŭ����
 * 3)����(�޼ҵ� ���ο� ����) Ŭ����
 */
class Test {
	int a = 50;
	static int b = 10;

	public void testMethod() {
	}

	public static void testMethod2() {
	}

	/**
	 * 1) �ν��Ͻ� ��� Ŭ���� 
	 * : Inner Ŭ���� ���ο� static ����, �޼ҵ� ����Ұ�. 
	 * : Outer �ʿ� �ִ� static,non-static ��� ����(ȣ��)����. 
	 * : innerŬ���� �տ� public,protected,����,private�� �� �ִ�.
	 */
	class InstanceInner {
		int a = 100;

		// static int b=50;
		public void aa() {
			System.out.println(a);
			System.out.println(this.a);
			System.out.println(Test.this.a);// �̸��� �ߺ��ɶ�.�ܺ��� a �� ����

			System.out.println(b);// Outer���� static �����Ѱ�.

			testMethod();
			testMethod2();
		}
		// public static void bb() {}

	}/////////////////////////////////

	/**
	 * 2) ����(static) ��� Ŭ���� 
	 * : static, non-static ��� ���� ����. 
	 * : Outer���� non-static ����(ȣ��) �Ұ�.
	 */
	static class StaticInner {
		int a = 40;
		static String name = "����";

		public void aa() {
			System.out.println(a);
			System.out.println(this.a);
			// System.out.println(Test.this.a); Outer�ʿ� �ִ� static �̱� ������ Test�� �������� �ʾ����Ƿ� a
			// ���ٺҰ�
			System.out.println(b);
			System.out.println(name);
			// testMethod(); non-static�̹Ƿ� ���ٺҰ�
			testMethod2();

		}

		public static void bb() {
		}
	}

	/**
	 * 3)����(�޼ҵ� ���ο� ����) Ŭ���� 
	 * : static ���� �Ұ� 
	 * : ������(����,static,final ��) �� �� ����.
	 * :�����̳�Ŭ������ �ݵ�� �޼ҵ尡 ȣ��ǰ� �� �޼ҵ� �ȿ���
	 *  �̳�Ŭ������ ȣ���ؾ��Ѵ�.
	 */
	public void outerMethod() {
		class LocalClass {
			int a = 12;

			// static int b=3;
			public void aa() {
				System.out.println(a);
				System.out.println(b);
			}
			// public static void bb() {}
		}// local inner class��
		LocalClass lc=new LocalClass();
		lc.aa();
	}// method��

}// Outer��

public class InnerAccessExam {

	public static void main(String[] args) {
		// 1. �ν��Ͻ��̳�Ŭ���� ȣ���ϱ�
//		Test t=new Test();
//		Test.InstanceInner instanceInner=t.new InstanceInner();//t�� ���ؼ� �������Ѵ�.������Ÿ�� �� Ȯ���ϱ�!!!
//		instanceInner.aa();

		// 2. static ��� �̳�Ŭ���� ȣ���ϱ�
//		Test.StaticInner stInner = new Test.StaticInner();// Test�� ���������ʰ� Inner�� �����Ѱ�
//		stInner.aa();
		
		//3. LocalŬ���� �����ϱ�
		Test t=new Test();
		t.outerMethod();
	
	}

}
