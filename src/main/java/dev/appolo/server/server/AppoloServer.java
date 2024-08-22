package dev.appolo.server.server;

import dev.appolo.server.blockhandler.HangingSignBlockHandler;
import net.minestom.server.MinecraftServer;
import net.minestom.server.extras.MojangAuth;
import net.minestom.server.extras.velocity.VelocityProxy;
import net.minestom.server.utils.NamespaceID;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public final class AppoloServer {
    private final Consumer<String> log;

    public AppoloServer(Consumer<String> log) {
        this.log = log;
    }

    /**
     * Run the server
     * Set the VELOCITY_SECRET environment variable to enable VelocityProxy
     * @return
     */
    public MinecraftServer run() {
        this.log.accept("Running AppoloServer with Minestom on Java " + System.getProperty("java.version") + " with " + System.getProperty("os.name") + ".");

        var startup = System.currentTimeMillis();

        this.log.accept("Loading Minestom server...");
        var minecraftServer = MinecraftServer.init();


        var velocitySecret = System.getenv("VELOCITY_SECRET");
        if (velocitySecret != null) {
            this.log.accept("Enviroment: VelocityProxy[Minestom]");
            this.log.accept("- " + VelocityProxy.PLAYER_INFO_CHANNEL);
            VelocityProxy.enable(velocitySecret);
        } else {
            MojangAuth.init();
            this.log.accept("Enviroment: MojangAuth[Minestom]");
            this.log.accept("- " + MojangAuth.AUTH_URL);
        }
        minecraftServer.start("127.0.0.1", 25565);

        MinecraftServer.getBlockManager().registerHandler(NamespaceID.from("minecraft:hanging_sign"), HangingSignBlockHandler::new);

        this.log.accept("AppoloServer is ready. Took " + (System.currentTimeMillis() - startup) + "ms (" + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startup) + "s)");
        return minecraftServer;
    }
}
