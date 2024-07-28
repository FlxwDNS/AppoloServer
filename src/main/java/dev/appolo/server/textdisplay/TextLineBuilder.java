package dev.appolo.server.textdisplay;

import dev.appolo.server.attribute.AppoloAttribute;

import java.util.HashMap;
import java.util.Map;

public final class TextLineBuilder {
    private final Map<AppoloAttribute<?>, Object> attributes;

    public TextLineBuilder() {
        this.attributes = new HashMap<>();
    }

    /**
        * Create a new TextLineBuilder.
        * @return a new TextLineBuilder
     **/
    public static TextLineBuilder get() {
        return new TextLineBuilder();
    }

    /**
        * Set an attribute value.
        * @param attribute the attribute to set (use: TextDisplayData)
        * @param value the value to set
        * @param <T> the attribute type
        * @return this builder
     **/
    public <T> TextLineBuilder set(AppoloAttribute<T> attribute, T value) {
        attributes.put(attribute, value);
        return this;
    }

    /**
        * Get an attribute value.
        * @param attribute the attribute to get (use: TextDisplayData)
        * @param <T> the attribute type
        * @return the attribute value
     **/
    public <T> T get(AppoloAttribute<T> attribute) {
        return (T) attributes.get(attribute);
    }

    /**
     * Get all attributes.
     * @return a map of all attributes
     */
    public Map<AppoloAttribute<?>, Object> attributes() {
        return attributes;
    }
}
