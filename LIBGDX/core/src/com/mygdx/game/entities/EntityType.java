package com.mygdx.game.entities;

public enum EntityType {
	//creating all entity types
	PLAYER("player", 14, 32, 40), ENEMY("enemy", 14, 32, 40), FRIENDLY("friendly", 14, 32, 40);
	private String id;
	private int width, height;
	private float weight;
	
	private EntityType(String id, int width, int height, float weight) {
		this.id = id;
		this.width = width;
		this.height = height;
		this.weight = weight;
	}

	public String getId() {
		return id;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public float getWeight() {
		return weight;
	}
	
	
}
