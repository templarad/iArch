public class Subject {	
Observer observer = new Observer();
public void addObserver( Observer observer ){
}
public void removeObserver( Observer observer ){
}
public void _notify(){
		observer.update();
}
public String getState(){
		return null;
}
public void setState( String state ){
		_notify();
} 
}
