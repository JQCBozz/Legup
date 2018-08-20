package edu.rpi.legup.ui.boardview;

import javafx.geometry.Point2D;

import java.util.ArrayList;

public class ElementSelection
{
    private ArrayList<ElementView> selection;
    private ElementView hover;
    private Point2D mousePoint;

    public ElementSelection()
    {
        this.selection = new ArrayList<>();
        this.hover = null;
        this.mousePoint = null;
    }

    public ArrayList<ElementView> getSelection()
    {
        return selection;
    }

    public ElementView getFirstSelection()
    {
        return selection.size() == 0 ? null : selection.get(0);
    }

    public void toggleSelection(ElementView elementView)
    {
        if(selection.contains(elementView))
        {
            selection.remove(elementView);
            elementView.setSelected(false);
        }
        else
        {
            selection.add(elementView);
            elementView.setSelected(true);
        }
    }

    public void newSelection(ElementView elementView)
    {
        clearSelection();
        selection.add(elementView);
        elementView.setSelected(true);
    }

    public void clearSelection()
    {
        for(ElementView elementView : selection)
        {
            elementView.setSelected(false);
        }
        selection.clear();
    }

    public Point2D getMousePoint()
    {
        return mousePoint;
    }

    public void setMousePoint(Point2D point)
    {
        this.mousePoint = point;
    }
}