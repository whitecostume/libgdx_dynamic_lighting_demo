package net.whiteye.lightmap;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Align;

import net.whiteye.lightmap.actors.EffectSprite;
import net.whiteye.lightmap.actors.LightEffect;

import var3d.net.center.VGame;
import var3d.net.center.VStage;

public class StageMain extends VStage {
    public StageMain(VGame game) {
        super(game);
    }

    @Override
    public void init() {
//        setBackground(R.background_01);



        final EffectSprite effectSprite = new EffectSprite(R.foreground_01);
        final LightEffect lightEffect = new LightEffect();

        lightEffect.setLightPos(new Vector3(getWidth()/2,getHeight()/2
                ,100));
        lightEffect.setLightCutoffRadius(1000);
        lightEffect.setBrightness(2.0f);

        effectSprite.setEffect(lightEffect,R.foreground_01_n);

        game.getImage(R.background_01)
                .setColor(lightEffect.getAmbientLightColor())
                .show();

        addActor(effectSprite);

        Image lightImg = game.getImage(R.lightbulb)
                .setPosition(getWidth()/2,getHeight()/2, Align.center)
                .setOrigin(Align.center)
                .addListener(new DragListener(){

                    @Override
                    public void drag(InputEvent event, float x, float y, int pointer) {
                        Actor actor = event.getListenerActor();
                        actor.setPosition(event.getStageX(),event.getStageY(),Align.center);
                        lightEffect.setLightPos(new Vector3(event.getStageX(),event.getStageY(),100));
                    }

                })
                .show();

    }

    @Override
    public void reStart() {

    }

    @Override
    public void back() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void changing(float width, float height) {

    }
}
