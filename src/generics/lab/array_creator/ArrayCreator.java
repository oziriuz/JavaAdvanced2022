package generics.lab.array_creator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator<T> {
    public static <T> T[] create(int length, T defaultValue) {
        return create(defaultValue.getClass(), length, defaultValue);
    }

    public static <T> T[] create(Class<?> clazz, int length, T defaultValue) {
        T[] arr = (T[]) Array.newInstance(clazz, length);
        Arrays.fill(arr, defaultValue);

        return arr;
    }
}
