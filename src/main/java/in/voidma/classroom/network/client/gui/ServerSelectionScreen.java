package in.voidma.classroom.network.client.gui;

import controlP5.ScrollableList;
import in.voidma.classroom.network.client.Client;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Random;

public class ServerSelectionScreen extends Screen {

    ArrayList<ServerInfo> fakeData;
    ArrayList<String> serverNames;

    public ServerSelectionScreen(Client processing) {
        super(processing);

        fakeData = new ArrayList<ServerInfo>();
        Random r = new Random();
        int n = Math.abs(r.nextInt() % 10 );
        for (int i = 0; i < n + 3; i++) {
            fakeData.add(new ServerInfo(r, "FakeServer" + i));
        }

        serverNames = new ArrayList<String>();
        for (int i = 0; i < fakeData.size(); i++) {
            serverNames.add(fakeData.get(i).getName());
        }

        //processing.color c1 = color(44,62,80);
        processing.background(0, 119, 255, 50);


        for (int i = 0; i < fakeData.size(); i++) {

            //processing.text(fakeData.get(i).getName(), processing.width / 2, (processing.height / 2) + 15 * (i + 1));

           /* cp5.addButton(fakeData.get(i).getName())
                    .setValue(0)
                    .setPosition(processing.width / 2 - 150,((processing.height / 2)-180)+30  * (i + 1))
                    .setSize(300,30)
            ;

*/
        }

        cp5.addScrollableList("servers")
                .setPosition(processing.width / 2 - 150,((processing.height / 2)-180)+30)
                .setSize(300, 300)
                .setBarHeight(30)
                .setItemHeight(30)
                .addItems(serverNames);

}

//    public void Servers(int n) {
//        System.out.println( cp5.get(controlP5.ScrollableList.class, "Servers").getItem(n));
//    }

    public void update(int seconds) {

    }

    public void draw() {

        setGradient(0, 0, processing.width, processing.height, 44, 62, 80, 52, 152, 219, 2);
        processing.fill(255);
        processing.rectMode(processing.CENTER);
        processing.rect(processing.width / 2, processing.height / 2, 600, 400, 10);
        processing.textAlign(processing.CENTER, processing.BOTTOM);
        processing.fill(0);

    }

        //ServerInfo selected = fakeData.get(0);
        //processing.setGui(new LoginScreen(processing, selected.getAddress(), selected.getPort()));
    void setGradient(int x, int y, float w, float h, int c1r, int c1g, int c1b, int c2r, int c2g, int c2b, int axis ) {

        processing.noFill();

         if (axis == 2) {
            for (int i = x; i <= x+w; i++) {
                float inter = processing.map(i, x, x+w, 0, 1);
                int c = processing.lerpColor(processing.color(c1r,c1g,c1b), processing.color(c2r,c2g,c2b), inter);
                processing.stroke(c);
                processing.line(i, y, i, y+h);
            }
        }
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
