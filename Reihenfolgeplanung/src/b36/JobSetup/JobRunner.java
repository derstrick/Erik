package b36.JobSetup;

import b36.gui.mainframe.MainView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Erik
 * Date: 10.12.13
 * Time: 21:26
 * To change this template use File | Settings | File Templates.
 */
public class JobRunner {

    int numberOfJobs;
    int numberOfLanes;


    List<Lane> laneList;

    public JobRunner(int numberOfLanes, int numberOfJobs) {
        this.numberOfJobs = numberOfJobs;
        this.numberOfLanes = numberOfLanes;
        setupJob();
        MainView.getInstance().updateGfXPane(numberOfLanes);
    }

    private void setupJob(){
        System.out.println("Job start!");
        System.out.println("Jobs: " + numberOfJobs);
        System.out.println("Lanes: " + numberOfLanes);
        System.out.println();
    }
}
