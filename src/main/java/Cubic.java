public class Cubic {
    private int[][][] cube;
    private int size;

    public Cubic(int size) {
        this.size = size;
        this.cube = new int[size][size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    this.cube[i][j][k] = i * size * size + j * size + k + 1;
                }
            }
        }
    }

    // запрос состояния всего кубика
    public int[][][] getCube() {
        int[][][] result = new int[3][3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j][k] = cube[i][j][k];
                }
            }
        }
        return result;
    }

    // поворот указанного слоя кубика
    public void rotate(int layer, boolean clockwise) {
        int[][] temp = new int[size][size];
        int index = clockwise ? size - layer : layer - 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (index >= 0 && index <= size - 1) {
                    if (clockwise) {
                        temp[j][size - index - 1] = cube[index][j][layer - 1];
                    } else {
                        temp[size - j - 1][index] = cube[index][j][size - layer];
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (index >= 0 && index <= size - 1) {
                    if (clockwise) {
                        cube[index][j][layer - 1] = temp[i][j];
                    } else {
                        cube[index][j][size - layer] = temp[size - j - 1][i];
                    }
                }
            }
        }
    }

    // перемешивание кубика
    public void shuffle() {
        int[][][] temp = new int[size][size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    temp[i][j][k] = cube[size - j - 1][i][k];
                }
            }
        }
        cube = temp;
    }

    // запрос состояния грани
    public int[][] getFace(int face) {
        int[][] result = new int[size][size];
        switch (face) {
            case 1:
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        result[i][j] = cube[0][i][j];
                    }
                }
                break;
            case 2:
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        result[i][j] = cube[size - 1][i][j];
                    }
                }
                break;
            case 3:
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        result[i][j] = cube[i][0][j];
                    }
                }
                break;
            case 4:
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        result[i][j] = cube[i][size - 1][j];
                    }
                }
                break;
            case 5:
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        result[i][j] = cube[i][j][0];
                    }
                }
                break;
            case 6:
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        result[i][j] = cube[i][j][size - 1];
                    }
                }
                break;
            default:
                System.out.println("Incorrect face number.");
        }
        return result;
    }

    // поворот всего кубика
    public void rotateCube(int direction) {
        int[][][] temp = new int[3][3][3];
        if (direction == 0) { // поворот по оси Х
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        temp[2 - j][i][k] = cube[i][j][k];
                    }
                }
            }
        } else if (direction == 1) { // поворот по оси Y
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        temp[i][2 - k][j] = cube[i][j][k];
                    }
                }
            }
        } else if (direction == 2) { // поворот по оси Z
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        temp[k][j][2 - i] = cube[i][j][k];
                    }
                }
            }
        }
        cube = temp;
    }

    // случайный поворот слоя кубика
    public void randomize() {
        for (int i = 0; i < size; i++) {
            this.rotate(i + 1, Math.random() < 0.5);
        }
    }
}
