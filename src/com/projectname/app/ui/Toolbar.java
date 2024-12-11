package com.projectname.app.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Flow;

public class Toolbar extends JPanel
{
    //Toolbar Constants
    public static final int WIDTH = 90;
    private static final int V_GAP = 40;
    public static final Color BACKGROUND_COLOR = new Color(24,24,24);


    //Instance Variables
    private FlowLayout layoutManager;
    private JButton HOME_BUTTON, EDIT_SCHEDULE_BUTTON, SETTINGS_BUTTON, USER_PROFILE_BUTTON;

    protected Toolbar()
    {
        init();
        initComponents();
    }

    private void init()
    {
        layoutManager = (FlowLayout) getLayout();
        setBackground(BACKGROUND_COLOR);
        setSize(WIDTH, AppUIManager.SCREEN_HEIGHT);
        layoutManager.setVgap(V_GAP);
    }

    private void initComponents()
    {
        ButtonFactory factory = new ButtonFactory();

        HOME_BUTTON = factory.createIconButton(ButtonFactory.GenericType.TOOLBAR_BUTTON,
                "house-chimney.png", null);
        add(HOME_BUTTON);

        EDIT_SCHEDULE_BUTTON = factory.createIconButton(ButtonFactory.GenericType.TOOLBAR_BUTTON,
                "calendar-pen.png", null);
        add(EDIT_SCHEDULE_BUTTON);

        USER_PROFILE_BUTTON = factory.createIconButton(ButtonFactory.GenericType.TOOLBAR_BUTTON,
                "user.png", null);
        add(USER_PROFILE_BUTTON);

        SETTINGS_BUTTON = factory.createIconButton(ButtonFactory.GenericType.TOOLBAR_BUTTON,
                "settings.png", null);
        add(SETTINGS_BUTTON);
    }

}
