class Circle {
	double x;
	double y;
	double radius;
	
	// default constructor
	// initialize each instance variable to some default value
	Circle() {
		x = 0;
		y = 0;
		radius = 1;
	}
	
	// parameterized constructor
	// initialize each instance variable using one of the parameters
	Circle(double initX, double initY, double initRadius) {
		x = initX;
		y = initY;
		radius = initRadius;
	}
	
	// if print were static, the definition would look like this:
	//
	// static void print(Circle c) {...}
	//
	// and we'd call it like this:
	//
	// Circle.print(c1);
	//
	// many programmers like instance methods because they prefer this format for
	// calling methods:
	//
	// c1.print();
	
	void print() {
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;

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
                x, y, radius, area, circumference);
    }

    boolean containsPoint(double px, double py) {
        double dx = x - px;
        double dy = y - py;
        // squaring the radius is faster than taking the square root of (dx^2 + dy^2)
        return dx * dx + dy * dy <= radius * radius;
    }

    void draw() {
        for (int y = 0; y < 30; y++) {
            for (int x = 0; x < 80; x++) {
                if (containsPoint(x, y)) {
                    System.out.print('O');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }

}
