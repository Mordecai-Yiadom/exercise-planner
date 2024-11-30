package com.projectname.app.ui;

import javax.swing.*;
import java.awt.*;

public class AppWindow extends JFrame
{
    private Toolbar TOOLBAR;
    private static final int g = 1;

    public AppWindow()
    {
        init();
        initComponents();

        setVisible(true);
    }

    private void init()
    {
        TOOLBAR = new Toolbar();

        getContentPane().setLayout(null);
        setSize(AppUIManager.WIDTH, AppUIManager.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);
    }

    private void initComponents()
    {
        //Initialize ContentPane
        getContentPane().setBackground(new Color(34,34,34));

        getContentPane().add(TOOLBAR);
    }

    protected void displayMenu(Container menu){}
}
