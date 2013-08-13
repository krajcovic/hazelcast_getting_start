package cz.krajcovic.hazelcast.GettingStarted;
import java.util.Collection;

import com.hazelcast.config.Config;
import com.hazelcast.core.DistributedObject;
import com.hazelcast.core.DistributedObjectEvent;
import com.hazelcast.core.DistributedObjectListener;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;


public class Sample implements DistributedObjectListener {

	public void distributedObjectCreated(DistributedObjectEvent event) {
		DistributedObject instance = event.getDistributedObject();
		System.out.println("Created " + instance.getName() + ", " + instance.getId());

	}

	public void distributedObjectDestroyed(DistributedObjectEvent event) {
		DistributedObject instance = event.getDistributedObject();
		System.out.println("Destroyed " + instance.getName() + ", " + instance.getId());

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sample sample = new Sample();
		
		Config cfg = new Config();
		HazelcastInstance hz = Hazelcast.newHazelcastInstance(cfg);
		hz.addDistributedObjectListener(sample);
		
		Collection<DistributedObject> distributedObjects = hz.getDistributedObjects();
		
		for (DistributedObject distributedObject : distributedObjects) {
			System.out.println(distributedObject.getName() + ", " + distributedObject.getId());
		}

	}

}
