import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by schaud3 on 4/24/17.
 */
public class Start {
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        List<Action> actions = new ArrayList<Action>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long startTime = System.currentTimeMillis();
        for (int i=0;i<10;i++){
            Action action = new Action(i);
            //System.out.println(action.restGetCall());
            actions.add(action);
        }
        List<Future<String>> results = executorService.invokeAll(actions);
        executorService.shutdown();
        for(Future<String> future: results){
            System.out.println(future.get());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time spent = "+ (endTime-startTime)+"ms");

    }
}
