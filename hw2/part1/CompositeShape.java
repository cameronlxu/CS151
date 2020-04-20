package hw2;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class CompositeShape implements Shape {

   private ArrayList<Shape> shapes;

   public CompositeShape() {
      shapes = new ArrayList<>();
   }

   public void add(Shape shape) {
      shapes.add(shape);
   }

   public boolean contains(double x, double y) {
      for (Shape shape : shapes) {
         if (shape.contains(x, y)) return true;
      }
      return false;
   }

   public boolean contains(double x, double y, double w, double h) {
      for (Shape shape : shapes) {
         if (shape.contains(x, y, w, h)) return true;
      }
      return false;
   }

   public boolean contains(Point2D p) {
      for (Shape shape : shapes) {
         if (shape.contains(p)) {
        	 return true;
         }
      }
      return false;
   }

   public boolean contains(Rectangle2D r) {
      for (Shape shape : shapes) {
         if (shape.contains(r)) {
        	 return true;
         }
      }
      return false;
   }

   public Rectangle getBounds() {
      if (shapes.size() == 0) {
          return new Rectangle();
      }
      Shape shape = shapes.get(0);
      Rectangle r = shape.getBounds();
      for (int i = 1; i < shapes.size(); i++) {
         shape = shapes.get(i);
         r = r.union(shape.getBounds());
      }
      return r;
   }

   public Rectangle2D getBounds2D() {
	  // Check to see if the size of the shape is 0. Can't create a shape with size 0
      if (shapes.size() == 0) {
          return new Rectangle2D.Double();
      }

      // If not size 0, then create new shape
      Shape shape = shapes.get(0);
      Rectangle2D r = shape.getBounds2D();

      for (int i = 1; i < shapes.size(); i++) {
         shape = shapes.get(i);
         Rectangle2D.union(r, shape.getBounds(), r);
      }
      return r;
   }

   public PathIterator getPathIterator(AffineTransform at) {
      CompositeShapePathIterator iter = new CompositeShapePathIterator();
      for (Shape shape : shapes) {
         iter.add(shape.getPathIterator(at));
      }
      return iter;
   }

   public PathIterator getPathIterator(AffineTransform at, double flatness) {
      CompositeShapePathIterator iter = new CompositeShapePathIterator();
      for (Shape shape : shapes) {
         iter.add(shape.getPathIterator(at, flatness));
      }
      return iter;
   }

   public boolean intersects(double x, double y, double w, double h) {
      for (Shape shape : shapes) {
         if (shape.intersects(x, y, w, h)) {
        	 return true;
         }
      }
      return false;
   }

   public boolean intersects(Rectangle2D r) {
      for (Shape shape : shapes) {
         if (shape.intersects(r)) {
             return true;
         }
      }
      return false;
   }
}
