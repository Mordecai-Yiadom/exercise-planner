package com.projectname.app.ui;

import javax.swing.*;
import java.awt.*;

public class AppUIManager
{
    public static final String FONT = "Segoe UI";

    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;

    public static final int DECORATION_OFFSET = 0;

    public static final Color MENU_BACKGROUND_COLOR = new Color(54, 54, 64);
    public static final String IMAGE_PATH = "C:\\Workspace\\School\\Data Structures Final Project\\assets\\images\\ui\\";

    //DUE TO REMOVE WHEN UI IS COMPLETE
    protected static JLabel createTestLabel(String text, int size)
    {
        JLabel label = new JLabel(text);
        label.setFont(new Font(FONT, Font.BOLD, size));
        label.setForeground(Color.WHITE);
        label.setBackground(Color.RED);
        return label;
    }
}
