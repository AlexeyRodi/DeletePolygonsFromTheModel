package vsu.kurs2;

import vsu.kurs2.model.Model;
import vsu.kurs2.model.Polygon;
import vsu.kurs2.objwriter.ObjWriter;

import java.util.ArrayList;

public class Task {
    public static void deletePolygons(Model model, int k, boolean delete) {


        model.polygons.remove(k);

        boolean[] usedVertices = new boolean[model.vertices.size()];
        for (Polygon polygon : model.polygons) {
            ArrayList<Integer> vertexIndices = polygon.getVertexIndices();
            for (int i = 0; i < vertexIndices.size(); i++) {
                int vertexIndex = vertexIndices.get(i);
                if (vertexIndex >= 0 && vertexIndex < model.vertices.size()) {
                    usedVertices[vertexIndex] = true;
                }
            }
        }
        if (delete) {
            for (int i = usedVertices.length - 1; i >= 0; i--) {
                if (!usedVertices[i]) {
                    model.vertices.remove(i);
                    for (Polygon polygon : model.polygons) {
                        for (int index = 0; index < polygon.getVertexIndices().size(); index++) {
                            if (polygon.vertexIndices.get(index) >= i) {
                                polygon.vertexIndices.set(index, polygon.vertexIndices.get(index - 1));
                            }
                        }
                    }
                }
            }

            ObjWriter.write("3DModels/Faceform/Test.obj", model);
        }

    }
}
