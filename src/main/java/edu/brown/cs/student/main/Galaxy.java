package edu.brown.cs.student.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Galaxy {
  private final ArrayList<Star> starList = new ArrayList<Star>();
  private String starDataFile;
  private int size;

  public Galaxy() {

  }

  public Galaxy(String starDataFile) {
    this.starDataFile = starDataFile;
    try (BufferedReader br = new BufferedReader(new FileReader(starDataFile))) {
      String line;
      String[] starData;
      br.readLine();
      while ((line = br.readLine()) != null) {
        line = line.trim();
        starData = line.split(",");
        this.starList.add(new Star(starData[0], starData[1], starData[2], starData[3],
            starData[4]));
      }
      this.size = this.starList.size();
    } catch (Exception e) {
      System.out.println("ERROR: Input file cannot be read");
    }
  }

  public String getStarDataFile() {
    return this.starDataFile;
  }

  public int getSize() {
    return this.size;
  }

  public ArrayList<Star> getStarList() {
    return this.starList;
  }

  private Star searchForStarName(String inputName) {
    String name = inputName.substring(1, inputName.length() - 1);
    for (Star star : this.starList) {
      if (star.getName().equals(name)) {
        return star;
      }
    }
    return null;
  }

  public ArrayList<Integer> getNearestKNeighbors(String k, String inputX, String inputY,
                                                 String inputZ) {
    int integerK = Integer.parseInt(k);
    float floatX = Float.parseFloat(inputX);
    float floatY = Float.parseFloat(inputY);
    float floatZ = Float.parseFloat(inputZ);

    ArrayList<Star> nearestKNeighbors = new ArrayList<Star>();

    for (Star star : this.starList) {
      star.setDistanceToStar(floatX, floatY, floatZ);
      nearestKNeighbors.add(star);
      Collections.sort(nearestKNeighbors);
    }
    return getKNeighbors(integerK, nearestKNeighbors);
  }

  public ArrayList<Integer> getNearestKNeighborsWithName(String k, String starName) {
    int integerK = Integer.parseInt(k);

    Star referenceStar = searchForStarName(starName);
    if (referenceStar == null) {
      throw new RuntimeException("ERROR: Star name not found!");
    }

    ArrayList<Star> nearestKNeighbors = new ArrayList<Star>();

    for (Star star : starList) {
      star.setDistanceToStar(referenceStar.getX(), referenceStar.getY(), referenceStar.getZ());
      nearestKNeighbors.add(star);
      Collections.sort(nearestKNeighbors);
    }
    return getKNeighbors(integerK, nearestKNeighbors);
  }

  private ArrayList<Integer> getKNeighbors(int integerK, ArrayList<Star> nearestKNeighbors) {
    while (nearestKNeighbors.size() > integerK) {
      nearestKNeighbors.remove(nearestKNeighbors.size() - 1);
    }

    ArrayList<Integer> idList = new ArrayList<Integer>();
    for (Star star : nearestKNeighbors) {
      idList.add(star.getId());
    }
    return idList;
  }
}
