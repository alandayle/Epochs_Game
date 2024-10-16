package com.EpochsGroup.EpochsGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Intro implements Screen {
    Texture logo, headphones, mainMenu, welcome;
    Music music;
    EpochsGame epochsGame;
    SpriteBatch batch;
    Camera camera;
    Viewport viewport;
    final float WORLD_HEIGHT = 8;
    final float WORLD_WIDTH = 4.5F;

    float colorValue = 1;
    float timer;
    GameScreen gameScreen;
    public Intro(EpochsGame epochsGame) {
        this.epochsGame = epochsGame;
        batch = new SpriteBatch();
        music = Gdx.audio.newMusic(Gdx.files.internal("background.mp3"));
        music.isLooping();
        logo = new Texture("logo.png");
        headphones = new Texture("headphones.png");
        camera = new OrthographicCamera();
        camera.position.set(WORLD_WIDTH / 2, WORLD_HEIGHT / 2 , 0);
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        mainMenu = new Texture("mainMenu.gif");
        welcome = new Texture("welcome3.png");
        gameScreen = new GameScreen(epochsGame);
    }

    @Override
    public void show() {
        music.play();
    }

    @Override
    public void render(float delta) {
        input(delta);
        logic(delta);
        draw(delta);
    }

    public void input(float delta) {

    }

    public void logic(float delta) {
        if (timer > 4) {
            if (Gdx.input.isTouched()) {
                System.out.println("ha");
                epochsGame.setScreen(gameScreen);
                dispose();
            }
        }
     }

    public void draw(float delta) {
        ScreenUtils.clear(Color.BLACK);
        camera.update();
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        timer+= delta;
        if (timer > 1 && timer < 2) {
            if (colorValue > 0F) {
                colorValue -= 0.01F;
            }
        }
        if (timer > 2 && timer < 3) {
            if (colorValue < 1F) {
                colorValue += 0.02F;
                System.out.println("ano");
            }
        }
        if (timer > 6 && timer < 8) {
            if (colorValue > 0F) {
                colorValue -= 0.01F;
            }
        }
        if (timer > 8 && timer < 10) {
            if (colorValue < 1F) {
                colorValue += 0.02F;
            }
        }
        batch.setColor(colorValue,colorValue, colorValue, 1);
        if (timer < 2) {
            batch.draw(logo, 0, 0, WORLD_WIDTH, WORLD_HEIGHT);
        } else if (timer < 8){
            batch.draw(headphones, 0, 0, WORLD_WIDTH, WORLD_HEIGHT);
        } else {
            batch.draw(mainMenu, 0, 0, WORLD_WIDTH, WORLD_HEIGHT);
        }

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
        logo.dispose();
        headphones.dispose();
        mainMenu.dispose();
        welcome.dispose();
        System.out.println("nice");
    }
}
