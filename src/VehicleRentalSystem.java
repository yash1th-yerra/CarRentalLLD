import model.Location;
import model.RentalStore;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleRentalSystem {
    private List<User> users;
    private List<RentalStore> rentalStores;


    public VehicleRentalSystem(){
        this.users = new ArrayList<>();
        this.rentalStores = new ArrayList<>();
    }

    public VehicleRentalSystem(List<RentalStore> stores,List<User> users){
        this.users = users;
        this.rentalStores = stores;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void addRentalStore(RentalStore store){
        rentalStores.add(store);
    }

    public void removeUser(User user){
        users.remove(user);
    }

    public void removeStore(RentalStore store){
        rentalStores.remove(store);
    }


    public List<RentalStore> getStore(Location location){
        return rentalStores.stream().filter(s-> s.getStoreLocation().equals(location)).collect(Collectors.toList());


    }
}

