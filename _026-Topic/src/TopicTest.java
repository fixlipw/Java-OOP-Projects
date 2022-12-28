import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class TopicTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    static Topic topic = new Topic(5, 2);

    @Test
    void test1(){
        topic.insert(new Pass("davi", 17));
        assertEquals("[@ @ =davi:17 = =]", topic.toString());
    }

    @Test
    void test2(){
        topic.insert(new Pass("joao", 103));
        topic.insert(new Pass("ana", 35));
        assertEquals("[@joao:103 @ =davi:17 =ana:35 =]", topic.toString());
    }

    @Test
    void test3(){
        topic.insert(new Pass("rex", 20));
        topic.insert(new Pass("bia", 16));
        assertEquals("[@joao:103 @bia:16 =davi:17 =ana:35 =rex:20]", topic.toString());
    }

    @Test
    void test4(){
        topic.remove("davi");
        assertEquals("[@joao:103 @bia:16 = =ana:35 =rex:20]", topic.toString());
    }

    @Test
    void test5(){
        topic.insert(new Pass("aragao", 96));
        assertEquals("[@joao:103 @bia:16 =aragao:96 =ana:35 =rex:20]", topic.toString());
    }

    @Test
    void test6(){
        topic.insert(new Pass("lucas", 19));
        assertEquals("fail: topic lotada", outputStreamCaptor.toString().trim());
    }

    @Test
    void test7(){
        topic.remove("marcelo");
        assertEquals("fail: marcelo nao esta na topic", outputStreamCaptor.toString().trim());
    }

    @Test
    void test8(){
        topic.remove("ana");
        topic.insert(new Pass("bia", 13));
        assertEquals("fail: bia ja esta na topic", outputStreamCaptor.toString().trim());
    }

    @Test
    void test9(){
        assertEquals("[@joao:103 @bia:16 =aragao:96 = =rex:20]", topic.toString());
    }
}