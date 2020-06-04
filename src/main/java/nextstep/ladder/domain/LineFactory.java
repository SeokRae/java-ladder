package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PointsNeedMoreThanOnePersonException;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {
    private static final int MIN_COUNT_OF_PERSON = 1;

    public static Line create(int countOfPerson, PointAddStrategy pointAddStrategy) {
        validateCountOfPerson(countOfPerson);
        return new Line(new ArrayList<>(makeLine(countOfPerson, pointAddStrategy)));
    }

    private static List<Point> makeLine(int countOfPerson, PointAddStrategy pointAddStrategy) {
        List<Point> values = new ArrayList<>();
        values.add(new Point(false));

        if (countOfPerson == MIN_COUNT_OF_PERSON) {
            return values;
        }

        for (int i = 1; i < countOfPerson; i++) {
            values.add(new Point(
                    pointAddStrategy.confirmPointLocation(
                            !values.get(values.size() - 1).getValue())));
        }
        return values;
    }

    private static void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < MIN_COUNT_OF_PERSON) {
            throw new PointsNeedMoreThanOnePersonException("Need more than one people to make line");
        }
    }
}