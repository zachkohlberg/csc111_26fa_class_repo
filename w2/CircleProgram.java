class CircleProgram {
    static void main(String[] args) {
		// parameterized constructors let us conveniently set x, y, and r
        Circle c1 = new Circle(11, 8, 6);
        Circle c2 = new Circle(30, -20, 23);
        // default constructor gives us a unit circle
        Circle c3 = new Circle();

        c1.print();
        c1.draw();
        
        c2.print();
        c3.print();
    }
    
    // primitive/value types:
    //
    // 1      2      4      8
    // byte,  short, int,   long
    //               float, double
    //        char
    // boolean
    // void
    
    // object/reference types:
    //
    // String, arrays

    static void printCircle(Circle c) {
        double area = Math.PI * c.radius * c.radius;
        double circumference = 2 * Math.PI * c.radius;

        System.out.printf(
                // a multiline string literal isn't necessary, but it's easier to read our
                // format string like this
                """
                CIRCLE
                    CENTER: (%.2f, %.2f)
                    RADIUS: %.2f
                    AREA: %.2f
                    CIRCUMFERENCE: %.2f
                """,
                c.x, c.y, c.radius, area, circumference);
    }

    static boolean containsPoint(Circle c, double x, double y) {
        double dx = c.x - x;
        double dy = c.y - y;
        // squaring the radius is faster than taking the square root of (dx^2 + dy^2)
        return dx * dx + dy * dy <= c.radius * c.radius;
    }

    // we can use containsPoint to make some simple ascii art
    static void drawCircle(Circle c) {
        for (int y = 0; y < 30; y++) {
            for (int x = 0; x < 80; x++) {
                if (containsPoint(c, x, y)) {
                    System.out.print('O');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }
}
