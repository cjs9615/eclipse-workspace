package 자료구조.ch09;
/*
 * 23.6.7 3회차 실습 코드
 */
import java.util.Random;
import java.util.Scanner;


//정수를 저정하는 이진트리 만들기 실습

class TreeNode {
	TreeNode LeftChild;
	int data;
	TreeNode RightChild;

	public TreeNode(int x) {
		LeftChild = RightChild = null;
		data = x;
	}
}

class Tree {
	TreeNode root;

	Tree() {
		root = null;
	}

	TreeNode inorderSucc(TreeNode current) {
		TreeNode temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		return temp;
	}

	boolean isLeafNode(TreeNode current) {
		if (current.LeftChild == null && current.RightChild == null)
			return true;
		else
			return false;
	}

	void inorder() {
		inorder(root);
	}

	void preorder() {
		preorder(root);
	}

	void postorder() {
		postorder(root);
	}

	void inorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}

	void preorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	boolean insert(int x) {// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을
		TreeNode tmp = new TreeNode(x), p = root, q = null;					// 설계하여 구현
		if(p == null) {
			root = tmp;
			return true;
		}
		while(p != null) {
			if (x > p.data) {
				q = p;
				p = p.RightChild;
			}
			else if (x < p.data) {
				q = p;
				p = p.LeftChild;
			}
			else return false;
		}
		if(x > q.data) {
			q.RightChild = tmp;
		}
		else q.LeftChild = tmp;
		return true;
	}

	boolean delete(int num) {
		if (root == null) {
			System.out.println("값이 하나도 존재하지 않습니다.");
			return false;
		}
		
		TreeNode p = root, q = null;
		
		//root delete 할 때
		if (p.data == num && p.LeftChild == null && p.RightChild == null) {
			root = null;
			return true;
		}
		if (p.data == num && p.LeftChild == null) {
			root = root.RightChild;
			return true;
		}
		if (p.data == num && p.RightChild == null) {
			root = root.LeftChild;
			return true;
		}
		while(p != null) {
			if(p.data == num) {
				//자식 노드가 없을 때
				if(isLeafNode(p)) {
					if(q.LeftChild == p) {
						q.LeftChild = null;
					}
					else q.RightChild = null;
				}
				//자식 노드가 하나 있을 때
				else if(p.LeftChild == null) {
					if(q.LeftChild == p) {
						q.LeftChild = p.RightChild;
					}
					else q.RightChild = p.RightChild;
				}
				else if(p.RightChild == null) {
					if(q.LeftChild == p) {
						q.LeftChild = p.LeftChild;
					}
					else q.RightChild = p.LeftChild;
				}
				//자식 노드가 둘 다 있을 때
				else {
					TreeNode tmp = inorderSucc(p);
					p.data = tmp.data;
					q = p;
					p = p.RightChild;
					while(p != null) {
						if(p.data == tmp.data) {
							break;
						}
						if(num >= p.data) {
							q = p;
							p = p.RightChild;
						}
						else {
							q = p;
							p = p.LeftChild;
						}
					}
					if(isLeafNode(p)) {
						if(q.LeftChild == p) {
							q.LeftChild = null;
						}
						else q.RightChild = null;
					}
					else{
						if(q.LeftChild == p) {
							q.LeftChild = p.RightChild;
						}
						else q.RightChild = p.RightChild;
					}				
				}
				return true;
			}
			if(num > p.data) {
				q = p;
				p = p.RightChild;
			}
			else {
				q = p;
				p = p.LeftChild;
			}
		}
		return false;
	}

	boolean search(int num) {
		if (root == null) {
			System.out.println("값이 하나도 존재하지 않습니다.");
			return false;
		}
		TreeNode p = root;
		while(p != null) {
			if(p.data == num) {
				return true;
			}
			if(num > p.data) {
				p = p.RightChild;
			}
			else p = p.LeftChild;
		}
		return false;
	}
}

public class BinaryTree_int {
	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("순차출력"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner stdIn = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		Tree t = new Tree();
		Menu menu; // 메뉴
		int count = 0;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 노드 삽입
				System.out.println("The number of items = ");
				count = stdIn.nextInt();
				int[] input = new int[10];
				for (int ix = 0; ix < count; ix++) {
					input[ix] = rand.nextInt(20);
					System.out.print(input[ix] + " ");
				}
				System.out.println();
				for (int i = 0; i < count; i++) {
					if (!t.insert(input[i]))
						System.out.println("Insert Duplicated data");
				}
				break;

			case Delete: // 노드 삭제
				System.out.println("삭제할 데이터:: ");
				num = stdIn.nextInt();
				if (t.delete(num))
					System.out.println("삭제 데이터 = " + num + " 성공");
				else
					System.out.println("삭제 실패");
				;
				break;

			case Search: // 노드 검색
				System.out.println("검색할 데이터:: ");

				num = stdIn.nextInt();
				result = t.search(num);
				if (result)
					System.out.println(" 데이터 = " + num + "존재합니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				break;
			}
		} while (menu != Menu.Exit);
	}
}
