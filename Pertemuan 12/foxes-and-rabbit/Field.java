import java.util.List;
import java.util.ArrayList;

public class Field{
    private Object[][] field;
    private int width;
    private int depth;

    public Field(int depth, int width){
        field = new Object[depth][width];
        this.width = width;
        this.depth = depth;
    }

    public void clear(Location location){
        field[location.getRow()][location.getCol()] = null;
    }

    public void place(Object object, Location location){
        field[location.getRow()][location.getCol()] = object;
    }

    public Object getObjectAt(Location location){
        return field[location.getRow()][location.getCol()];
    }

    public Location freeAdjacentLocation(Location location){
        List<Location> free = new ArrayList<>();
        List<Location> adjacent = adjacentLocations(location);

        for(Location loc : adjacent){
            if(getObjectAt(loc) == null){
                free.add(loc);
            }
        }

        return free.isEmpty()? null : free.get(0);
    }

    public List<Location> adjacentLocations(Location location){
        List<Location> locations = new ArrayList<>();
        return locations;
    }

    public int getDepth(){
        return depth;
    }

    public int getWidth(){
        return width;
    }
}
