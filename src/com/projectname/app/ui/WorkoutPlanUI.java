package com.projectname.app.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.awt.*;

public class WorkoutPlanUI extends JScrollPane
{
    //Constants
    public static final Color BACKGROUND_COLOR = new Color(94,94,104);

    //Instance Variables
    private static JPanel ROOT_PANE;

    private JScrollBar SCROLL_BAR;
    protected WorkoutPlanUI()
    {
        init();
        initComponents();
    }

    private void init()
    {
        //Basic Setup
        setUI(new BasicScrollPaneUI());
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
    }

    private void initComponents()
    {
        //Init RootPane
        ROOT_PANE = new JPanel();
        ROOT_PANE.setBackground(BACKGROUND_COLOR);
        setViewportView(ROOT_PANE);


        ROOT_PANE.add(AppUIManager.createTestLabel("My Workout Plan Rocks", 50));
    }
}
