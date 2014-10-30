import java.util.ArrayList;
import java.util.List;
 public class Subject {
	private List<Observer> observers;
	private State state = State.INIT;
	public Subject(){
		observers = new ArrayList<>();
		state = State.IDEL;
	}

	public State getState(){
		return this.state;
	}
	public void setState(State state){
		this.state = state;
		for(Observer o : this.observers){
			o.update();
		} 
	}
	public void addObserver(Observer observer){
		this.observers.add(observer);
	}
	public void removeObserver(Observer observer){
		this.observers.remove(observer);
	}
}