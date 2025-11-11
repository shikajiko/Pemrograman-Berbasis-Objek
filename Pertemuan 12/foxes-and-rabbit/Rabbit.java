import java.util.List;

public class Rabbit extends Animal{
    public Rabbit(Field field, Location location){
        super(field, location);
    }

    @Override
    public void act(List<Animal> newAnimals){
        if(isAlive()){
            if(getAge() >= 5){
                setDead();
                return;
            }
            
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if(getAge() >= 2){
                breed(newAnimals, newLocation);
            }

            setLocation(newLocation);
            increaseAge();
        }

    }

    private void breed(List<Animal> newAnimals, Location location){
        newAnimals.add(new Rabbit(getField(), location));
    }
}