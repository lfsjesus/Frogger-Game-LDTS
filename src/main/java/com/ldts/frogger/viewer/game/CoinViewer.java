package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Coin;

public class CoinViewer implements ElementViewer<Coin> {

    @Override
    public void draw(Coin coin, GUI gui) {
        gui.drawText(coin.getPosition(),"p", "#daac34", coin.getBackGroundColor());
    }
}
