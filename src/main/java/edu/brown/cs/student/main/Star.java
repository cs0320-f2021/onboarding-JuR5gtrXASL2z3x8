package edu.brown.cs.student.main;

public class Star implements Comparable<Star> {
  private int id;
  private String name;
  private float x;
  private float y;
  private float z;
  private float distance;

  public Star(int id, String name, float x, float y, float z) {
    this.id = id;
    this.name = name;
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public Star(String id, String name, String x, String y, String z) {
    this.id = Integer.parseInt(id);
    this.name = name;
    this.x = Float.parseFloat(x);
    this.y = Float.parseFloat(y);
    this.z = Float.parseFloat(z);
  }

  public Star() {

  }

  public int getId() {
    return this.id;
  }
  public float getX() {
    return this.x;
  }

  public float getY() {
    return this.y;
  }

  public float getZ() {
    return this.z;
  }

  public String getName() {
    return this.name;
  }

  public float getDistance() {
    return this.distance;
  }

  public void setDistanceToStar(float inputX, float inputY, float inputZ) {
    double distanceSquaredX = Math.pow(this.x - inputX, 2);
    double distanceSquaredY = Math.pow(this.y - inputY, 2);
    double distanceSquaredZ = Math.pow(this.z - inputZ, 2);
    this.distance = (float) Math.sqrt(distanceSquaredX + distanceSquaredY + distanceSquaredZ);
  }

  @Override
  public int compareTo(Star star) {
    return Float.compare(this.distance, star.getDistance());
  }
}

