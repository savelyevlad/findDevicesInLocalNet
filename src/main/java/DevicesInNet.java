import lombok.Getter;

import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;

public class DevicesInNet {

    @Getter
    private static ArrayList<Device> devices;

    public static ArrayList<Device> findDevices() throws UnknownHostException, SocketException {

        devices = new ArrayList<Device>();

        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements())
        {
            NetworkInterface networkInterface = interfaces.nextElement();
            for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses())
            {
                System.out.println(interfaceAddress.getAddress());
                InetAddress broadcast = interfaceAddress.getBroadcast();
                if (broadcast == null)
                    continue;

                System.out.println(broadcast);
            }
        }

        return devices;
    }

}
