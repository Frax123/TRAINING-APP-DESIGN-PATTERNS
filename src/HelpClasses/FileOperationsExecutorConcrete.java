package HelpClasses;

import app.AppDataUploader;

import java.io.*;
import java.util.Date;
import java.util.logging.Logger;

public class FileOperationsExecutorConcrete implements AppDataManager {
    private static final String PATH_TO_TRAININGS_DETAILS =
            "C:\\\\Users\\\\Krzysiek\\\\Desktop\\\\TRAINING_APP_DESIGN_PATTERNS\\\\TrainingsDetails\\\\";
    //private static final String EMPTY_TRAINING = "1: N\n2: N\n3: N\n4: N\n5: N\n6: N\n7: N";

    public static void copyFileWithoutLine(String path, String lineToErase) throws IOException {
        StringBuilder result = new StringBuilder("");
        BufferedReader fileToCopy = new BufferedReader(new FileReader(path));
        String helpWithCopyProcess = fileToCopy.readLine();
        while (helpWithCopyProcess!= null) {
            if (!helpWithCopyProcess.equals(lineToErase)) {
                result.append(helpWithCopyProcess);
            }
            helpWithCopyProcess = fileToCopy.readLine();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        bw.write(new String(result));
    }

    private static void addLineToFile(String path, String newLine) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("savedTrainings.txt", true));
        bw.write(newLine + "\n");
        bw.close();
    }

    @Override
    public void deleteFileInTrainingDetails(String name){
        File f = new File(PATH_TO_TRAININGS_DETAILS + name + ".txt");
        f.delete();
        System.out.println(f.exists());
    }

    @Override
    public void deleteTrainingData(String name){
        try {
            copyFileWithoutLine("savedTrainings.txt", name);
        } catch (IOException exc){
            exc.printStackTrace();
        }
    }

        private void addFileToTrainingsDetails(String name, Integer length, InformationDisplayer informator) throws IOException{
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    PATH_TO_TRAININGS_DETAILS + name + ".txt"));
            //Appending length
            bw.write(length + "\n");
            //Appending progress
            informator.printRequiredProgressInfo();
            bw.write(AppDataUploader.getNextLine() + "\n");
            //Appending dailyGoals
            informator.printInfoAboutDailyGoalsInput();
            appendDailyGoalsToFileInTrainingsDetails(length, bw);
            //Appending creationDate
            bw.write(String.valueOf(new Date()));
            bw.write("END");

            bw.close();
        }

        private static void appendDailyGoalsToFileInTrainingsDetails(Integer length, BufferedWriter bw) throws IOException{
            for (int i = 0; i < length; i++){
                bw.write(i+1 + ": " +AppDataUploader.getNextLine() + "\n");
            }
            bw.write("Daily goals ended\n");
        }


        private Integer getLength(InformationDisplayer informator){
            while (true){
                try {
                    return Integer.parseInt(AppDataUploader.getNextLine());
                } catch (NumberFormatException exc){
                    informator.printBadIntegerFormatInformation();
                }
            }
        }


    @Override
    public  void addTrainingData(String name){
        try{
            addLineToFile("savedTrainings.txt", name);
        } catch (IOException exc){
            Logger logger = Logger.getLogger(this.getClass().getSimpleName());
            logger.info(exc.getMessage());
        }
    }

    @Override
    public  void addTrainingDetails(String nameOfTraining, InformationDisplayer informator){
        try {
            informator.printRequiredLengthInfo();
            Integer length = getLength(informator);
            addFileToTrainingsDetails(nameOfTraining, length, informator);
        } catch (IOException exc){
            exc.printStackTrace();
        }
    }
}
