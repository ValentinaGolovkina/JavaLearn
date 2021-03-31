package lvl3_lesson5_multithreading_races;


import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}

