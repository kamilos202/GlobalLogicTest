import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class LogicAnalyser extends AbstractAnalyser{
    public LogicAnalyser(){
        super();
        super.wordProcessing = "logic";
        wordLetterMap = new LinkedHashMap<>();
        for(char x:Util.word) {
            wordLetterMap.put(x, 0); // autoboxing
        }
    }

    /**
     * This method takes the statement to be analysed as a parameter and returns the words that are included in statement.
     * @param statement
     * @return
     */
    @Override
    protected List<String> analyseStatement(String statement) {
        List<String> words = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        statement = statement.toLowerCase();
        for(char x:statement.toCharArray()){
            if (Util.definedChars.indexOf(x)==-1){
                sb.append(x);
            }else if(sb.length()>0){
                words.add(sb.toString().toLowerCase());
                sb.setLength(0); // here I can also allocate new space with new StringBuffer() - but it is slower than setting length to 0
            }
            if (wordProcessing.indexOf(x) != -1){
                charactersFromWord++;
            }

        }
        if(sb.length()>0){
            words.add(sb.toString().toLowerCase());
            sb.setLength(0); // here I can also allocate new space with new StringBuffer() - but it is slower than setting length to 0
        }
        return words;
    }
}
