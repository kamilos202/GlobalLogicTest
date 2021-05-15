import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractAnalyser {
    Map<Character, Integer> wordLetterMap;
    String wordProcessing;
    int charactersFromWord=0;

    protected abstract List<String> analyseStatement(String statement);

    public Map<Character, Integer> getWordLetterMap() {
        return wordLetterMap;
    }
    public int getCharactersFromWord() {
        return charactersFromWord;
    }
}
