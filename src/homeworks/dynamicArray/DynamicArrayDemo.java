package homeworks.dynamicArray;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();

        for (int i = 1; i < 50; i += 3) {
            dynamicArray.add(i);
        }
        dynamicArray.print();

        System.out.println();
        System.out.println(dynamicArray.getByIndex(6));
    }
}
