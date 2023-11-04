package vsu.kurs2;

import vsu.kurs2.model.Model;
import vsu.kurs2.model.Polygon;
import vsu.kurs2.objwriter.ObjWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class Task {
    public static void deletePolygons (Model model){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер полигона - ");
        int k = scanner.nextInt();
        model.polygons.remove(k);
        ObjWriter.write("3DModels/Faceform/Test.obj", model);
    }
}
