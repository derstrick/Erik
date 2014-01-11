package b36.JobSetup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Erik
 * Date: 10.12.13
 * Time: 21:25
 * To change this template use File | Settings | File Templates.
 */
public class Lane {
    RandomJobLength randomJobLength = new RandomJobLength();
    int laneNumber = 1;
    List<Job> jobList = new ArrayList<Job>();

    public Lane(int numberJobs) {
        for (int i = 0; i < numberJobs; i++){

            jobList.add(new Job(i, randomJobLength.getRandomJobSize()));
        }
    }

    public int getLaneNumber() {
        return laneNumber;
    }

    public void setLaneNumber(int numberLanes) {
        this.laneNumber = numberLanes;
    }
}
