package dev.appolo.server.textdisplay.impl;

import dev.appolo.server.attribute.AppoloAttribute;
import net.kyori.adventure.text.Component;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.entity.metadata.display.AbstractDisplayMeta;

public final class TextDisplayData {
    public static AppoloAttribute<Vec> SCALE = new AppoloAttribute<>(new Vec(1, 1, 1));
    public static AppoloAttribute<Component> CONTENT = new AppoloAttribute<>(Component.empty());
    public static AppoloAttribute<Integer> BACKGROUND = new AppoloAttribute<>(0x000000);
    public static AppoloAttribute<AbstractDisplayMeta.BillboardConstraints> BILLBOARD = new AppoloAttribute<>(AbstractDisplayMeta.BillboardConstraints.CENTER);
}
