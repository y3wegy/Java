import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReleaseTest {
    private static final List<String> nameList = Arrays.asList(new String[]{"Chen,Rui", "Zhang,Jianhao", "Li,Lifang", "Zeng,Weilong", "Chu,Shuaifeng"});

    @Test
    public void testCCCC() {
        Collections.shuffle(nameList);
        Collections.shuffle(nameList);
        nameList.forEach(System.out::println);
    }
}
