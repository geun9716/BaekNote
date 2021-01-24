package Day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Heap2 {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		MinHeap mh = new MinHeap();
		N = sc.nextInt();
		
		for(int n=0; n < N ; n++) {
			int input = sc.nextInt();
			if (input > 0)
			{
				mh.insert(input);
			}
			else {
//				System.out.println(mh.heap);
				System.out.println(mh.delete());
			}
		}
	}

}
class MaxHeap{
	List<Integer> heap;
	
	public MaxHeap() {
		heap = new ArrayList<>();
		heap.add(0);
	}

	public void insert(int val) {
		//���� ���� �׸� �߰�
		heap.add(val);
		System.out.println(heap);
		int current = heap.size()-1;
		int parent = current / 2;
		while (true) {
			// ��Ʈ�� ���� �� ���
			if (current == 1 || heap.get(parent) > heap.get(current)) { // �θ� ������ ū ���
				break;
			}
			// �θ� ������ ū ���
			int tmp = heap.get(current);
			heap.set(current, heap.get(parent));
			heap.set(parent, tmp);
			current = parent;
			parent = current / 2;
		}
		System.out.println(heap);
	}
	
	public int delete() {
		// ��Ʈ ���� ���� �� ���� ������ ���� ��Ʈ�� ������.
		if (heap.size() <= 1)
			return 0;
		int result = heap.get(1);
		heap.set(1, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int currentPos = 1;
		while(true) {
			int left = currentPos*2;
			int right = currentPos*2+1;
			//�ڽ� ���� ���� Ȯ��
			
			if(left >= heap.size()) {
				break;
			}
			//����, ���� �� ū �� ����
			int maxValue = heap.get(left);
			int maxPos = left;
			
			if(right < heap.size() && heap.get(right) > maxValue) {
				maxValue = heap.get(right);
				maxPos = right;
			}
			
			if(maxValue > heap.get(currentPos)) {
				int tmp = heap.get(currentPos);
				heap.set(currentPos, heap.get(maxPos));
				heap.set(maxPos, tmp);
				currentPos = maxPos;
			}
			else {
				break;
			}
			// ���õ�  �ڽ��� �ڽź��� ���� ���
			// ���õ� �ڽ��� �ڽź��� ū ���
		}
		System.out.println(heap);
		return result;
	}
}
