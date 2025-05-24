package com.mycompany.juego;

// Representa el mapa como una matriz de celdas
public class Mapa {
    private int filas;
    private int columnas;
    private Celda[][] celdas;

    // Constructor: crea un mapa de tamaño filas x columnas
    public Mapa(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        celdas = new Celda[filas][columnas];
        inicializarCeldas();
    }

    // Inicializa cada celda del mapa como vacía
    private void inicializarCeldas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = new Celda();
            }
        }
    }

    // Devuelve la celda ubicada en (x, y), o null si está fuera del mapa
    public Celda getCelda(int x, int y) {
        if (x >= 0 && x < filas && y >= 0 && y < columnas) {
            return celdas[x][y];
        } else {
            return null;
        }
    }

    // Mueve un personaje a una nueva posición si el destino es válido
    public boolean moverPersonaje(Personaje personaje, int dx, int dy) {
        int nuevoX = personaje.getPosicion().getX() + dx;
        int nuevoY = personaje.getPosicion().getY() + dy;

        // Verifica que esté dentro del mapa
        if (nuevoX >= 0 && nuevoX < filas && nuevoY >= 0 && nuevoY < columnas) {
            Celda destino = celdas[nuevoX][nuevoY];
            if (!destino.estaBloqueada() && destino.estaVacia()) {
                // Se limpia la celda actual
                Celda actual = celdas[personaje.getPosicion().getX()][personaje.getPosicion().getY()];
                actual.setContenido(null);

                // Se actualiza el contenido y la posición
                destino.setContenido(personaje);
                personaje.setPosicion(new Posicion(nuevoX, nuevoY));
                return true;
            }
        }

        return false;
    }

    // Imprime el mapa por consola con letras que representan lo que hay en cada celda
    public void imprimirMapa() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (celdas[i][j].getContenido() instanceof Snake) {
                    System.out.print("S ");
                } else if (celdas[i][j].getContenido() instanceof Guardia) {
                    System.out.print("G ");
                } else if (celdas[i][j].getContenido() instanceof MetalGear) { // ESTO no es necesario
                    System.out.print("M ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}