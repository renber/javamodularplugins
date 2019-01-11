package de.renebergelt.java.playground.modules.pluginsystem.plugins.samplepluginone;

import de.renebergelt.java.playground.modules.pluginsystem.core.Plugin;
import de.renebergelt.java.playground.modules.pluginsystem.core.PluginInfo;

public class PluginOneInfo extends PluginInfo {

    public PluginOneInfo() {
        super(PluginOne.NAME, PluginOne.VERSION, PluginOne.AUTHOR, PluginOne.class);
    }
}
