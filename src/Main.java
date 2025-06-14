import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File file = new File("Romeo and Juliet.txt");
        String text = "";
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(fileReader.ready()) {
                text += (char)fileReader.read();
            }
        }
         catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(text);
        String regex = "[!\"#$%&()*+,-./:;<=>?@\\[\\\\\\]^_`{|}~\\s]";
        String[] split = text.split(regex);

        for(int i = 0; i< split.length; i++){
            for (int j = 1; j < split.length-1; j++) {
                String temp = split[i];
                if(split[j].length()<split[i].length()){
                    split[i] = split[j];
                    split[j] = temp;
                }
            }
        }
        //split[1]
        File newFile = new File("biggest word.txt");
        try{
            file.createNewFile();
            FileWriter fw = new FileWriter(newFile);
            fw.append(split[1]);
            fw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}