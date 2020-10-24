package ConvexHull;


import Stack.MyStack;

import java.util.*;

public class ConvexHull {
    public static void main(String[] args) {
        Point o = new Point(5.0, 2.0, "o");
        Point a = new Point(9.0, 5.0, "a");
        Point b = new Point(9.0, 8.0, "b");
        Point c = new Point(7.0, 6.0, "c");
        Point d = new Point(3.0, 6.0, "d");
        Point e = new Point(6.0, 5.0, "e");
        Point f = new Point(-4.0, 8.0, "f");
        List<Point> pointList = new ArrayList<>();
        pointList.add(o);
        pointList.add(a);
        pointList.add(b);
        pointList.add(c);
        pointList.add(d);
        pointList.add(e);
        pointList.add(f);
        Point lowestPoint = getLowestPoint(pointList);
        pointList.remove(lowestPoint);
        List<Point> sorted = sortPointsByCCW(pointList, lowestPoint);
        MyStack<Point> pointMyStack = new MyStack<Point>();
        pointMyStack.push(lowestPoint);
        pointMyStack.push(sorted.get(0));
        pointMyStack.push(sorted.get(1));
        for (int i = 2; i < sorted.size(); i++) {
            Point p2 = pointMyStack.pop();
            Point p1 = pointMyStack.peek();
            Point p3 = sorted.get(i);
            while (!isCCW(p1, p2, p3)) {
                p2 = pointMyStack.pop();
                p1 = pointMyStack.peek();
            }
            pointMyStack.push(p2);
            pointMyStack.push(p3);

        }
        while (true) {
            Point p = pointMyStack.pop();
            if (p == null) {
                break;
            }
            System.out.println(p);
        }


    }

    public static Point getLowestPoint(List<Point> points) {
        points.sort(Comparator.comparing(p -> p.getY()));
        return points.get(0);
    }

    public static double getCosine(Point from, Point to) {
        double opp = to.getY() - from.getY();
        double adj = to.getX() - from.getX();
        double hyp = Math.sqrt(Math.pow(opp, 2) + Math.pow(adj, 2));
        return adj / hyp;
    }

    public static List<Point> sortPointsByCCW(List<Point> points, Point lowestPoint) {
        List<Point> sortedPoints = new ArrayList<>();
        Map<Point, Double> pointMap = new HashMap<>();

        for (Point point : points) {
            double cosine = getCosine(lowestPoint, point);
            pointMap.put(point, cosine);
        }

        List<Map.Entry<Point, Double>> entries = new ArrayList<>(pointMap.entrySet());
        entries.sort(Comparator.comparing(e -> 0 - e.getValue()));
        for (Map.Entry<Point, Double> entry : entries) {
            sortedPoints.add(entry.getKey());
        }
        return sortedPoints;
    }

    public static boolean isCCW(Point a, Point b, Point c) {
        double result = (b.getX() - a.getX()) * (c.getY() - a.getY()) - (b.getY() - a.getY()) * (c.getX() - a.getX());
        if (result > 0) {
            return true;
        }


        return false;
    }

}
