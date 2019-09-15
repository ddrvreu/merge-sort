package test;

import com.ddrvreu.mergesort.sorter.MergeSorter;
import com.ddrvreu.mergesort.sorter.internal.IntegerMergeSorter;
import com.ddrvreu.mergesort.sorter.internal.StringMergeSorter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerMergeSorterTest {

    private final MergeSorter<Integer> integerAscSorter = new IntegerMergeSorter((Comparator.naturalOrder()));
    private final MergeSorter<Integer> integerDescSorter = new IntegerMergeSorter((Comparator.reverseOrder()));

    private final MergeSorter<String> stringAscSorter = new StringMergeSorter((Comparator.naturalOrder()));
    private final MergeSorter<String> stringDescSorter = new StringMergeSorter((Comparator.reverseOrder()));

    private final List<InputStream> inputs = new LinkedList<>();
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Test
    public void integerSorterValidDataAscTest() {
        inputs.add(TestUtils.createInputStream("2 3 5 5 8 12"));
        inputs.add(TestUtils.createInputStream("1 2 3 4"));
        inputs.add(TestUtils.createInputStream("7 10 10 25"));

        integerAscSorter.sort(output, inputs);

        assertEquals("1 2 2 3 3 4 5 5 7 8 10 10 12 25", TestUtils.getActualString(output));
    }

    @Test
    public void integerSorterValidDataDescTest() {
        inputs.add(TestUtils.createInputStream("55 14 3 -7"));
        inputs.add(TestUtils.createInputStream("12 8 5 5 3 2"));
        inputs.add(TestUtils.createInputStream("4 3 2 1"));

        integerDescSorter.sort(output, inputs);

        assertEquals("55 14 12 8 5 5 4 3 3 3 2 2 1 -7", TestUtils.getActualString(output));
    }

    @Test
    public void stringSorterValidDataAscTest() {
        inputs.add(TestUtils.createInputStream("aa\nab\nabb\naza44aaaffffff"));
        inputs.add(TestUtils.createInputStream("ac\nafa\naza\nazaz\nazaza"));
        inputs.add(TestUtils.createInputStream("a\nb\nxx"));

        stringAscSorter.sort(output, inputs);

        assertEquals("a aa ab abb ac afa aza aza44aaaffffff azaz azaza b xx", TestUtils.getActualString(output));
    }

    @Test
    public void stringSorterValidDataDescTest() {
        inputs.add(TestUtils.createInputStream("asdadas31212\nas"));
        inputs.add(TestUtils.createInputStream("zzz\nss\naa"));
        inputs.add(TestUtils.createInputStream("af\na"));

        stringDescSorter.sort(output, inputs);

        assertEquals("zzz ss asdadas31212 as af aa a", TestUtils.getActualString(output));
    }
}