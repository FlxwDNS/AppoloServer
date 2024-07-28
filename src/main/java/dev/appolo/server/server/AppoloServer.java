package dev.appolo.server.server;

import dev.appolo.server.blockhandler.HangingSignBlockHandler;
import net.minestom.server.MinecraftServer;
import net.minestom.server.extras.MojangAuth;
import net.minestom.server.extras.velocity.VelocityProxy;
import net.minestom.server.utils.NamespaceID;
import org.apache.log4j.*;

public final class AppoloServer {
    private final Logger logger = LogManager.getLogger(AppoloServer.class);

    public AppoloServer() {
        var console = new ConsoleAppender();

        //global
        var PATTERN = "[%d{HH:mm:ss}] [%p]: %m%n";
        console.setLayout(new PatternLayout(PATTERN));
        console.setThreshold(Level.INFO);
        console.activateOptions();
        Logger.getRootLogger().addAppender(console);

        this.logger.info("AppoloServer was initialized.");
    }

    public Logger logger() {
        return this.logger;
    }

    public MinecraftServer run(String velocitySecret) {
        this.logger.info("Initializing server...");
        var minecraftServer = MinecraftServer.init();

        if (velocitySecret != null) {
            this.logger.info("Setting up VelocityProxy...");
            VelocityProxy.enable(velocitySecret);
        } else {
            this.logger.info("Initializing MojangAuth...");
            MojangAuth.init();
        }
        minecraftServer.start("127.0.0.1", 25565);

        this.logger.info("Initializing BlockHandler...");
        MinecraftServer.getBlockManager().registerHandler(NamespaceID.from("minecraft:hanging_sign"), HangingSignBlockHandler::new);

        this.logger.info("Initializing Main...");
        return minecraftServer;
    }
}
