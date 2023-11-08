package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

// класс препятствия - 4 пары трубы
public class Obstacles {
    class WallPair { // класс для отображения одной пары трубы
        Vector2 position;
        float speed;
        int offset; //смещение труб
        Rectangle emptySpace; //пустое расстояние между парой труб (если птица касается трубы-проигрышь)

        public WallPair(Vector2 pos) {
            position = pos;
            speed = 2;
            offset = new Random().nextInt(250);
            emptySpace = new Rectangle(position.x, position.y - offset + 302, 52, betweenDistance);
        }

        public void update() {
            position.x -= speed;

            if (position.x < -53) { //меньше ширины трубы
                position.x = 800;
                offset = new Random().nextInt(250);
            }
            emptySpace.x = position.x;
        }
    }

    static WallPair[] obs;
    Texture txt;
    int betweenDistance; // расстояние между трубами

    public Obstacles() {
        txt = new Texture("wall.png");
        obs = new WallPair[4];
        betweenDistance = 250;
        int startPosX = 400;//начальное положение каждой трубы на поле
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(startPosX, 0));
            startPosX += 220;
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < obs.length; i++) { //рисуем нижние трубы
            batch.draw(txt, obs[i].position.x, obs[i].position.y - obs[i].offset);
            batch.draw(txt, obs[i].position.x, obs[i].position.y + betweenDistance + txt.getHeight() - obs[i].offset);
        }
    }

    public void update() {
        for (int i = 0; i < obs.length; i++) { //метод апдейт для каждой трубы
            obs[i].update();

        }

    }

    public void recreate() {
        int startPosX = 400;//начальное положение каждой трубы на поле
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(startPosX, 0));
            startPosX += 220;
        }
    }
}

