package hw2;

import java.awt.geom.PathIterator;
import java.util.ArrayList;

public class CompositeShapePathIterator implements PathIterator {

   private int index;
   private ArrayList<PathIterator> iter;

   public CompositeShapePathIterator() {
      index = 0;
      iter = new ArrayList<>();
   }

   @Override
   public int getWindingRule() {
      if (isDone()) {
         return WIND_EVEN_ODD;
      }
      return iter.get(index).getWindingRule();
   }

   @Override
   public boolean isDone() {
       if (iter.size() == 0) {
           return true;
       } else {
    	   // return last item in the ArrayList
           return iter.get(iter.size() - 1).isDone();
       }
   }

   @Override
   public void next() {
	  // No need once reaching the end
      if (isDone()) {
         return;
      }
      PathIterator curr = iter.get(index);
      if (!curr.isDone()) {
    	  curr.next();
      } else {
         index++;
         iter.get(index).next();
      }
   }

   @Override
   public int currentSegment(float[] coords) {
      PathIterator curr = iter.get(index);
      // Continue until done
      if (!curr.isDone()) {
         return curr.currentSegment(coords);
      } else {
         index++;
         return iter.get(index).currentSegment(coords);
      }
   }

   @Override
   public int currentSegment(double[] coords) {
      PathIterator currentIterator = iter.get(index);
      if (!currentIterator.isDone()) {
         return currentIterator.currentSegment(coords);
      } else {
         index++;
         return iter.get(index).currentSegment(coords);
      }
   }

   public void add(PathIterator pathIterator) {
	   iter.add(pathIterator);
   }
}
