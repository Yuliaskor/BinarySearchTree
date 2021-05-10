import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BinarySearchTreeTest {
    @Test
    void insert() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> answer = new ArrayList<>() {
            {
                add(20);
                add(30);
                add(40);
                add(50);
                add(60);
                add(70);
                add(80);
            }
        };
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        assertArrayEquals(answer.toArray(), tree.inorder().toArray());


    }

    @Test
    void delete() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> answer = new ArrayList<>() {
            {
                add(20);
                add(30);
                add(40);
                add(50);
                add(60);
                add(80);
            }
        };
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.delete(70);

        assertArrayEquals(answer.toArray(), tree.inorder().toArray());
    }

    @ParameterizedTest
    @MethodSource("provideDataForUpper")
    void upper(int[] table, int search, int expected) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int element:table
             ) {
            tree.insert(element);
        }
        assertEquals(expected,tree.upper(search));
    }

    private static Stream<Arguments> provideDataForUpper() {
        return Stream.of(
                Arguments.of(new int[]{50, 30, 20, 40, 70, 80, 60}, 33,40),
                Arguments.of(new int[]{50, 30, 20, 40, 70, 80, 60}, 44,50),
                Arguments.of(new int[]{50, 30, 20, 40, 70, 80, 60}, 9,20),
                Arguments.of(new int[]{50, 30, 20, 40, 70, 80, 60}, 77,80),
                Arguments.of(new int[]{50, 30, 20, 40, 70, 80, 60}, 70,70)
        );

    }

    @ParameterizedTest
    @MethodSource("provideDataForLower")
    void lower(int[] table, int search, int expected) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int element:table
        ) {
            tree.insert(element);
        }
        assertEquals(expected,tree.lower(search));
    }

    private static Stream<Arguments> provideDataForLower() {
        return Stream.of(
                Arguments.of(new int[]{50, 30, 20, 40, 70, 80, 60}, 33,30),
                Arguments.of(new int[]{50, 30, 20, 40, 70, 80, 60}, 44,40),
                Arguments.of(new int[]{50, 30, 20, 40, 70, 80, 60}, 90,80),
                Arguments.of(new int[]{50, 30, 20, 40, 70, 80, 60}, 77,70),
                Arguments.of(new int[]{50, 30, 20, 40, 70, 80, 60}, 70,70)
        );

    }

    @Test
    void postorder() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> answer = new ArrayList<>() {
            {
                add(20);
                add(40);
                add(30);
                add(60);
                add(80);
                add(70);
                add(50);
            }
        };
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        assertArrayEquals(answer.toArray(), tree.postorder().toArray());
    }

    @Test
    void preorder() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> answer = new ArrayList<>() {
            {
                add(50);
                add(30);
                add(20);
                add(40);
                add(70);
                add(60);
                add(80);
            }
        };
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        assertArrayEquals(answer.toArray(), tree.preorder().toArray());
    }
}