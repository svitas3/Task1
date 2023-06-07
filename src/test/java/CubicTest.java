import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CubicTest {
    @Test
    public void testRotateClockwise() {
        Cubic cube = new Cubic(2); // создаем кубик 2x2
        cube.rotate(1, true); // поворачиваем первый слой по часовой стрелке
        int[][] face = cube.getFace(1); // получаем первую грань кубика
        // проверяем, что состояние грани изменилось корректно после поворота
        assertArrayEquals(new int[][] {{1, 2}, {3, 4}}, face);
    }

    @Test
    public void testRotateCounterclockwise() {
        Cubic cube = new Cubic(2); // создаем кубик 2x2
        cube.randomize(); // перемешиваем кубик случайным образом
        int[][] faceBefore = cube.getFace(1); // получаем состояние первой грани перед поворотом
        cube.rotate(2, false); // поворачиваем второй слой против часовой стрелки
        int[][] faceAfter = cube.getFace(1); // получаем состояние первой грани после поворота
        // проверяем, что состояние грани изменилось корректно после поворота
        assertNotEquals(faceBefore, faceAfter);
    }

    @Test
    public void testShuffle() {
        Cubic cube = new Cubic(3); // создаем кубик 3x3
        cube.shuffle(); // перемешиваем кубик
        int[][] face = cube.getFace(1); // получаем первую грань кубика
        // проверяем, что все элементы грани находятся в диапазоне от 1 до 9
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(face[i][j] >= 1 && face[i][j] <= 9);
            }
        }
    }

    @Test
    public void testRandomize() {
        Cubic cube = new Cubic(2); // создаем кубик 2x2
        int[][] faceBefore = cube.getFace(4); // получаем состояние четвертой грани перед перемешиванием
        cube.randomize(); // перемешиваем кубик
        int[][] faceAfter = cube.getFace(4); // получаем состояние четвертой грани после перемешивания
        // проверяем, что состояние грани изменилось корректно после перемешивания
        assertNotEquals(faceBefore, faceAfter);
    }
}

//В данном примере представлены четыре теста. Первый тест проверяет, что возможно повернуть один слой кубика по часовой стрелке. Второй тест проверяет, что возможно повернуть один слой кубика против часовой стрелки. Третий тест проверяет, что кубик может быть перемешан случайным образом. Четвертый тест проверяет, что кубик может быть перемешан с помощью метода randomize(). Общее количество тестов можно увеличить, проверив дополнительные краевые случаи или используя более сложные алгоритмы поворота кубика.
