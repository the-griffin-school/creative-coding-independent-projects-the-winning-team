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
        int n = Math.abs(r.nextInt() % 12 );
        for (int i = 0; i < n + 3; i++) {
            fakeData.add(new ServerInfo(r, "FakeServer" + i));
        }
        processing.background(0, 119, 255, 50);
    }


    public void update(int seconds) {

    }

    public void draw() {

        processing.fill(255);
        processing.rectMode(processing.CENTER);
        processing.rect(processing.width / 2, processing.height / 2, 600, 400, 10);
        processing.textAlign(processing.CENTER, processing.BOTTOM);
        processing.fill(0);
        for(int i = 0; i < fakeData.size(); i++) {

            processing.text(fakeData.get(i).getName(),processing.width / 2, (processing.height/2)+15*(i+1));
        }

        //ServerInfo selected = fakeData.get(0);
        //processing.setGui(new LoginScreen(processing, selected.getAddress(), selected.getPort()));
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
