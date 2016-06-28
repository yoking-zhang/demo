package org.yoking.collection;

import java.util.Collection;
import java.util.Iterator;

public class LinkedNode<T> {
	private Node<T> head;

	public LinkedNode() {
		this.head = null;
	}

	public Node<T> getHeader() {
		return head;
	}

	/**
	 * Collection初始化链表
	 */
	public LinkedNode(Collection<T> c) {
		for (Iterator<T> it = c.iterator(); it.hasNext();) {
			addLast(new Node<T>(it.next(), null));
		}
	}

	/**
	 * 从链表头部添加元素
	 */
	public void addFirst(Node<T> node) {
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	/**
	 * 从链表尾部添加元素
	 */
	public void addLast(Node<T> node) {
		if (head == null) {
			head = node;
		} else {
			Node<T> p = head;
			while (p.next != null) {
				p = p.next;
			}
			p.next = node;
		}
	}

	/**
	 * 从交换反转链表
	 */
	public void reverse() {
		if (head == null || head.next == null) return;

		Node<T> p = head, q = head.next, n;
		while (q != null) {
			n = q.next;
			q.next = p;
			p = q;
			q = n;
		}
		head.next = null;
		head = p;
	}

	public void reverseInRecursion() {
		this.head = reverse(this.head);
	}

	/**
	 * 从递归反转链表
	 */
	private Node<T> reverse(Node<T> head) {
		if (head == null || head.next == null) return head;

		Node<T> reHead = reverse(head.next);
		head.next.next = head;
		head.next = null;

		return reHead;
	}

	/**
	 * 打印链表
	 */
	public void printLinkedNode() {
		if (head != null) {
			Node<T> p = head;
			System.out.print("[ ");
			while (p != null) {
				System.out.print(p.item);
				p = p.next;
				if (p != null)
					System.out.print(" -> ");
			}
			System.out.println(" ]");
		}
	}

	private static class Node<T> {
		Node<T> next;
		T item;

		Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}
	}
}