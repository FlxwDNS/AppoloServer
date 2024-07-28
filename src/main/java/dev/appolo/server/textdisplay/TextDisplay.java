package dev.appolo.server.textdisplay;

import dev.appolo.server.textdisplay.impl.TextDisplayData;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Entity;
import net.minestom.server.entity.EntityType;
import net.minestom.server.entity.metadata.display.TextDisplayMeta;
import net.minestom.server.instance.Instance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class TextDisplay {
    private final List<Entity> entities;

    /**
     * @param instance The instance where the text display will be displayed.
     * @param pos The position where the text display will be displayed.
     * @param lines The lines of the text display.
     */
    public TextDisplay(Instance instance, Pos pos, TextLineBuilder... lines) {
        this.entities = new ArrayList<>();

        for (TextLineBuilder line : Arrays.stream(lines).toList().reversed()) {
            var entity = new Entity(EntityType.TEXT_DISPLAY);
            var meta = (TextDisplayMeta) entity.getEntityMeta();

            entity.setNoGravity(true);
            meta.setBackgroundColor(line.get(TextDisplayData.BACKGROUND));

            meta.setScale(line.get(TextDisplayData.SCALE));
            meta.setText(line.get(TextDisplayData.CONTENT));
            meta.setBillboardRenderConstraints(line.get(TextDisplayData.BILLBOARD));

            entity.setInstance(instance, pos).thenAccept(unused -> entity.teleport(pos));

            this.entities.add(entity);
        }
    }

    /**
     * Removes all the entities from the instance.
     */
    public void remove() {
        for (Entity entity : this.entities) entity.remove();
        this.entities.clear();
    }
}
