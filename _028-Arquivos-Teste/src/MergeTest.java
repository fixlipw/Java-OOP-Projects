import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeTest {

    @Test
    void mergeSort1() {
        int[] teste1_1 = {1, 4, 6, 8, 14, 23};
        int[] teste1_2 = {2, 3, 5, 7, 11, 18, 19, 20};
        int[] teste1_merged = {1, 2, 3, 4, 5, 6, 7, 8, 11, 14, 18, 19, 20, 23};

        assertArrayEquals(teste1_merged, Merge.mergeSort(teste1_1, teste1_2));
    }

    @Test
    void mergeSort2(){

        int[] teste2_1 = {2, 3, 4};
        int[] teste2_2 = {2, 3, 4};
        int[] teste2_merged = {2, 2, 3, 3, 4, 4};

        assertArrayEquals(teste2_merged, Merge.mergeSort(teste2_1, teste2_2));
    }

    @Test
    void mergeSort3(){

        int[] teste3_1 = {1, 4, 6, 34, 123};
        int[] teste3_2 = {5, 6, 34};
        int[] teste3_merged = {1, 4, 5, 6, 6, 34, 34, 123};

        assertArrayEquals(teste3_merged, Merge.mergeSort(teste3_1, teste3_2));
    }

    @Test
    void mergeSort4(){

        int[] teste4_1 = {1, 2, 3};
        int[] teste4_2 = {4, 5, 6};
        int[] teste4_merged = {1, 2, 3, 4, 5, 6};

        assertArrayEquals(teste4_merged, Merge.mergeSort(teste4_1, teste4_2));
    }

    @Test
    void mergeSort5(){

        int[] teste5_1 = {4, 5, 6};
        int[] teste5_2 = {1, 2, 3};
        int[] teste5_merged = {1, 2, 3, 4, 5, 6};

        assertArrayEquals(teste5_merged, Merge.mergeSort(teste5_1, teste5_2));
    }
}