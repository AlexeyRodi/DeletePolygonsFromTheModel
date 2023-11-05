package vsu.kurs2;

import vsu.kurs2.model.Model;
import vsu.kurs2.model.Polygon;
import vsu.kurs2.objwriter.ObjWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class Task {
    public static void deletePolygons(Model model) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер полигона - ");
        int k = scanner.nextInt();

        model.polygons.remove(k);
        scanner.close();
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
            if (!usedVertices[i]) {
                System.out.println("Хотите ли вы удалить вершину под индексом " + i + "?");
                if (scanner.nextLine().equals("Да")){
                    model.vertices.remove(i);
                    System.out.println("Свободная вершина удалилась");
                }
                else continue;
            }
        }
        ObjWriter.write("3DModels/Faceform/Test.obj", model);
    }
}
