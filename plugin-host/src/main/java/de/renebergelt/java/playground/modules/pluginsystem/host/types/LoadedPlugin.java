package de.renebergelt.java.playground.modules.pluginsystem.host.types;

import de.renebergelt.java.playground.modules.pluginsystem.core.Plugin;
import de.renebergelt.java.playground.modules.pluginsystem.core.PluginInfo;

public class LoadedPlugin {

    private PluginInfo info;
    private Plugin instance;

    public PluginInfo getInfo() {
        return info;
    }

    public Plugin getInstance() {
        return instance;
    }

    public LoadedPlugin(PluginInfo info, Plugin instance) {
        this.info = info;
        this.instance = instance;
    }

}
