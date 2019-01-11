module de.renebergelt.java.playground.modules.pluginsystem.plugins.sampleplugintwo {

    requires de.renebergelt.java.playground.modules.pluginsystem.core;

    exports de.renebergelt.java.playground.modules.pluginsystem.plugins.sampleplugintwo;

    // this module contains one Plugin: PluginTwo
    provides de.renebergelt.java.playground.modules.pluginsystem.core.PluginInfo
             with de.renebergelt.java.playground.modules.pluginsystem.plugins.sampleplugintwo.PluginTwoInfo;
}