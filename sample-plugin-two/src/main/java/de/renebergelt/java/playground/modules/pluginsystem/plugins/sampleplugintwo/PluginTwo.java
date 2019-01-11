package de.renebergelt.java.playground.modules.pluginsystem.plugins.sampleplugintwo;

import de.renebergelt.java.playground.modules.pluginsystem.core.Plugin;

public class PluginTwo implements Plugin {

    public final static String NAME = "Plugin Two";
    public final static String AUTHOR = "Plugin Two";
    public final static String VERSION = "1.0";

    @Override
    public String getTitle() {
        return "Second";
    }

    @Override
    public void execute() {

    }
}
