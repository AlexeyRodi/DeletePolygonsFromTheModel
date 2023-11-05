package vsu.kurs2;

import vsu.kurs2.model.Model;
import vsu.kurs2.objreader.ObjReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of("3DModels/Faceform/WrapBody.obj");
        String fileContent = Files.readString(fileName);

        System.out.println("Loading model ...");
        Model model = ObjReader.read(fileContent);

        showInfoAboutModel(model);

        System.out.println();

        Task.deletePolygons(model);

        Path fileName2 = Path.of("3DModels/Faceform/Test.obj");
        String fileContent2 = Files.readString(fileName2);

        System.out.println("Loading model ...");
        Model model2 = ObjReader.read(fileContent2);
        showInfoAboutModel(model2);

    }

    public static void showInfoAboutModel(Model model) {
        System.out.println("Vertices: " + model.vertices.size());
        System.out.println("Texture vertices: " + model.textureVertices.size());
        System.out.println("Normals: " + model.normals.size());
        System.out.println("Polygons: " + model.polygons.size());
    }
}