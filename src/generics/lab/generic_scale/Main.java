package generics.lab.generic_scale;

public class Main {
    public static void main(String[] args) {
        String first = "wow";
        String second = "wow";

        Scale<String> scale = new Scale<>(first, second);

        System.out.println(scale.getHeavier());
    }
}
