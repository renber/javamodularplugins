package de.renebergelt.java.playground.modules.pluginsystem.plugins.sampleplugintwo;

import de.renebergelt.java.playground.modules.pluginsystem.core.Plugin;
import de.renebergelt.java.playground.modules.pluginsystem.core.PluginInfo;

public class PluginTwoInfo extends PluginInfo {

    public PluginTwoInfo() {
        super(PluginTwo.NAME, PluginTwo.VERSION, PluginTwo.AUTHOR, PluginTwo.class);
    }
}
