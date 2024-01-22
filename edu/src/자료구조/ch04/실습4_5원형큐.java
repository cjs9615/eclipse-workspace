package 자료구조.ch04;

/*
 * 원형 큐로서 큐에 Item 객체를 저장 - 교재 소스코드를 원형 큐가 되도록 수정하는 연습
 *   - 원형 큐를 어려워 한다 
 * 원형 큐 실습보다는 객체들의 큐를 ArrayList로 구현하는 실습이 더 유용
 */

import java.util.Scanner;

class Item {
	int data;

	public Item(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return " < " + this.data + " > ";
	}
}
public class 실습4_5원형큐 {

	static final int QUEUE_SIZE = 4;
	Item[] circleQueue;
	int front, rear, num;
	static boolean isEmpty;

	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException() {}
	}
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException() {}
	}
	public 실습4_5원형큐() {
		//구현
		front = rear = num = 0;
		circleQueue = new Item[QUEUE_SIZE];
		isEmpty = true;
	}
	void push(int data) throws OverflowQueueException{
		//구현
		if (num >= QUEUE_SIZE)
			throw new OverflowQueueException();
		isEmpty = false;
		circleQueue[rear++] = new Item(data);
		num++;
		if (rear == QUEUE_SIZE)
			rear = 0;
	}

	Item pop() throws EmptyQueueException {
		//구현
		if (num <= 0)
			throw new EmptyQueueException();
		Item i = circleQueue[front++];
		if(--num == 0)
			isEmpty = true;
		if(front == QUEUE_SIZE)
			front = 0;
		return i;
	}

	void clear() {
			//구현
		num = front = rear = 0;
		isEmpty = true;
	}

	void print() {
			//구현
		if(isEmpty)
			System.out.println("큐가 비어 있습니다.");
		else {
			for(int i = 0; i < num; i++)
				System.out.print(circleQueue[(i + front) % QUEUE_SIZE] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int pick;
		실습4_5원형큐 cq = new 실습4_5원형큐();
		while(true) {

			System.out.println("1. Push   2. Pop   3. Clear   4. Print   0. exit");
			System.out.print("명령을 선택해주세요. => ");
			pick = sc.nextInt();
			if (pick == 0)
				break;
			Item result = null;
			switch(pick){
			case 1: 
				try{
					cq.push((int)Math.round(Math.random() * 10));
				} catch (실습4_5원형큐.OverflowQueueException e) {
					System.out.println("큐가 가득차 있습니다.");
				}
				break;
			case 2:
				try {
					result= cq.pop();
					System.out.println("pop: result = " + result);
				} catch (실습4_5원형큐.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;
			case 3: cq.clear(); break;
			case 4: cq.print(); break;
			default: continue;
			}
		}

	}
}

