package com.ldts.frogger.states;

import com.ldts.frogger.controller.Controller;
import com.ldts.frogger.controller.menu.MenuController;
import com.ldts.frogger.model.menu.Menu;
import com.ldts.frogger.viewer.Viewer;
import com.ldts.frogger.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
