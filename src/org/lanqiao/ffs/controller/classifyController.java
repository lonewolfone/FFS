package org.lanqiao.ffs.controller;

import org.lanqiao.ffs.views.AbstractClassifyFram;

public class classifyController extends AbstractClassifyFram {
    @Override
    public void replenish() {
        this.setVisible(false);
        new mainController();
    }

    @Override
    public void sale() {
        this.setVisible(false);
        new mainController();
    }

    @Override
    public void store() {
        this.setVisible(false);
        new mainController();
    }
}
