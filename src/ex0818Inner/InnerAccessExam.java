package ex0818Inner;

/**
 * InnerClass 정리 - 선언 위치에 따라 3가지 형태 
 * 1) 인스턴스 멤버 클래스 
 * 2) 정적(static) 멤버 클래스
 * 3)로컬(메소드 내부에 선언) 클래스
 */
class Test {
	int a = 50;
	static int b = 10;

	public void testMethod() {
	}

	public static void testMethod2() {
	}

	/**
	 * 1) 인스턴스 멤버 클래스 
	 * : Inner 클래스 내부에 static 변수, 메소드 선언불가. 
	 * : Outer 쪽에 있는 static,non-static 모두 접근(호출)가능. 
	 * : inner클래스 앞에 public,protected,생략,private올 수 있다.
	 */
	class InstanceInner {
		int a = 100;

		// static int b=50;
		public void aa() {
			System.out.println(a);
			System.out.println(this.a);
			System.out.println(Test.this.a);// 이름이 중복될때.외부의 a 를 접근

			System.out.println(b);// Outer쪽의 static 접근한것.

			testMethod();
			testMethod2();
		}
		// public static void bb() {}

	}/////////////////////////////////

	/**
	 * 2) 정적(static) 멤버 클래스 
	 * : static, non-static 모두 선언 가능. 
	 * : Outer쪽의 non-static 접근(호출) 불가.
	 */
	static class StaticInner {
		int a = 40;
		static String name = "소은";

		public void aa() {
			System.out.println(a);
			System.out.println(this.a);
			// System.out.println(Test.this.a); Outer쪽에 있는 static 이기 때문에 Test가 생성되지 않았으므로 a
			// 접근불가
			System.out.println(b);
			System.out.println(name);
			// testMethod(); non-static이므로 접근불가
			testMethod2();

		}

		public static void bb() {
		}
	}

	/**
	 * 3)로컬(메소드 내부에 선언) 클래스 
	 * : static 선언 불가 
	 * : 제한자(접근,static,final 등) 올 수 없다.
	 * :로컬이너클래스는 반드시 메소드가 호출되고 그 메소드 안에서
	 *  이너클래스를 호출해야한다.
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
		}// local inner class끝
		LocalClass lc=new LocalClass();
		lc.aa();
	}// method끝

}// Outer끝

public class InnerAccessExam {

	public static void main(String[] args) {
		// 1. 인스턴스이너클래스 호출하기
//		Test t=new Test();
//		Test.InstanceInner instanceInner=t.new InstanceInner();//t를 통해서 생성을한다.데이터타입 잘 확인하기!!!
//		instanceInner.aa();

		// 2. static 멤버 이너클래스 호출하기
//		Test.StaticInner stInner = new Test.StaticInner();// Test를 생성하지않고 Inner만 생성한것
//		stInner.aa();
		
		//3. Local클래스 생성하기
		Test t=new Test();
		t.outerMethod();
	
	}

}
