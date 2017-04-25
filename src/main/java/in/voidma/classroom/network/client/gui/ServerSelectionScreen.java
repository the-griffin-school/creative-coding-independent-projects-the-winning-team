package in.voidma.classroom.network.client.gui;

import in.voidma.classroom.network.client.Client;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Random;

public class ServerSelectionScreen extends Screen {

    ArrayList<ServerInfo> fakeData;

    public ServerSelectionScreen(Client processing) {
        super(processing);

        fakeData = new ArrayList<ServerInfo>();
        Random r = new Random();
        int n = r.nextInt() % 12;
        for (int i = 0; i < n; i++) {
            fakeData.add(new ServerInfo(r, "FakeServer" + i));
        }
    }

    public void update(int seconds) {

    }

    public void draw() {

    }

    private enum serverLocation {
        LOCAL,
        REMOTE
    }

    private static class ServerInfo {

        private InetAddress address;
        private int port;
        private int playerCount;
        private String name;
        private serverLocation serverLocation;

        public ServerInfo(InetAddress address, int port, int playerCount, String name, ServerSelectionScreen.serverLocation serverLocation) {
            this.address = address;
            this.port = port;
            this.playerCount = playerCount;
            this.name = name;
            this.serverLocation = serverLocation;
        }

        public ServerInfo(Random r, String name) {
            try {
                this.address = InetAddress.getLocalHost();
            } catch (Exception e) {
            }
            this.port = r.nextInt();
            this.playerCount = r.nextInt();
            this.name = name;
            this.serverLocation = ServerSelectionScreen.serverLocation.LOCAL;
        }

        public InetAddress getAddress() {
            return address;
        }

        public int getPort() {
            return port;
        }

        public int getPlayerCount() {
            return playerCount;
        }

        public String getName() {
            return name;
        }

        public ServerSelectionScreen.serverLocation getServerLocation() {
            return serverLocation;
        }
    }
}
