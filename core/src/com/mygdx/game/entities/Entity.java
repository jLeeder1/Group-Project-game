package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.game.AlienGame;

public abstract class Entity {

    protected Vector2 pos;
    protected EntityType type;
    protected int health = 50;
    protected final int
            MAX_HEALTH = 50,
            MIN_HEALTH = 0;

    private float xOrigin;
    private float xDestination;
    private float xBoundary = 20 / AlienGame.ppm;
    protected Texture image;

    /** For collision */
    protected World world = AlienGame.world;
    protected Body b2body;
    protected float scale = AlienGame.ppm;
    protected BodyDef bdef;

    /** Speed of entity */
    protected final float MAX_SPEED = 1.5f;
    protected static final float speed = 1;


    public Entity(float x, float y, EntityType type) {
        this.pos = new Vector2(x, y);
        this.type = type;
        xOrigin = x;
        xDestination = x + xBoundary;
    }


    public abstract void render(SpriteBatch batch);

    public abstract void update (float deltaTime);

    public void moveRight(boolean right, Entity entity){

        // Checks to see if the entity is a player, and if it is gets the speed that is based on humanity
        float speedOfEntity = entity.getSpeed();

        // Move right by default
        int direction = 1;
        if(right != true){
            direction = -1;
        }
        b2body.applyLinearImpulse(new Vector2(((3f * speedOfEntity) * direction) / scale, 0f), b2body.getWorldCenter(), true);
    }

    public void dispose(){
        //image.dispose();
    }

    /** Getters and Setters */


    public float getx () {
        return pos.x;
    }

    public float gety() {
        return pos.y;
    }

    public void setx(int i) {
        this.pos.x = i;
    }

    public void sety(int i) {
        this.pos.y = i;
    }

    public EntityType getType() {
        return type;
    }

    public float getWidth() {
        return type.getWidth();
    }

    public float getHeight() {
        return type.getHeight();
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int amount) {
        health -= amount;
    }

    //Is this appropriate to be here or should it be in player?
    public void increaseHealth(int amount) {
        health += amount;
    }

    public Texture getTexture(){
        return image;
    }

    public float getxOrigin(){
        return xOrigin;
    }

    public float getxDestination(){
        return xDestination;
    }

    public abstract void defineEntityBox2D(float xPos, float yPos);

    public Body getB2body(){
        return b2body;
    }

    public abstract float getSpeed();

    public BodyDef getBdef() {
        return bdef;
    }
}