package Trainings;

import HelpClasses.InformationDisplayer;
import HelpClasses.StringInformator;

import java.util.HashMap;


public class ConcreteTrainingInstance implements TrainingInstance {
    private Integer length;
    private String progress;
    private String name;
    private String dateOfCreation;
    private HashMap<Integer, String> dailyGoals;
    private InformationDisplayer informationDisplayer;

    @Override
    public void showTrainingProgress(){
        informationDisplayer.printTrainingProgress(name, progress);
    }

    public String getProgress() {
        return progress;
    }

    public String getName() {
        return name;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public HashMap<Integer, String> getDailyGoals() {
        return dailyGoals;
    }

    @Override
    public void showTrainingLength(){
        informationDisplayer.printTrainingLength(name, length);
    }

    @Override
    public void showTrainingDay(int numberOfDay) {
        informationDisplayer.printTrainingDay(numberOfDay, dailyGoals.get(numberOfDay));
    }

    @Override
    public void showCreationDate(){
        informationDisplayer.printCreationDate(dateOfCreation);
    }

    @Override
    public void showTrainingInDetails() {
        informationDisplayer.printTrainingInDetails(this);
    }

    @Override
    public Integer getTrainingLength() {
        return this.length;
    }

    private ConcreteTrainingInstance(){

    }

    public static Builder builder(){
        return new Builder();
    }


    public static final class Builder{
        private Integer length;
        private String progress;
        private String name;
        private String dateOfCreation;
        private HashMap<Integer, String> dailyGoals;
        private InformationDisplayer informationDisplayer;

        public Builder length(Integer length){
            this.length = length;
            return this;
        }

        public Builder progress(String progress){
            this.progress = progress;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder dateOfCreation(String dateOfCreation){
            this.dateOfCreation = dateOfCreation;
            return this;
        }
        public Builder informationDisplayer(InformationDisplayer informationDisplayer){
            this.informationDisplayer = informationDisplayer;
            return this;
        }

        public Builder dailyGoals(HashMap<Integer, String> dailyGoals) {
            this.dailyGoals = dailyGoals;
            return this;
        }

        public ConcreteTrainingInstance build(){
            //ADD SOME MOTIVATION TEXTS
            ConcreteTrainingInstance result = new ConcreteTrainingInstance();
            informationDisplayer = this.informationDisplayer;
            result.length = this.length;
            result.progress = this.progress;
            result.name = this.name;
            result.dateOfCreation = this.dateOfCreation;
            result.dailyGoals = this.dailyGoals;
            return result;
        }

    }
}
