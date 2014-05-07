package com.shulga.algorithms.collections.adt;

public class QueueArray<T> implements Queue<T> {
	private T[] ar;
	private int front;
	private int rear;
	private int maxSize;
	private int nCount;
	
	@SuppressWarnings("unchecked")
	public QueueArray(int N){
		this.maxSize = N;
		ar = (T[]) new Object[maxSize];
		rear = -1;
	}
	
	@Override
	public boolean isEmpty() {
		return nCount==0;
	}

	@Override
	public void enqueue(T data) {
		if(rear==maxSize-1){
			rear=-1;
		}
		ar[++rear] = data;
		nCount++;
	}

	@Override
	public T dequeue() {
		T temp = ar[front++];
		if(front==maxSize){
			front=0;
		}
		nCount--;
		return temp;
	}

}
