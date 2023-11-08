package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background bg;
	Bird bird;
	Obstacles obstacles;
	boolean gameOver;
	Texture restartTexture;
	
	@Override
	public void create () { // выполняется единожды, содержит необходимые расчеты и функции для запуска
		batch = new SpriteBatch();
		bg = new Background();
		bird = new Bird();
		obstacles = new Obstacles();
		gameOver = false;
		restartTexture = new Texture("restart.png");
	}

	@Override
	public void render () { // 60 раз в сек.отрисовывает то, что задаем в методах
		update();
		ScreenUtils.clear(1, 1, 1, 1); // создаем цвет фона
		batch.begin(); //начало отрисовки
		bg.render(batch); //отрисовка картинки 0 и 0 начало
		obstacles.render(batch); //трубы
		if (!gameOver) {
			bird.render(batch); //птичка после бэкграунда, чтобы была поверх него
		}else {
			batch.draw(restartTexture,150, 200);
				}

		batch.end(); // заканчивается отрисовка
	}

	public void update(){ // для просчета математики игры
		bg.update();
		bird.update();
		obstacles.update();
		for (int i = 0; i < Obstacles.obs.length; i++) {
			if (bird.position.x > Obstacles.obs[i].position.x && bird.position.x < Obstacles.obs[i].position.x +53){
				if (!Obstacles.obs[i].emptySpace.contains (bird.position)){
					gameOver= true;
				}
			}
			if (bird.position.y <0 || bird.position.y>600){
				gameOver = true;
			}
			if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameOver){
					recreate();
			}

		}
	}

	@Override
	public void dispose () { // очищает ресурсы
		batch.dispose();

	}

	public void recreate (){
		bird.recreate();
		obstacles.recreate();
		gameOver= false;
	}
}
