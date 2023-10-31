package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background bg;
	
	@Override
	public void create () { // выполняется единожды, содержит необходимые расчеты и функции для запуска
		batch = new SpriteBatch();
		bg = new Background();
	}

	@Override
	public void render () { // 60 раз в сек.отрисовывает то, что задаем в методах
		update();
		ScreenUtils.clear(1, 1, 1, 1); // создаем цвет фона
		batch.begin(); //начало отрисовки
		bg.render(batch); //отрисовка картинки 0 и 0 начало
		batch.end(); // заканчивается отрисовка
	}

	public void update(){ // для просчета математики игры
		bg.update();
	}

	@Override
	public void dispose () { // очищает ресурсы
		batch.dispose();

	}
}
