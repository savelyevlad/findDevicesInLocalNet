import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dispatcher {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {

            command = scanner.nextLine();

            if(command.equals("find")) {
                find();
            }
            else if(command.equals("out")) {
                out();
            }
            else if(command.equals("exit")) {
                return;
            }
        }
    }

    private static void out() {
        ArrayList<Device> devices =  DevicesInNet.getDevices();
        outputDevices(devices);
    }

    private static void find() throws Exception {
        ArrayList<Device> devices = DevicesInNet.findDevices();
        outputDevices(devices);
    }

    private static void outputDevices(ArrayList<Device> devices) {
        for (Device device : devices) {
            System.out.println(device);
        }
    }
}
