import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class VendingMachineRunner {
    static final Logger LOG = LoggerFactory.getLogger(VendingMachineRunner.class);

    static CommandDispatcher dispatcher = new CommandDispatcher();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("\n Please Enter Command :");


            try {
                String input = br.readLine();
                dispatcher.handleCompositeCommand(input);
            } catch (IOException ioexception) {
                ioexception.printStackTrace();
            }

        }
    }
}

