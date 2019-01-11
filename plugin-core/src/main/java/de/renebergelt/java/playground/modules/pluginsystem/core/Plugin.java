package de.renebergelt.java.playground.modules.pluginsystem.core;

/**
 * Represents a plugin which is contained in a module
 * and can be loaded by a plugin host
 */
public interface Plugin {

    /**
     * The display text of this plugin
     */
    String getTitle();

    /**
     * Run this plugin
     */
    void execute();
}
