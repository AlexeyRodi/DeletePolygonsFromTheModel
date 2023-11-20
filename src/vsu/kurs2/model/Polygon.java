package vsu.kurs2.model;

import java.util.ArrayList;

public class Polygon {

    private ArrayList<Integer> vertexIndices;
    private ArrayList<Integer> textureVertexIndices;
    private ArrayList<Integer> normalIndices;


    public Polygon() {
        vertexIndices = new ArrayList<Integer>();
        textureVertexIndices = new ArrayList<Integer>();
        normalIndices = new ArrayList<Integer>();
    }

    public void setVertexIndices(ArrayList<Integer> vertexIndices) {
        if (vertexIndices.size() < 3) {
            throw new IllegalArgumentException("Illegal number of polygon vertices: " + vertexIndices.size() + ".");
        }

        this.vertexIndices = vertexIndices;
    }

    public void setTextureVertexIndices(ArrayList<Integer> textureVertexIndices) {
        if (vertexIndices.size() < 3) {
            throw new IllegalArgumentException("Illegal number of polygon texture vertices: " + textureVertexIndices.size() + ".");
        }

        this.textureVertexIndices = textureVertexIndices;
    }

    public void setNormalIndices(ArrayList<Integer> normalIndices) {
        if (vertexIndices.size() < 3) {
            throw new IllegalArgumentException("Illegal number of normals: " + normalIndices.size() + ".");
        }

        this.normalIndices = normalIndices;
    }

//    public void setVertexIndices(ArrayList<Integer> vertexIndices) {
//        assert vertexIndices.size() >= 3;
//        this.vertexIndices = vertexIndices;
//    }
//
//    public void setTextureVertexIndices(ArrayList<Integer> textureVertexIndices) {
//        assert textureVertexIndices.size() >= 3;
//        this.textureVertexIndices = textureVertexIndices;
//    }
//
//    public void setNormalIndices(ArrayList<Integer> normalIndices) {
//        assert normalIndices.size() >= 3;
//        this.normalIndices = normalIndices;
//    }

    public ArrayList<Integer> getVertexIndices() {
        return vertexIndices;
    }

    public ArrayList<Integer> getTextureVertexIndices() {
        return textureVertexIndices;
    }

    public ArrayList<Integer> getNormalIndices() {
        return normalIndices;
    }
}
