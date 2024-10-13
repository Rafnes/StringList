package StringList;

import StringList.exceptions.NegativeIndexException;
import StringList.exceptions.NotFoundException;
import StringList.exceptions.NullStringException;
import StringList.exceptions.IndexOutOfBoundsException;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] array;
    private int size;

    public StringListImpl() {
        array = new String[5];
    }

    public StringListImpl(int size) {
        array = new String[size];
    }

    public String[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String add(String item) {
        validateString(item);
        checkCapacity();
        array[size++] = item;
        return item;
    }


    @Override
    public String add(int index, String item) {
        validateIndex(index);
        validateString(item);
        checkCapacity();
        if (index == size) {
            add(item);
            return item;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        size++;
        array[index] = item;
        return item ;
    }

    private void checkCapacity() {
        if (size == array.length - 1) {
            int newSize = array.length + 5;
            String[] newArray = new String[newSize];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateString(item);
        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateString(item);
        int index = indexOf(item);

        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = array[index];

        if (index != size) {
            System.arraycopy(array, index + 1, array, index, size - index);
            size--;
            return item;
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size; i <= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NullStringException();
        } else {
            return Arrays.equals(this.toArray(), otherList.toArray());
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        array = new String[5];
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                result += array[i];
            } else {
                result += array[i] + ", ";
            }
        }
        return result;
    }

    private void validateString(String item) {
        if (item == null) {
            throw new NullStringException();
        }
    }

    private void validateIndex(int i) {
        if (i < 0) {
            throw new NegativeIndexException();
        }
        if (i > size) {
            throw new IndexOutOfBoundsException();
        }
    }

}
