package com.projectname.app.ui;

import javax.swing.*;
import java.awt.*;

public class CreateExerciseWindow extends JDialog
{
    protected CreateExerciseWindow()
    {
        super(AppUIManager.window(), "Create New Exercise");

        init();
        initComponents();
    }

    private void init()
    {
        setBackground(Toolbar.BACKGROUND_COLOR);
    }

    private void initComponents()
    {

    }

}
