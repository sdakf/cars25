package pl.sda.cars25;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsTest {

    @Test
    void collectionsSpeed() {
        List<Long> firstList = new ArrayList<>();
        List<Long> secondList = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            firstList.add((long) i);
            secondList.add((long) i);
        }
        firstList.add((long) 1_000_001);

        firstList.removeAll(secondList);
        System.out.println(firstList);
    }
    @Test
    void collectionsSpeed2() {
        Set<Long> firstList = new HashSet<>();
        Set<Long> secondList = new HashSet<>();
        for (int i = 0; i < 1_000_000; i++) {
            firstList.add((long) i);
            secondList.add((long) i);
        }
        firstList.add((long) 1_000_001);

        firstList.removeAll(secondList);
        System.out.println(firstList);
    }
}
