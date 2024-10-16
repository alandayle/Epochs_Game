package com.EpochsGroup.EpochsGame;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {
    EpochsGame epochsGame;
    Viewport viewport;
    Camera camera;
    SpriteBatch batch;
    Texture welcome;

    public GameScreen(EpochsGame epochsGame) {
        this.epochsGame = epochsGame;
        camera = new OrthographicCamera();
        camera.position.set(epochsGame.WORLD_WIDTH / 2, epochsGame.WORLD_HEIGHT / 2, 0);
        viewport = new FitViewport(epochsGame.WORLD_WIDTH, epochsGame.WORLD_HEIGHT, camera);
        batch = new SpriteBatch();
        welcome = new Texture("welcome3.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        camera.update();
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(welcome,0,0, epochsGame.WORLD_WIDTH, epochsGame.WORLD_HEIGHT);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
