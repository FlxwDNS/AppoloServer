package dev.appolo.server.attribute;

public final class AppoloAttribute<T> {
    private final T defaultValue;

    public AppoloAttribute(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    public T defaultValue() {
        return defaultValue;
    }
}
