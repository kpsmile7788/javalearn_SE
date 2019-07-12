package org.wm.mycontianer.arraylist;

import org.wm.mycontianer.Iterator;
import org.wm.mycontianer.MyList;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

    private Object[] elements;
    private int size;

    public Object[] getElements() {
        return elements;
    }

    public int getSize() {
        return size;
    }

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int size) {
        if(size < 0 ){
            throw new IllegalArgumentException("输入有误，请输入合法参数！(Argument > 0)");
        }
        elements = new Object[size];
    }

    @Override
    public int size() {
        return size;
    }


    T elementData(int index){
        return (T) elements[index];
    }

    private void rangeCheck(int index){
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void rangeCheckForAdd(int index){
        if (index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index){
        return "输入参数有误-->>Index:"+index+",Size:"+size;
    }

    @Override
    public T get(int i) {
        rangeCheck(i);
        return elementData(i);
    }

    @Override
    public boolean isEmpty() {
        return size >= 0;
    }

    @Override
    public boolean contains(T t) {
        return indexOf(t) >= 0;
    }

    @Override
    public int indexOf(T o) {

        if(o == null){
            for (int i = 0; i < size; i++) {
                if (elements[i] == null)
                    return i;
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i]))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public boolean add(T o) {
        ensureArraysFull(size + 1);
        elements[size++] = o;
        return true;
    }

    @Override
    public boolean add(int index, Object o) {
        rangeCheckForAdd(index);
        ensureArraysFull(size + 1);

        if (index < size){
            for(int i = size;i > index;i--){
                elements[i] = elements[i-1];
            }
            elements[index] = o;
        }
        if (index == size){
            elements[size] =elements[size-1];
            elements[size] = o;
        }
        size++;
        return true;
    }

    private void ensureArraysFull(int min){
        if(min - elements.length >0)
            grow(min);
    }
    private void grow() {
        elements = Arrays.copyOf(elements,size + size>>1);
    }
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        elements = Arrays.copyOf(elements, newCapacity);
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
    public T remove(int index) {
        rangeCheck(index);
        T oldValue = elementData(index);
        fastMove(index);

        return oldValue;
    }

    @Override
    public boolean remove(T o) {
        if(o == null){
            for (int i = 0; i <size ; i++) {
                if (elements[i] == null){
                    System.out.println("if");
                    fastMove(i);
                    return true;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])){
                    System.out.println("else"+i);
                    fastMove(i);
                    return true;
                }
            }
        }
        return false;
    }

    private void fastMove(int index) {

        for (int i = index; i < size-1 ; i++) {
            elements[i] = elements[i+1];
        }
        elements[--size] = null;
    }

    @Override
    public T replace(int index, T o) {
        rangeCheck(index);

        T oldValue = elementData(index);
        elements[index] = o;
        return oldValue;
    }

    @Override
    public Iterator<T> iterator() {
        return new itr();
    }

    private class itr implements Iterator<T> {

        private int cursor;
        private int lastRet = -1;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            int i = cursor;
            Object[] elements = MyArrayList.this.elements;
            cursor = i + 1;
            return (T) elements[lastRet = i];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyArrayList[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]+",");
        }
        if (size > 0)
            sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }
}
