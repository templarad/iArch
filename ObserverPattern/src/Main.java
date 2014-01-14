
public class Main {

	public static void main(String[] args) {
		Subject subject = new Subject();
		Observer observer = new Observer(subject);
		subject.addObserver(observer);
		
		subject.setState(State.START);
		
		subject.setState(State.END);
	}
}
