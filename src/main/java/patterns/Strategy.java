package patterns;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Strategy {

    static <T> void sort(List<T> list, Comparator<T> comparator) {

        for (int i = 0; i < list.size() - 1; i++) {

            for (int j = 0; j < list.size() - 1; j++) {

                int result = comparator.compare(list.get(j), list.get(j + 1));

                if (result == 1) {
                    T element = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, element);

                }
            }

        }


    }
}
