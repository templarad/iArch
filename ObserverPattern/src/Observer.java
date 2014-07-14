public class Observer {
	private Subject subject;
	public Observer(Subject subject){
		this.subject = subject;
	}
	public void update(){
		System.out.println("Observer.update()");
		State state = subject.getState();
	}
}