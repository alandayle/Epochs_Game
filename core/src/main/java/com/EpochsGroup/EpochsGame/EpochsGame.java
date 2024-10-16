package com.EpochsGroup.EpochsGame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class EpochsGame extends Game {
    Intro intro;
    final float WORLD_HEIGHT = 5;
    final float WORLD_WIDTH = 8;

    @Override
    public void create() {
        intro = new Intro(this);
        setScreen(intro);
    }

    @Override
    public void dispose() {
        intro.dispose();
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        intro.resize(width, height);
    }

}
