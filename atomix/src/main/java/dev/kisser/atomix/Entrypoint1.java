package dev.kisser.atomix;

import io.atomix.cluster.Node;
import io.atomix.cluster.discovery.BootstrapDiscoveryProvider;
import io.atomix.core.Atomix;
import io.atomix.core.AtomixBuilder;
import io.atomix.core.list.DistributedList;
import io.atomix.core.lock.DistributedLock;
import io.atomix.core.map.DistributedMap;
import io.atomix.core.profile.Profile;
import io.atomix.core.value.DistributedValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Entrypoint1 {
    public static void main(String[] args) throws InterruptedException {

        Logger log = LoggerFactory.getLogger(Entrypoint1.class);

        AtomixBuilder builder = Atomix.builder();
        Atomix atomix;
        atomix = builder.withMemberId("member1")
                .withAddress("localhost:13370")
                .addProfile(Profile.dataGrid())
                .withMembershipProvider(BootstrapDiscoveryProvider.builder()
                        .withNodes(
                                Node.builder()
                                        .withId("member1")
                                        .withAddress("localhost:13370")
                                        .build(),
                                Node.builder()
                                        .withId("member2")
                                        .withAddress("localhost:13371")
                                        .build())
                        .build())
                .build();

        atomix.start().join();


        DistributedList<Object> list = atomix.getList("kappa-list");
        DistributedLock lock = atomix.getLock("kappa-lock");

        log.info("Starting benchmark...");
        while(true){

            lock.tryLock();
            if(lock.isLocked()){
                break;
            }
        }
        for(int i = 0; i < 10000; i++){
            list.add("Kappa-" + i);
        }
        lock.unlock();
        log.info("Benchmark completed.");
    }
}
