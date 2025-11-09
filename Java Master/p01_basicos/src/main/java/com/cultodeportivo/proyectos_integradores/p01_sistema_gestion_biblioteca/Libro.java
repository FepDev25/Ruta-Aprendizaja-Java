package com.cultodeportivo.proyectos_integradores.p01_sistema_gestion_biblioteca;

class Libro {

    // Título, Autor, ISBN, Año de publicación, Número de páginas, Categoría
    private String titulo;
    private String autor;
    private String isbn;
    private int anioPublicacion;
    private int numPaginas;
    private String categoria;

    public Libro(String titulo, String autor, String isbn, int anioPublicacion, int numPaginas, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.numPaginas = numPaginas;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("╔════════════════════════════════════════════╗\n");
        sb.append("║         INFORMACIÓN DEL LIBRO              ║\n");
        sb.append("╠════════════════════════════════════════════╣\n");
        sb.append(String.format("║ %-12s %-30s ║\n", "Título:", titulo));
        sb.append(String.format("║ %-12s %-30s ║\n", "Autor:", autor));
        sb.append(String.format("║ %-12s %-30s ║\n", "ISBN:", isbn));
        sb.append(String.format("║ %-12s %-30d ║\n", "Año:", anioPublicacion));
        sb.append(String.format("║ %-12s %-30d ║\n", "Páginas:", numPaginas));
        sb.append(String.format("║ %-12s %-30s ║\n", "Categoría:", categoria));
        sb.append("╚════════════════════════════════════════════╝\n");

        return sb.toString();
    }

}
