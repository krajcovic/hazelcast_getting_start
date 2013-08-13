package cz.krajcovic.hazelcast.GettingStarted;

import java.util.Queue;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * Hello world!
 *
 */
public class GettingStartedServer 
{
    public static void main( String[] args )
    {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        IMap<Integer, String> mapCustomers = instance.getMap("customers");
        mapCustomers.put(1, "Joe");
        mapCustomers.put(2, "Ali");
        mapCustomers.put(3, "Avi");
        
        System.out.println("Cusomer with key 1: " + mapCustomers.get(1));
        System.out.println("Map size:" + mapCustomers.size());
        
        Queue<String> queueCustomers = instance.getQueue("customers");
        queueCustomers.offer("Tom");
    	queueCustomers.offer("Mary");
    	queueCustomers.offer("Jane");
        System.out.println("First customer: " + queueCustomers.poll());
        System.out.println("Second customer: " + queueCustomers.peek());
        System.out.println("Queue size: " + queueCustomers.size());
        
    }
}
