package net.whiteye.lightmap.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

import net.whiteye.lightmap.R;

public class Effect {

    protected ShaderProgram shaderProgram;

    public void initShader(){

        shaderProgram = new ShaderProgram(Gdx.files.internal(R.pointlight),Gdx.files.internal(R.pointlight_frag));
        if (!shaderProgram.isCompiled()){
            throw new IllegalArgumentException("Error compiling shader: " + shaderProgram.getLog());
        }
    }

}
