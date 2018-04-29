package net.whiteye.lightmap.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class EffectSprite extends Actor {

    private LightEffect lightEffect;
    private Texture scrTex,normalTex;

    public EffectSprite(String src){
        scrTex = new Texture(src);
        setSize(scrTex.getWidth(),scrTex.getHeight());
    }


    public void setEffect(LightEffect lightEffect,String normalFile){
        this.lightEffect = lightEffect;
        normalTex = new Texture(normalFile);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        ShaderProgram shader = batch.getShader();
        batch.setShader(lightEffect.shaderProgram);


        lightEffect.updateShader(this,normalTex);

        scrTex.bind(0);
        batch.draw(scrTex,getX(),getY(),scrTex.getWidth(),scrTex.getHeight());

        batch.setShader(shader);

    }


}
