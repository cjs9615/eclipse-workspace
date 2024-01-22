package 자료구조.ch11;

/*
Graph Representation
Adjacency Lists + BFS + DFS
*/

import java.util.Scanner;

class ListNode {
	int data;
	ListNode link;

	public ListNode(int data) {
		this.data = data;
		link = null;
	}
}

class List {
	ListNode first;
	public List() {
		first = null;
	}
	
	void Insert(int k) {//같은 값을 체크하지 않아 중복 입력됨
		// 구현할 부분
		ListNode temp = new ListNode(k);
		ListNode p = first, q = null ;
		
		if(p == null) {
			first = temp;
			return;
		}
		if(k < p.data) {
			temp.link = p;
			first = temp;
			return;
		}
		while(p != null) {
			if(p.data == k) return;
			if(k < p.data) {
				temp.link = p;
				q.link = temp;
				return;
			}
			q = p;
			p = p.link;
		}
		q.link = temp;
	}
	void Delete(int k) {
		// 구현할 부분
		ListNode p = first, q = null;
		
		if(p == null) return;
		if(p.data == k) {
			first = p.link;
			return;
		}
		while(p != null) {
			if(p.data == k) {
				q.link = p.link;
			}
			q = p;
			p = p.link;
		}
	}
}

class ListIterator {

	private List list;
	private ListNode current;

	public ListIterator(List l) {
		list = l;
		current = list.first;
	}

	int First() {
		if (current != null)
			return current.data;
		else
			return 0;
	}

	int Next() {
		int data = current.data;
		current = current.link;
		return data;
	}

	boolean NotNull() {
		if (current != null)
			return true;
		else
			return false;
	}

	boolean NextNotNull() {
		if (current.link != null)
			return true;
		else
			return false;
	}


}

class QueueNode {
	int data;
	QueueNode link;

	QueueNode(int data, QueueNode link) {
		this.data = data;
		this.link = link;
	}
}

class Queue {
	private QueueNode front, rear;

	void QueueEmpty() {
		front = rear = null;
	}

	public Queue() {
		QueueEmpty();
	}

	boolean IsEmpty() {
		if (front == null)
			return true;
		else
			return false;
	}

	void Insert(int y) {
		// 구현할 부분
		QueueNode temp = new QueueNode(y, null);
		if(IsEmpty()) {
			front = rear = temp;
			return;
		}
		if(front.link == null) {
			rear = temp;
			front.link = rear;
		}
		else {
			rear.link = temp;
		}
	}

	int Delete() {
		if(front == null) return -1;
		int result = front.data;
		front = front.link;
		
		return result;
	// 구현할 부분
	}
}
class StackNode {
	ListNode data;
	StackNode link;

	StackNode(ListNode data, StackNode link) {
		this.data = data;
		this.link = link;
	}
}
class Stack {
	private StackNode top;

	void StackEmpty() {
		top = null;
	}

	public Stack() {
		StackEmpty();
	}

	boolean IsEmpty() {
		if (top == null)
			return true;
		else
			return false;
	}

	void Insert(ListNode y) {
		// 구현할 부분
		StackNode temp = new StackNode(y, null);
		if(IsEmpty()) {
			top = temp;
		}
		else {
			temp.link = top;
			top = temp;
		}
	}

	ListNode Delete()
	// delete the top node in stack and return its data
	{
		// 구현할 부분
		ListNode p = top.data;
		top = top.link;
		return p;
	}
}


class Graph {
	private List[] HeadNodes;
	int n;
	boolean[] visited;

	public Graph(int vertices) {
		n = vertices;
		HeadNodes = new List[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			HeadNodes[i] = new List();
			visited[i] = false;
		}
		
	}

	void displayAdjacencyLists() {
		for (int i = 0; i < n; i++) {
			ListIterator iter = new ListIterator(HeadNodes[i]);
			if(!iter.NotNull()) {
				System.out.println(i + " -> null");
				continue;
			}
			System.out.print(i);
			for(int first = iter.First(); iter.NotNull(); first = iter.Next()) {
				first = iter.First();
				System.out.print(" -> " + first);
			}
			System.out.println();
			
			//iterator 이용해 구현
//			ListNode p = HeadNodes[i].first;
//			while(p!=null) {
//				System.out.println();
//				p = p.link;
//			}
//			
			// 구현할 부분
		}
	}

	void InsertVertex(int start, int end) {
		if (start < 0 || start >= n || end < 0 || end >= n) {
			System.out.println("the start node number is out of bound.");
			return;
		}
		//start = 0; end = 1;
//		List p = HeadNodes[start];
//		if (p==null) {
//			ListNode temp = new ListNode(start);
//			p.first = temp;
//		}
//		List q = HeadNodes[end];
//		if (q==null) {
//			ListNode temp = new ListNode(end);
//			q.first = temp;
//		}
		
		HeadNodes[start].Insert(end);
		HeadNodes[end].Insert(start);
		// 구현할 부분
	}

	void BFS(int v) {
		boolean[] visited = new boolean[n]; // visited is declared as a Boolean 
		for (int i = 0; i < n; i++)
			visited[i] = false; // initially, no vertices have been visited
		// 구현할 부분
		visited[v] = true;
		System.out.print(v + ",");
		Queue q = new Queue();
		q.Insert(v);
		
		while(!q.IsEmpty()) {
			v = q.Delete();
			ListIterator iter = new ListIterator(HeadNodes[v]);
			if(!iter.NotNull()) continue;
			int w = iter.First();
			while(true) {
				if(!visited[w]) {
					q.Insert(w);
					visited[w] = true;
					System.out.print(w + ",");
				}
				if(iter.NextNotNull()) {
					iter.Next();
					w = iter.First();
				}
				else break;
			}
		}
	}
	void ShowList(List l) {
		ListIterator li = new ListIterator(l);
		// 구현할 부분
	}

	// Driver
	void DFS(int v) {
		for (int i = 0; i < n; i++)
			visited[i] = false; // initially, no vertices have been visited

		//_DFS(v); // start search at vertex 0
		_NonRecursiveDFS(v);

	}

	// Workhorse
	void _DFS(int v)
	// visit all previously unvisited vertices that are reachable from vertex v
	{
		visited[v] = true;
		System.out.print(v + ", ");
		ListIterator li = new ListIterator(HeadNodes[v]);
		if (!li.NotNull())
			return;
		int w = li.First();
		while (true) {
			if (!visited[w])
				_DFS(w);
			if (li.NotNull())
				w = li.Next();
			else
				return;
		}
	}
	// Workhorse 2
		void _NonRecursiveDFS(int v)
		// visit all previously unvisited vertices that are reachable from vertex v
		{
			// 스택이용
			// 구현할 부분
			
			// iterator 버전
//			visited[v] = true;
//			System.out.print(v + ",");
//			
//			Stack s = new Stack();
//			s.Insert(HeadNodes[v].first);
//			
//			v = HeadNodes[v].first.data;
//			visited[v] = true;
//			System.out.print(v + ",");
//			
//			while(!s.IsEmpty()) {
//				v = s.Delete().data;
//				ListIterator iter = new ListIterator(HeadNodes[v]);
//				int w = iter.First();
//				while(true) {
//					if(!visited[w]) {
//						s.Insert(HeadNodes[w].first);
//						visited[w] = true;
//						System.out.print(w + ",");
//					}
//					if(iter.NextNotNull()) {
//						iter.Next();
//						w = iter.First();
//					}
//					else break;
//				}
//			}
			
			//iterator 안쓴 버전
			
			visited[v] = true;
			System.out.print(v + ",");
			
			Stack s = new Stack();
			s.Insert(HeadNodes[v].first);
			
			v = HeadNodes[v].first.data;
			visited[v] = true;
			System.out.print(v + ",");
			
			while(!s.IsEmpty()) {
				v = s.Delete().data;
				ListNode p = HeadNodes[v].first;
				int w = p.data;
				while(true) {
					if(!visited[w]) {
						s.Insert(p);
						visited[w] = true;
						System.out.print(w + ",");
						p = HeadNodes[w].first;
					}
					if(p.link != null) {
						p = p.link;
						w = p.data;
					}
					else {
						break;
					}
				}
			}
			
		}
}
public class Chap11_test_그래프DFS_BFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int select = 10, n, startEdge = -1, endEdge = -1;
		int startBFSNode = 100;// the start node to BFS

		System.out.println("vertex 숫자 입력: ");

		n = sc.nextInt();

		Graph g = new Graph(n);

		while (select != '0') {
			System.out.println("\n명령 선택 1: edge 추가, 2: Adjacency Lists 출력, 3: BFS, 4: DFS, 5: 종료 => ");
			select = sc.nextInt();
			switch (select) {
			case 1:
				System.out.println("edge 추가: from vertext: ");
				startEdge = sc.nextInt();
				System.out.println("to vertex: ");
				endEdge = sc.nextInt();
				if (startEdge < 0 || startEdge >= n || endEdge < 0 || endEdge >= n) {
					System.out.println("the input node is out of bound.");
					break;
				}
				// get smallest start node.
				if (startEdge < startBFSNode)
					startBFSNode = startEdge;
				if (endEdge < startBFSNode)
					startBFSNode = endEdge;
				g.InsertVertex(startEdge, endEdge);
				break;
			case 2:
				// display
				g.displayAdjacencyLists();
				break;

			case 3:
				System.out.println("Start BFS from node: " + startBFSNode);
				g.BFS(startBFSNode);
				break;
			case 4:
				System.out.println("Start DFS from node: " + startBFSNode);
				g.DFS(startBFSNode);
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("WRONG INPUT  " + "\n" + "Re-Enter");
				break;
			}
		}

		return;
	}
}

