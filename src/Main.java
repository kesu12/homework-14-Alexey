import java.io.*;

public class Main {
    public static void main(String[] args) {

        File file = new File("Romeo and Juliet.txt");
        StringBuilder builder = new StringBuilder();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            do {
                line = bufferedReader.readLine();
                builder.append(line).append("\n");
            } while(line!=null);
        }
         catch (IOException e) {
            throw new RuntimeException(e);
        }

        String text = builder.toString();

//        System.out.println(text);

        String regex = "[!\"#$%&()*+,-./:;<=>?@\\[\\\\\\]^_`{|}~\\s]";
        String[] words = text.split(regex);

        String longestWord = "";

        for(String word : words){
            if(!word.isEmpty() && longestWord.length()<word.length()){
                longestWord = word;
            }
        }

        System.out.println(longestWord);

//      words[1]

//        File newFile = new File("biggest word.txt");
//        try{
//            file.createNewFile();
//            FileWriter fw = new FileWriter(newFile);
//            fw.append(words[1]);
//            fw.close();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }

    }
}