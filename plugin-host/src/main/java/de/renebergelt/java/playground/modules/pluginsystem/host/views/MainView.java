package de.renebergelt.java.playground.modules.pluginsystem.host.views;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    public MainView() {
        initComponents(getContentPane());
        pack();
    }

    private void initComponents(Container contentPane) {
        contentPane.setLayout(new MigLayout());
    }
}
