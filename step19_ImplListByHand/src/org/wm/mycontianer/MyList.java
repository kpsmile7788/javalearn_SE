package org.wm.mycontianer;

public interface MyList<T> {

    public int size();

    public Object get(int i);

    public boolean isEmpty();

    public boolean contains(T o);

    public int indexOf(T o);

    public boolean add(T o);

    public boolean add(int index,Object o);

    public boolean addBefore(T obj, T e);

    public boolean addAfter(T obj, T e);

    public Object remove(int index);

    public boolean remove(T o);

    public Object replace(int index,T o);

    public Iterator<T> iterator();
}
