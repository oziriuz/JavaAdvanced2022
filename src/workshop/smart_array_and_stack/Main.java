package workshop.smart_array_and_stack;

public class Main {
    public static void main(String[] args) {

        SmartArray smartArray = new SmartArray();
        smartArray.add(0, 1);
        smartArray.add(13);
        smartArray.add(42);
        smartArray.add(69);
        smartArray.add(73);
        smartArray.add(2, 58);
        System.out.println(smartArray.remove(0));
        System.out.println(smartArray.size());
        System.out.println(smartArray.contains(2));
        System.out.println(smartArray.contains(73));
        smartArray.forEach(System.out::println);

        Stack stack = new Stack();
        stack.push(13);
        stack.push(42);

    }
}
