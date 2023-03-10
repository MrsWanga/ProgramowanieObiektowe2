package Laboratorium8;

public class Table {
    private int height;
    private int width;
    private int length;

    public Table(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Table{" +
                "height=" + height +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
