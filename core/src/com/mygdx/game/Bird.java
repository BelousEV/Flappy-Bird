package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    Texture img;
    Vector2 position;
    float vy;
    float gravity;

    public Bird(){
        img = new Texture ("bird1.png");
        position = new Vector2(100,380);
        vy = 0;
        gravity = - 0.7f;
    }

    public void render (SpriteBatch batch){ // именно с помощью SpriteBatch отрисовываем игровые объекты
        batch.draw(img, position.x, position.y);
    }

    public void update(){ //вся математическая логика
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){ //при нажатии пробела поднимаем птичку на 10
            vy = 10;
        }
        vy += gravity; //быстрее вниз (гравитация)
        position.y += vy; //птичка падает
    }

    public void recreate(){
        position = new Vector2(100,380);
        vy = 0;
    }
}
