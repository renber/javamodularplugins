package de.renebergelt.java.playground.modules.pluginsystem.plugins.samplepluginone;

import de.renebergelt.java.playground.modules.pluginsystem.core.Plugin;

public class PluginOne implements Plugin {

    public final static String NAME = "Plugin One";
    public final static String AUTHOR = "Plugin One";
    public final static String VERSION = "1.0";

    @Override
    public String getTitle() {
        return "First";
    }

    @Override
    public void execute() {

    }
}
