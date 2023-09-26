package homeworks.dynamicArray;

public class DynamicArray {

    private int[] array = new int[10];
    private int size = 0;

    public void add(int value) {
        if (size < array.length) {
            array[size] = value;
            size++;
        } else {
            extend();
        }
    }

    private void extend() {
        int[] newArray = new int[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public int getByIndex(int index) {
        if (index < size && index >= 0) {
            return array[index];
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void deleteByIndex(int index) {
        if (index < size && index >= 0) {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            size--;
        } else {
            System.out.println("Haven't element with this index");
        }
    }

    public void set(int index, int value) {
        if (index < size && index >= 0) {
            array[index] = value;
        } else {
            System.out.println("Haven't element with this index");
        }
    }

    public void add(int index, int value) {
        if (index < size && index >= 0) {
            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            size++;
        } else {
            System.out.println("Haven't element with this index");
        }
    }

    public boolean exists(int value) {
        for (int i = 0; i < size; i++) {
            if (value == array[i]) {
                return true;
            }
        }
        return false;
    }

    public int getIndexByValue(int value) {
        for (int i = 0; i < size; i++) {
            if(value == array[i]){
                return i;
            }
        }
        return -1;
    }
}
