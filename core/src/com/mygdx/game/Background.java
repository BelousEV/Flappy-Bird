package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {
    private Texture tx; //картинка фона
    private Vector2 pos; //создание позиции вектор 2 координаты
    private int speed; //скорость отрисовки


    public Background (){
        tx = new Texture("back.png");
        pos = new Vector2(0,0);
        speed = 4; //на 4 точки во время перерисовки
    }

    public void render (SpriteBatch batch){ //отрисовка, параметр с помощью чего
        batch.draw (tx, pos.x, pos.y);
    }

    public void update(){
        pos.x -= speed;
    }
}
