package fox;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Класс для конвертации относительных координат.
 * При расположении объектов в пространстве окна - они должны занять примерно
 * то же относительное положение при развертывании окна на весь экран
 * или при открытии на мониторе с другим разрешением.
 * <p>
 * Данный класс призван решить проблему с определением координат
 * для расположения объектов в динамических окнах.
 */
public class FoxPointConverter {

    // Возвращает процент изменения double от 0 до 1.
    public static double getPercentDifference(Number wasABC, Number nowABC) {
        return (wasABC.doubleValue() - nowABC.doubleValue()) / wasABC.doubleValue();
    }

    /**
     * Расчет новой позиции точки для изменившегося родительского окна.
     *
     * @param type        Тип преобразования - из точки в проценты или наоборот.
     * @param sourcePoint требуемые координаты точки.
     * @param shape       фигура с которой связаны указанные координаты точки.
     * @return преобразованные координаты - проценты от источника или координаты из процентов.
     */
    public static Point2D convert(CONVERT_TYPE type, Point2D sourcePoint, Shape shape) {
        double sw = shape.getBounds().getWidth();
        double sh = shape.getBounds().getHeight();
        return switch (type) {
            case PERCENT_TO_POINT ->
                    new Point2D.Double(getPixels(sw, sourcePoint.getX()), getPixels(sh, sourcePoint.getY()));
            case POINT_TO_PERCENT ->
                    new Point2D.Double(getPercent(sw, sourcePoint.getX()), getPercent(sh, sourcePoint.getY()));
        };
    }

    /**
     * Принимает текущую длину источника и координату X точки для нахождения её процента.
     *
     * @param width      ширина владельца координаты.
     * @param coordinate координата X или Y.
     * @return double от 0 до 1.
     */
    public static double getPercent(Number width, Number coordinate) {
        return coordinate.doubleValue() / width.doubleValue();
    }

    /**
     * Принимает новую длину владельца координаты и процент от 0 до 1 для координаты.
     *
     * @param width   ширина владельца координаты.
     * @param percent процент X или Y.
     * @return float от 0 до 1:
     * @throws IllegalArgumentException если указанный процент меньше 0 или больше 1.
     */
    public static double getPixels(Number width, Number percent) throws IllegalArgumentException {
        if (percent.doubleValue() < 0 || percent.doubleValue() > 1) {
            throw new IllegalArgumentException("percent must be '>= 0' and '<= 1'.");
        }
        return width.doubleValue() * percent.doubleValue();
    }

    /**
     * Расчёт координат точки для другого окна, не имеющего прямой связи с координатной системой владельца точки.
     * Если точка лежит на стороннем ресурсе, но нужно отобразить её в окне в том же месте, где она отображается в источнике.
     */
    public static Point2D relocateOn(Rectangle2D pointOwnerRect, Rectangle2D destinationRect, Point2D.Double point) {
        // Вычисляем фактические ширину и высоту владельца точки:
        double w = pointOwnerRect.getWidth() - pointOwnerRect.getX();
        double h = pointOwnerRect.getHeight() - pointOwnerRect.getY();

        // Определяем фактическое расстояние по горизонтали и вертикали на владельце до указанной точки:
        double x1 = point.getX() - pointOwnerRect.getX();
        double y1 = point.getY() - pointOwnerRect.getY();

        // Вычисляем процентное значение расположения указанной точки на владельце точки:
        double x2 = x1 / (w / 100);
        double y2 = y1 / (h / 100);

        // Определяем координаты на новом владельце по вычисленным ранее процентам:
        double x4 = destinationRect.getWidth() / 100d * x2;
        double y4 = destinationRect.getHeight() / 100d * y2;

        // результат - координаты той же точки, но на другом экране:
        return new Point2D.Double(x4, y4);
    }

    public enum CONVERT_TYPE {PERCENT_TO_POINT, POINT_TO_PERCENT}
}
