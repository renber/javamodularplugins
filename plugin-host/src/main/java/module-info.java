module de.renebergelt.java.playground.modules.pluginsystem.host {

    requires de.renebergelt.java.playground.modules.pluginsystem.core;

    // swing
    requires  java.desktop;

    // required auto modules
    requires miglayout.core;
    requires miglayout.swing;

    uses de.renebergelt.java.playground.modules.pluginsystem.core.PluginInfo;
}