package ua.edu.ucu.collections.immutable;


import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList{
    private final Object[] items;
    private final int length;

    public ImmutableArrayList() {
        this.items = new Object[]{};
        this.length = 0;
    }

    public ImmutableArrayList(Object[] items) {
        this.items = items;
        this.length = items.length;
    }

    @Override
    public ImmutableArrayList add(Object e) {
        ImmutableArrayList newArray = new ImmutableArrayList(new Object[]{e});
        return newArray.addAll(0, this.items);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (index > this.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return this.addAll(this.length, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index > this.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newArray = new Object[this.length + c.length];
        System.arraycopy(this.items, 0, newArray, 0, index);
        System.arraycopy(c, 0, newArray, index, c.length);
        if (c.length + this.length - index + c.length >= 0)
            System.arraycopy(this.items, index, newArray, index + c.length,this.length - index);
        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        if (index >= this.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.items[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (index >= this.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newArray = new Object[this.length - 1];
        System.arraycopy(this.items, 0, newArray, 0, index);
        if (this.length - 1 - index >= 0)
            System.arraycopy(this.items, index + 1,newArray, index, this.length - 1 - index);
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index >= this.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newArray = Arrays.copyOf(this.items, this.length);
        newArray[index] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.length; i++) {
            if (this.items[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public Object[] toArray() {
        return this.items;
    }

    public String toString() {
        return Arrays.toString(this.items);
    }
}
