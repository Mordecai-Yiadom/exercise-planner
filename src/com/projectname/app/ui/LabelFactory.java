package com.projectname.app.ui;

import javax.swing.*;
import java.awt.*;

/*
 * Contains method(s) to create a JLabel for any UI usage
 * JLabels can be created using a Type or can be created by passing attributes into it
 */
public class LabelFactory
{
    protected JLabel createIconLabel(SpecificType type)
    {
        return null;
    }

    protected JLabel createIconLabel(GenericType type)
    {
        return null;
    }

    protected enum SpecificType implements LabelType
    {
        ;
        private ImageIcon icon;
        private String iconName;
        private Color backgroundColor, foregroundColor;
        private int width, height;

        SpecificType(String iconName, Color backgroundColor, Color foregroundColor, int width, int height)
        {
            this.iconName = iconName;
            icon = new ImageIcon(iconName);

            this.backgroundColor = backgroundColor;
            this.foregroundColor = foregroundColor;
            this.width = width;
            this.height = height;
        }
    }

    protected enum GenericType implements LabelType
    {
        WORKOUT_PLAN_ENTRY_DURATION_LABEL(Color.RED, Color.WHITE, 30,30);

        private Color backgroundColor, foregroundColor;
        private int width, height;

        GenericType(Color backgroundColor, Color foregroundColor, int width, int height)
        {
            this.width = width;
            this.height = height;
            this.backgroundColor = backgroundColor;
            this.foregroundColor = foregroundColor;
        }
    }

}
