package org.wm.mycontianer.linkedlist;

import org.wm.mycontianer.Iterator;
import org.wm.mycontianer.MyList;

/**
 * 单向链表
 * @param <T>
 */
public class MyLinkedList<T> implements MyList<T> {

    private Node<T> head;

    int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        Node<T> node = head.getNext();
        for (int index = 0; index < i ;index++)
            node = node.getNext();
        return node;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T o) {
        return !(indexOf(o) < 0);
    }

    @Override
    public int indexOf(T o) {
        Node<T> node = head.getNext();
        for (int i = 0; i < size; i++)
            if (node.equals((Node<T>) o))
                return i;
        return -1;
    }

    @Override
    public boolean add(Object o) {
        add(size,o);
        return true;
    }

    private String outOfBoundsMsg(int index){
        return "输入参数有误-->>Index:"+index+",Size:"+size;
    }

    private void checkElementIndex(int index){
        if(!(index>=0 && index<=size))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

// 0 1 2 3 4
    @Override
    public boolean add(int index, Object o) {
        checkElementIndex(index);

        Node<T> indexNode = head;
        Node<T> preNode = head;
        if (index > 0)
            preNode =(Node<T>) get(index -1);
        indexNode = preNode.getNext();
        Node<T> curNode = (Node<T>) o;
        preNode.setNext(curNode);
        curNode.setNext(indexNode);
        size++;
        return true;
    }

    @Override
    public boolean addBefore(T obj, T e) {
        return false;
    }

    @Override
    public boolean addAfter(T obj, T e) {
        return false;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public boolean remove(T o) {
        return false;
    }

    @Override
    public Object replace(int index, T o) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }


}

