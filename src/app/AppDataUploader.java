package app;

import HelpClasses.InformationDisplayer;
import Trainings.ProxyTrainingInstance;
import Trainings.TrainingInstance;

import java.io.*;
import java.util.HashMap;

public class AppDataUploader {
    public static HashMap<Integer, String> uploadDailyGoals(BufferedReader br) throws IOException {

        String helpToRememberLastLine = br.readLine();
        HashMap<Integer, String> result = new HashMap<>();
        while (!helpToRememberLastLine.equals("Daily goals ended")){
            result.put(Integer.parseInt(String.valueOf(helpToRememberLastLine.charAt(0))),
                    helpToRememberLastLine.substring(3));
            helpToRememberLastLine = br.readLine();
        }
        return result;
    }

    public void readAppSavedData(HashMap<String, TrainingInstance> trainings, InformationDisplayer _informationDisplayer){
        try (BufferedReader br = new BufferedReader(new FileReader("savedTrainings.txt"))){
            String actualLine = br.readLine();
            while (actualLine != null){
                trainings.put(actualLine, new ProxyTrainingInstance(actualLine, _informationDisplayer));
                actualLine = br.readLine();
            }
        } catch (FileNotFoundException exc){
            System.out.println("File not found. Help for debugging");
            exc.printStackTrace();
        } catch (IOException exc){
            exc.printStackTrace();
        }
    }

    public static String getNextLine(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String help = br.readLine();
            return help;
        } catch (IOException exc){
            exc.printStackTrace();
        }

        return null;
    }
}
