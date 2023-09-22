package homeworks.dynamicArray;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();

        for (int i = 1; i < 50; i += 3) {
            dynamicArray.add(i);
        }
        dynamicArray.print();

        dynamicArray.deleteByIndex(15);
        System.out.println();
        dynamicArray.print();

        dynamicArray.set(0, 8);
        System.out.println();
        dynamicArray.print();

        dynamicArray.add(3, 56);
        System.out.println();
        dynamicArray.print();

        System.out.println();
        System.out.println(dynamicArray.exists(10));
        System.out.println(dynamicArray.exists(80));

        System.out.println(dynamicArray.getIndexByValue(7));
        System.out.println(dynamicArray.getIndexByValue(80));
    }
}
