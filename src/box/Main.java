package box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(console.readLine());
        double width = Double.parseDouble(console.readLine());
        double height = Double.parseDouble(console.readLine());


        try {
            GeometricFigure geometricFigure = new GeometricFigure(length, width, height);
            System.out.println(String.format("Surface Area - %.2f", geometricFigure.getSurfaceArea()));
            System.out.println(String.format("Lateral Surface Area - %.2f", geometricFigure.getLateralSurfaceArea()));
            System.out.println(String.format("Volume - %.2f", geometricFigure.getVolume()));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
