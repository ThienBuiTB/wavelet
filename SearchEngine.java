import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

public class SearchEngine {
    int num = 0;
    ArrayList<String> string = new ArrayList<>(null);
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Thien'sss Number: %d", num);
        } else if (url.getPath().equals("/increment")) {
            num += 1;
            return String.format("Number incremented!");
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                System.out.println(parameters[0]+"hi");
                if (parameters[0].equals("count")) {
                    num += Integer.parseInt(parameters[1]);
                    return String.format("Number increased by %s! It's now %d", parameters[0], num);
                } else if(parameters[0].equals("message")){
                    
                    string.add(parameters[1]);
                    for(int i = 0; i<string.size();i++){
                        System.out.println(string.get(i)+"\n");
                    }
                }
            }
            return "404 Not Found!";
        } 
    }
}

class NumberServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
