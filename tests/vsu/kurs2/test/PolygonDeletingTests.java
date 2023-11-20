package vsu.kurs2.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vsu.kurs2.Task;
import vsu.kurs2.model.Model;
import vsu.kurs2.objreader.ObjReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class PolygonDeletingTests {
    @Test
    void deletingPolygon1() throws IOException {
        Path fileName = Path.of("3DModels/SimpleModelsForReaderTests/LoadingTest.obj");
        String fileContent = Files.readString(fileName);
        Model model = ObjReader.read(fileContent);
        int poly_size = model.polygons.size() - 1;
        int vert_size = model.vertices.size() - 1;
        Task.deletePolygons(model, 1, true);
        Assertions.assertEquals(poly_size, model.polygons.size());
        Assertions.assertEquals(vert_size, model.vertices.size());
    }

    @Test
    void deletingPolygon2() throws IOException {
        Path fileName = Path.of("3DModels/SimpleModelsForReaderTests/Teapot.obj");
        String fileContent = Files.readString(fileName);
        Model model = ObjReader.read(fileContent);
        int poly_size = model.polygons.size() - 1;
        Task.deletePolygons(model, 5, false);
        Assertions.assertEquals(poly_size, model.polygons.size());
    }

    @Test
    void deletingPolygon3() throws IOException {
        Path fileName = Path.of("3DModels/FaceForm/WrapBody.obj");
        String fileContent = Files.readString(fileName);
        Model model = ObjReader.read(fileContent);
        int poly_size = model.polygons.size() - 1;
        Task.deletePolygons(model, 234, false);
        Assertions.assertEquals(poly_size, model.polygons.size());
    }

    @Test
    void deletingPolygon4() throws IOException {
        Path fileName = Path.of("3DModels/FaceForm/WrapSkull.obj");
        String fileContent = Files.readString(fileName);
        Model model = ObjReader.read(fileContent);
        int poly_size = model.polygons.size() - 1;
        Task.deletePolygons(model, 2000, false);
        Assertions.assertEquals(poly_size, model.polygons.size());
    }

    @Test
    void deletingPolygon5() throws IOException {
        Path fileName = Path.of("3DModels/FaceForm/WrapHand.obj");
        String fileContent = Files.readString(fileName);
        Model model = ObjReader.read(fileContent);
        int poly_size = model.polygons.size() - 1;
        Task.deletePolygons(model, 2334, false);
        Assertions.assertEquals(poly_size, model.polygons.size());
    }
}
