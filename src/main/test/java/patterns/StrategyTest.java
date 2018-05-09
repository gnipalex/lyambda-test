package patterns;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class StrategyTest {

    @Test
    public void shouldSortCollection() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 5, 3, 0));

        Strategy.sort(list, Integer::compareTo);
        System.out.println(list);

        Assertions.assertThat(list).containsExactly(0, 1, 3, 5);
    }

    @Test
    public void shouldSortCatsCollection() {
        List<Builder.Cat> cats = new ArrayList<Builder.Cat>() {
            {
                add(Builder.Cat.builder().setAge(2).build());
                add(Builder.Cat.builder().setAge(1).build());
                add(Builder.Cat.builder().setAge(0).build());
                add(Builder.Cat.builder().setAge(1).build());
            }
        };
        Strategy.sort(cats, new Builder.CatsByAgeComparator());
        Assertions.assertThat(cats).extracting(Builder.Cat::getAge).containsExactly(0,1,1,2);
    }

}

