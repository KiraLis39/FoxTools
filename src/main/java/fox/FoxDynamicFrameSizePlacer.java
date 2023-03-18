package fox;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Класс для конвертации относительных координат.
 * При расположении объектов в пространстве окна - они должны занять примерно
 * то же относительное положение при развертывании окна на весь экран
 * или при открытии на мониторе с другим разрешением.
 * <p>
 * Данный класс призван решить проблему с определением координат
 * для расположения объектов в динамических окнах.
 */
public final class FoxDynamicFrameSizePlacer {
    // FIND DIFFERENCE:
    //	Принимает старую длину вектора и новую.
    // Возвращает процент изменения double от 0 до 1.
    public static double getPercentDifference(double wasABC, double nowABC) {
        return (wasABC - nowABC) / wasABC;
    }

    // Возвращает процент изменения float от 0 до 1.
    public static float getPercentDifference(float wasABC, float nowABC) {
        return (wasABC - nowABC) / wasABC;
    }

    // Возвращает процент изменения int от 0 до 100.
    public static int getPercentDifference(int wasABC, int nowABC) {
        return (int) ((((wasABC * 1f) - (nowABC * 1f)) / (wasABC * 1f)) * 100f);
    }

    public static Point2D convert(CONVERT_TYPE type, Point2D src, Dimension dim) {
        return switch (type) {
            case PERCENT_TO_POINT -> new Point2D.Double(dim.getWidth() * src.getX(), dim.getHeight() * src.getY());
            case POINT_TO_PERCENT -> new Point2D.Double(src.getX() / dim.getWidth(), src.getY() / dim.getHeight());
        };
    }

	// POINT to PERCENT
    // Принимает текущую длину вектора и координату точки для нахождения её процента.
    // Возвращает double от 0 до 1.
    public static double getPercent(double dimLenght, double pixel) {
        return pixel / dimLenght;
    }

    // возвращает float от 0 до 1:
    public static float getPercent(float dimLenght, float pixel) {
        return pixel / dimLenght;
    }

    // возвращает int от 0 до 100:
    public static int getPercent(int dimLenght, int pixel) {
        return (int) ((pixel * 1f) / (dimLenght * 1f) * 100f);
    }

    // PERCENT to POINT:
    // Возвращает double от 0 до 1.
    public static double getPixels(double newDimLenght, double percent) throws Exception {
        if (percent < 0 || percent > 1) {
            throw new Exception("percent must be '>= 0' and '<= 1'.");
        }
        return newDimLenght * percent;
    }

    // Принимает новую длину вектора и требуемый процент от 0 до 1 для нахождения точки.
    // возвращает float от 0 до 1:
    public static float getPixels(float newDimLenght, float percent) throws Exception {
        if (percent < 0 || percent > 1) {
            throw new Exception("percent must be '>= 0' and '<= 1'.");
        }
        return newDimLenght * percent;
    }

    // Принимает новую длину вектора и требуемый процент от 0 до 100 для нахождения точки.
    // возвращает int от 0 до 100:
    public static int getPixels(int newDimLenght, int percent) throws Exception {
        if (percent < 0 || percent > 100) {
            throw new Exception("percent must be '>= 0' and '<= 100'.");
        }
        return (int) ((newDimLenght * 1f) * (percent * 1f) / 100f);
    }

    public enum CONVERT_TYPE {PERCENT_TO_POINT, POINT_TO_PERCENT}
}
