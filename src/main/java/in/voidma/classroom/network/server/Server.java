package in.voidma.classroom.network.server;

import in.voidma.classroom.network.server.network.NetworkSystem;
import io.netty.channel.ChannelFuture;

public class Server implements Runnable {

    private int port;

    private int tickNumber = 0;
    private long currentStartTime = 0L;
    private long lastStartTime = 0L;
    private long lastWarningTime = 0L;
    private long timeSinceLastTick = 0L;

    private boolean running = true;

    private NetworkSystem networkSystem;

    private ChannelFuture channel;

    private Server(int port) {
        this.port = port;
        this.networkSystem = new NetworkSystem(this);
        this.networkSystem.addLanEndpoint(port);
    }

    public static void main (String[] args) {
        Server server = new Server(8118);
        server.run();
    }

    public static long getCurrentTimeMillis() {

        return System.currentTimeMillis();
    }

    public void tick() {

        this.networkSystem.networkTick();
    }

    public void run() {

        try {
            while (running) {

                currentStartTime = getCurrentTimeMillis();
                long timeChange = currentStartTime - lastStartTime;

                if (timeChange > 2000L && timeSinceLastWarning() >= 15000L) {
                    // Skip some ticks

                    timeChange = 2000L;
                    this.lastWarningTime = this.currentStartTime;
                }

                if (timeChange < 0L) {
                    timeChange = 0; //Ensure time always runs forwards.
                }

                timeSinceLastTick += timeChange;
                lastStartTime = currentStartTime;

                while (timeSinceLastTick > 50) {
                    timeSinceLastTick -= 50L;
                    this.tick();
                }

                Thread.sleep(Math.max(1L, 50L - timeSinceLastTick));
                this.running = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.running = false;
        }
    }

    public long timeSinceLastWarning() {

        return this.currentStartTime - lastWarningTime;
    }
}
