package de.renebergelt.java.playground.modules.pluginsystem.core;

import java.util.Objects;

/**
 * Holds information about a plugin which is
 * contained in a module
 */
public abstract class PluginInfo {

    String name;
    String author;
    String version;
    Class<? extends Plugin> pluginClass;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getVersion() {
        return version;
    }

    public Class<? extends Plugin> getPluginClass() {
        return pluginClass;
    }

    public PluginInfo(String name, String version, String author, Class<? extends Plugin> pluginClass) {
        this.name = name;
        this.version = version;
        this.author = author;
        this.pluginClass = pluginClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PluginInfo)) return false;
        PluginInfo that = (PluginInfo) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(author, that.author) &&
                Objects.equals(version, that.version) &&
                Objects.equals(pluginClass, that.pluginClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, version, pluginClass);
    }
}
