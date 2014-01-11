package b36.JobSetup;

/**
 * Created with IntelliJ IDEA.
 * User: Erik
 * Date: 10.12.13
 * Time: 21:25
 * To change this template use File | Settings | File Templates.
 */
public class Job {

    int jobNumber;
    int jobLength;

    public Job(int jobNumber, int jobLength){
        this.jobNumber = jobNumber;
        this.jobLength = jobLength;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int numberJobs) {
        this.jobNumber = numberJobs;
    }

    public int getJobLength() {
        return jobLength;
    }

    public void setJobLength(int jobLength) {
        this.jobLength = jobLength;
    }
}

