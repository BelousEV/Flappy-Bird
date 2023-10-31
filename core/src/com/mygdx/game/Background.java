package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {

    class BGPicture{
        private Texture tx; //картинка фона
        private Vector2 pos; //создание позиции вектор 2 координаты


        public BGPicture(Vector2 pos){ // данный конструктор инициализирует координаты
            tx = new Texture("back.png");
            this.pos = pos;
        }
    }
    private int speed; //скорость отрисовки
    private BGPicture[] backs;

    public Background (){

        speed = 4; //на 4 точки во время перерисовки
        backs = new BGPicture[2];
        backs[0] = new BGPicture(new Vector2(0,0));
        backs[1] = new BGPicture(new Vector2(800,0));
    }

    public void render (SpriteBatch batch){ //отрисовка, параметр с помощью чего
        for (int i = 0; i < backs.length; i++) {
            batch.draw(backs[i].tx, backs[i].pos.x, backs[i].pos.y);
            
        }
    }

    public void update(){
        for (int i = 0; i < backs.length; i++) {
            backs[i].pos.x -= speed;
                    }

        if (backs[0].pos.x < -800){ //делаем фон подвижным непрерывно
            backs[0].pos.x = 0;
            backs[1].pos.x = 800;
        }
    }
}
