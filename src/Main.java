import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    AbstractAnalyser analyser;
    //Map<Character, Integer> wordLetterMap;
    List<String> wordsList;
    List<String> output;
    int charactersFromWord=0;
    Map<Float, List<String>> outputList;
    /**
     * Driver class that embraces program execution sequence.
     * @throws IOException
     */
    private void start() throws IOException {
        System.out.println("Please input the statement for analysis:");
        String toAnalyse = Util.getValidLineInput();
        this.init(toAnalyse);
        this.compute();
        this.saveResult();

    }

    /**
     * Method used for basic initialisations based on input statement.
     * @param statement
     */
    private void init(String statement){
        analyser = new LogicAnalyser();
        wordsList = analyser.analyseStatement(statement);
        charactersFromWord = analyser.getCharactersFromWord();
        output = new ArrayList<String>();
        outputList = new TreeMap<>();
    }

    /**
     * This method computes the actual frequency of letter occurrences.
     * @return
     */
    private float compute(){
        int totalCount=0;
        for(String s:wordsList){
            totalCount+=s.length();
            for(char x:s.toCharArray()){
                if (analyser.getWordLetterMap().containsKey(x)){
                    analyser.wordLetterMap.put(x,analyser.wordLetterMap.get(x)+1);
                }
            }
            this.addResultRecord(s.length());
            analyser.getWordLetterMap().replaceAll((K,V) ->V=0);
        }
        float freq=(float)charactersFromWord/totalCount;
        List<String> list;
        if (outputList.containsKey(freq)){
            list = outputList.get(freq);
        }else{
            list = new ArrayList<>();
        }
        list.add("TOTAL Frequency: "+Util.df.format(Util.roundNum(freq))+" ("+charactersFromWord+"/"+totalCount+")");
        outputList.put(freq,list);
        return freq;
    }


    /**
     * This method takes care of appending each record associated with one word to the output.
     * @param wordSize
     * @return
     */
    private String addResultRecord(int wordSize){
        int freqLetterCount=0;
        StringBuilder sb = new StringBuilder();
        sb.append("{ (");
        for(char x:analyser.getWordLetterMap().keySet()){
            if (analyser.wordLetterMap.get(x)>0){
                if(freqLetterCount>0) sb.append(", ");
                freqLetterCount+=analyser.wordLetterMap.get(x);
                sb.append(x);
            }
        }
        float freq = (float)freqLetterCount/charactersFromWord;
        sb.append("), "+wordSize+"} = "+Util.df.format(Util.roundNum(freq))+" ("+freqLetterCount+"/"+charactersFromWord+")");
        output.add(sb.toString());
        if (outputList.containsKey(freq)){
            List<String> list = outputList.get(freq);
            list.add(sb.toString());
            outputList.put(freq, list);
        }else{
            List<String> list = new ArrayList<>();
            list.add(sb.toString());
            outputList.put(freq,list);
        }
        return sb.toString();
    }

    /**
     * This method writes the output to the file and prints it on te screen
     * @throws IOException
     */
    private void saveResult() throws IOException {
        File file = new File("output.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for(List<String> list:outputList.values()){
            for(String s:list){
                System.out.println(s);
                bw.write(s+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
    public static void main(String args[]) throws IOException {
        Main main = new Main();
        main.start();
    }
}
