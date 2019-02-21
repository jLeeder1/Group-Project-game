package com.mygdx.game.Shooting;

/**
 * Behavior for the hand gun bullet
 * @author Joshua Leeder
 * @date 12/02/19
 */
public class HandGunBullet extends AbstractBullet {

    public HandGunBullet(float posX, float posY){
        super(posX, posY);
        width = 15;
        height = 15;
        speed = 5;
        bulletDamage = 25;
    }
}