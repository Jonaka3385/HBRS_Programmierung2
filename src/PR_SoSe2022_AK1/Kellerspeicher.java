package PR_SoSe2022_AK1;

import java.util.Vector;

public class Kellerspeicher<T> extends Vector<T> {
    // isEmpty aus Vector

    /*
     *  Gibt das oberste Element aus
     */
    public T peek(){
        return get(0);
    }

    /*
     *  Entfernt das oberste Element und gibt es aus
     */
    public T pop(){
        return remove(0);
    }

    /*
     *  Fuegt ein neues Element hinzu
     */
    public void push(T e){
        add(0, e);
    }
}
