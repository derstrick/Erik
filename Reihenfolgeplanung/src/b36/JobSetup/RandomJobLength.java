package b36.JobSetup;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Erik
 * Date: 10.01.14
 * Time: 19:36
 * To change this template use File | Settings | File Templates.
 */
public class RandomJobLength{

    public int getRandomJobSize(){
        int jobLength = -1;
        Random n = new Random();
        jobLength = n.nextInt(20);
        return jobLength;
    }

}
