import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.Callable;

/**
 * Created by schaud3 on 4/24/17.
 */
public class Action implements Callable<String> {
    private int index;
    Action(int index){
        this.index = index;
    }

    public String call() throws Exception {

        String ans = "executing thread: " +index;
        restGetCall();
        return ans;
    }
    public String restGetCall() throws IOException {
        String url = "http://www.ipsumlorem.com/json";

        HttpClient client = new HttpClient();
        GetMethod get = new GetMethod(url);
        client.executeMethod(get);
        String output = get.getResponseBodyAsString( );
        get.releaseConnection( );
        System.out.println("rest call successfull");
        return output;
    }
}
