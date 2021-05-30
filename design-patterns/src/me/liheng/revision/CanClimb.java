package me.liheng.revision;

// 1. An abstract class can implement an interface without implementing any of the abstract methods
// 2. Revision: Rule of overriding: Access modifier must be the same or more accessible
public interface CanClimb {
    public abstract void climb();
}

interface CanClimbTrees extends CanClimb {}

abstract class Chipmunk implements CanClimbTrees {
    public abstract void chew();
}

class EasternChipmunk extends Chipmunk {
    @Override
    public void climb() {
        //no-op
    }
    @Override
    public void chew() {
        //no-op
    }
}
