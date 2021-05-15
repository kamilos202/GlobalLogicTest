import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
class LogicAnalyserTest {
    private String testStatement = "I love to work in global logic!";
    List<String> list;

    @Test
    void analyseStatement() {
        AbstractAnalyser analyser = new LogicAnalyser();
        list = new ArrayList<>();
        list.add("I");
        list.add("love");
        list.add("to");
        list.add("work");
        list.add("in");
        list.add("global");
        list.add("logic");
        assertEquals(analyser.analyseStatement(testStatement),list);
    }
}