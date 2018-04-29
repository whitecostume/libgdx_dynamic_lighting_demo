package net.whiteye.lightmap.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class LightEffect extends Effect {

    private Vector3 lightPos;
    private Color lightColor;
    private Color ambientLightColor;
    private float brightness;
    private float lightCutoffRadius;
    private float lightHalfRadius;

    public LightEffect(){
        initShader();
        setLightColor(Color.WHITE);
        setAmbientLightColor(new Color(127f/255f,127f/255f,127f/255f,1f));
        setLightCutoffRadius(500f);
        setLightHalfRadius(0.5f);

        shaderProgram.begin();

        shaderProgram.setUniformi("u_normals",1);

        shaderProgram.setUniformf("u_lightColor",new Vector3(lightColor.r,lightColor.g,lightColor.b));

        shaderProgram.setUniformf("u_ambientColor",new Vector3(
                ambientLightColor.r,ambientLightColor.g,ambientLightColor.b
        ));

        shaderProgram.end();
    }


    public void setLightPos(Vector3 lightPos) {
        this.lightPos = lightPos;
    }

    public void setLightColor(Color lightColor) {
        this.lightColor = lightColor;
    }

    public void setAmbientLightColor(Color ambientLightColor) {
        this.ambientLightColor = ambientLightColor;
    }

    public Color getLightColor() {
        return lightColor;
    }

    public Color getAmbientLightColor() {
        return ambientLightColor;
    }

    public void setBrightness(float brightness) {
        this.brightness = brightness;
    }

    public void setLightCutoffRadius(float lightCutoffRadius) {
        this.lightCutoffRadius = Math.max(1.0f,lightCutoffRadius) ;
    }

    public void setLightHalfRadius(float lightHalfRadius) {
        this.lightHalfRadius =Math.max(0.01f,Math.min(0.99f,lightHalfRadius)) ;
    }

    public void updateShader(Actor effectSprite, Texture normalTex){
        shaderProgram.setUniformf("u_contentSize",effectSprite.getStage().getWidth(),effectSprite.getStage().getHeight());
        Vector2 pos = effectSprite.stageToLocalCoordinates(new Vector2(lightPos.x,lightPos.y));
        shaderProgram.setUniformf("u_lightPos",new Vector3(pos.x,pos.y,lightPos.z));


        normalTex.bind(1);

        shaderProgram.setUniformf("u_brightness",brightness);

        shaderProgram.setUniformf("u_cutoffRadius",lightCutoffRadius);




        shaderProgram.setUniformf("u_halfRadius",lightHalfRadius);


    }

}
