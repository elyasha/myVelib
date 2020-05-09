package core.system;

import core.components.Bicycle;
import core.components.Card;
import core.components.Station;
import core.components.User;

import java.util.List;
import java.util.Objects;

public class MyVelibSystem {
    private List<Station> stations;
    private List<User> users;
    private List<Bicycle> bicycles;
    private List<Card> cards;


    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Bicycle> getBicycles() {
        return bicycles;
    }

    public void setBicycles(List<Bicycle> bicycles) {
        this.bicycles = bicycles;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "MyVelibSystem{" +
                "stations=" + stations +
                ", users=" + users +
                ", bicycles=" + bicycles +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyVelibSystem that = (MyVelibSystem) o;
        return Objects.equals(stations, that.stations) &&
                Objects.equals(users, that.users) &&
                Objects.equals(bicycles, that.bicycles) &&
                Objects.equals(cards, that.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stations, users, bicycles, cards);
    }
}
