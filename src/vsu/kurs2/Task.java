package vsu.kurs2;

import vsu.kurs2.model.Model;
import vsu.kurs2.model.Polygon;
import vsu.kurs2.objwriter.ObjWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class Task {
    public static void deletePolygons(Model model, int k, boolean delete) {

        model.polygons.remove(k);
        boolean[] usedVertices = new boolean[model.vertices.size()];
        for (Polygon polygon : model.polygons) {
            ArrayList<Integer> vertexIndices = polygon.getVertexIndices();
            for (int vertexIndex : vertexIndices) {
                if (vertexIndex >= 0 && vertexIndex < model.vertices.size()) {
                    usedVertices[vertexIndex] = true;
                }
            }
        }
        for (int i = usedVertices.length - 1; i >= 0; i--) {
            if (!usedVertices[i] && delete) {
                    model.vertices.remove(i);
            }
        }
        ObjWriter.write("3DModels/Faceform/Test.obj", model);
    }
}
