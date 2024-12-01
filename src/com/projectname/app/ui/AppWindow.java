package com.projectname.app.ui;

import javax.swing.*;
import java.awt.*;

public class AppWindow extends JFrame
{
    private Toolbar TOOLBAR;
    protected static final Rectangle MENU_VIEW_PORT = new Rectangle(Toolbar.WIDTH + 1, AppUIManager.DECORATION_OFFSET,
            AppUIManager.SCREEN_WIDTH - (Toolbar.WIDTH) - 17, AppUIManager.SCREEN_HEIGHT);

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
        setSize(AppUIManager.SCREEN_WIDTH, AppUIManager.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("UNTITLED PROJECT");

        //setResizable(false);
    }

    private void initComponents()
    {
        //Initialize ContentPane
        getContentPane().setBackground(new Color(34,34,34));
        getContentPane().add(TOOLBAR);

        displayMenu(new HomeMenu());
    }

    protected void displayMenu(AppMenu menu)
    {
        Container appMenu = (Container) menu;
        appMenu.setBounds(MENU_VIEW_PORT);
        getContentPane().add(appMenu);
    }
}
