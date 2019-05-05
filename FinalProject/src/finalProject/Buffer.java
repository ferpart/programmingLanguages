
package finalProject;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public class Buffer {
    
    private int capacity;
    private LinkedList<Operation> buffer = new LinkedList<>(); 
    private GUIFrame guiReference;
       
    Buffer(int capacity, GUIFrame guiReference) {
        this.capacity = capacity;
        this.guiReference=guiReference;
        
    }
    
    synchronized Operation consume() {
        
        Operation product = null;

        if(this.getBufferSize() == 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        product = this.getBuffer().removeFirst();
        synchronized (this){
            guiReference.removeTareasProducerRow();
            guiReference.setPercentage((this.buffer.size() * 100)/ this.capacity);
        }
        notify();
        
        return product;
    }
    
    synchronized void produce(Operation product) {
        if(this.getBufferSize() >= this.getCapacity()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.getBuffer().add(product);
        synchronized (this){
            guiReference.setTareasProducer(product.getId(), product.getOperationString());
            guiReference.setPercentage((this.buffer.size() * 100)/ this.capacity);
        }
        notify();
    }
    
    static int count = 1;
    synchronized static void print(String string) {
        System.out.print(count++ + " ");
        System.out.println(string);
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @return the buffer
     */
    public LinkedList<Operation> getBuffer() {
        return buffer;
    }
    
    /**
     * @return the buffer size
     */
    public int getBufferSize() {
        return buffer.size();
    }
}
