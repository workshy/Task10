package ua.epam;

/**
 * Created by Viktoriia_Marynchak on 9/26/2016.
 */
public class Adapter {

    public static void main(String[] args) {

        //1-й способ: через наследование
        VectorGraphicInterface g1 = new VectorAdepterFromRaster();
        g1.drawLine();
        g1.drawSquare();

        //2-й способ: через композицию
        VectorGraphicInterface g2 = new VectorAdapterFromRaster2();
        g2.drawLine();
        g2.drawSquare();

    }
}

interface VectorGraphicInterface {
    void drawLine();
    void drawSquare();
}

class VectorAdepterFromRaster extends RasterGraphics implements VectorGraphicInterface{
    public void drawLine(){
        drawRasterLine();
    }

    public void drawSquare(){
        drawRasterSquare();
    }
}

class RasterGraphics {
    void drawRasterLine(){
        System.out.println("Рисуем линию");
    }

    void drawRasterSquare(){
        System.out.println("Рисуем квадрат");
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicInterface {
    RasterGraphics raster = new RasterGraphics();

    public void drawLine(){
        raster.drawRasterLine();
    }

    public void drawSquare(){
        raster.drawRasterSquare();
    }
}
